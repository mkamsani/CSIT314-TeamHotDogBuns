package com.hotdog.ctbs.repository;

import com.hotdog.ctbs.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, UUID> {
    List<UserProfile> findUserProfilesByTitle(String s);

    List<UserProfile> findUserProfilesByPrivilege(String privilege);

    UserProfile findUserProfileByTitle(String s);
}