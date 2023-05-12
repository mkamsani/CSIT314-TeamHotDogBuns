package com.hotdog.ctbs.service.implementation;

import com.hotdog.ctbs.entity.UserProfile;
import com.hotdog.ctbs.repository.UserProfileRepository;
import org.springframework.stereotype.Service;
import com.hotdog.ctbs.service.UserProfileService;

import java.util.List;
import java.util.UUID;

/**
 * CRUD for user profiles.
 *
 * @see com.hotdog.ctbs.entity.UserProfile
 */
@Service
public class UserProfileImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public UserProfileImpl(UserProfileRepository userProfileRepository)
    {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public void create(String privilege, String title)
    {
        for (String s : getAllTitles())
            if (s.equalsIgnoreCase(title))
                throw new IllegalArgumentException("Title already exists.");
        for (String s : new String[]{ "admin", "owner", "manager", "customer",
                                      "titles", "privileges", "active", "all"
        }) if (s.equalsIgnoreCase(title))
            throw new IllegalArgumentException("Reserved title.");
        if (privilege.equals("customer"))
            throw new IllegalArgumentException("Reserved privilege.");
        if (!getValidPrivileges().contains(privilege))
            throw new IllegalArgumentException("Invalid privilege.");
        if (!title.matches("^[a-zA-Z ]+$"))
            throw new IllegalArgumentException("Title must contain only letters and spaces.");

        title = title.strip().replaceAll("\\s+", " ");

        userProfileRepository.save(
                UserProfile.builder()
                           .id(UUID.randomUUID())
                           .privilege(privilege)
                           .title(title)
                           .isActive(true)
                           .build()
        );
    }

    @Override
    public List<UserProfile> getActiveUserProfiles()
    {
        return userProfileRepository.findAll().stream()
                                    .filter(UserProfile::getIsActive)
                                    .toList();
    }

    @Override
    public List<UserProfile> getAllUserProfiles()
    {
        return userProfileRepository.findAll();
    }

    @Override
    public List<UserProfile> getAllUserProfilesByPrivilege(String privilege)
    {
        return userProfileRepository.findAll().stream()
                                    .filter(userProfile -> userProfile.getPrivilege().equals(privilege))
                                    .toList();
    }

    /** @deprecated */
    @Override
    public List<String> getAllTitles()
    {
        return userProfileRepository.findAll().stream()
                                    .map(UserProfile::getTitle)
                                    .toList();
    }

    /** @deprecated */
    @Override
    public List<String> getAllPrivileges()
    {
        return userProfileRepository.findAll().stream()
                                    .map(UserProfile::getPrivilege)
                                    .distinct()
                                    .toList();
    }

    /** @deprecated */
    @Override
    public List<String> getValidPrivileges()
    {
        return userProfileRepository.findAll().stream()
                                    .map(UserProfile::getPrivilege)
                                    .distinct()
                                    .filter(privilege -> !privilege.equals("customer"))
                                    .toList();
    }

    @Override
    public List<UserProfile> getUserProfilesByPrivilege(final String privilege)
    {
        return userProfileRepository.findAll().stream()
                                    .filter(userProfile -> userProfile.getPrivilege().equals(privilege))
                                    .toList();
    }

    @Override
    public UserProfile getUserProfileByTitle(final String title)
    {
        return userProfileRepository.findUserProfileByTitle(title).orElseThrow(
                () -> new IllegalArgumentException("User profile not found.")
        );
    }

    @Override
    public String suspend(String targetTitle)
    {
        UserProfile userProfile = userProfileRepository.findUserProfileByTitle(targetTitle).orElse(null);
        if (userProfile == null)
            return "Not found.";
        if (!userProfile.getIsActive())
            return targetTitle + " is already suspended.";

        userProfile.setIsActive(false);
        userProfileRepository.save(userProfile);

        int size = userProfile.getUserAccounts().size();
        if (size == 0)
            return targetTitle + " has been suspended.";
        else
            return targetTitle + " has been suspended. " + size + " user account(s) have been suspended.";
    }

    @Override
    public void update(String targetTitle, String privilege, String title)
    {
        UserProfile userProfile = userProfileRepository.findUserProfileByTitle(targetTitle).orElse(null);
        if (userProfile == null)
            throw new IllegalArgumentException("User profile not found.");
        if (title.equals("Customer"))
            throw new IllegalArgumentException("Cannot modify Customer.");
        if (privilege.equals("customer"))
            throw new IllegalArgumentException("Reserved privilege.");
        if (!getValidPrivileges().contains(privilege))
            throw new IllegalArgumentException("Invalid privilege.");
        if (!title.matches("^[a-zA-Z ]+$"))
            throw new IllegalArgumentException("Title must contain only letters and spaces.");

        title = title.strip().replaceAll("\\s+", " ");

        userProfile.setPrivilege(privilege);
        userProfile.setTitle(title);
        userProfileRepository.save(userProfile);
    }
}
