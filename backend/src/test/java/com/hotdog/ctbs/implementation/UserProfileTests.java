package com.hotdog.ctbs.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.hotdog.ctbs.entity.*;
import com.hotdog.ctbs.service.implementation.*;
import org.springframework.util.Assert;

import java.util.UUID;

/**
 * Tests for {@link UserProfileImpl}.
 */
@SpringBootTest
public class UserProfileTests {

    @Autowired
    private UserProfileImpl userProfileImpl;

    static long testStarter()
    {
        // Print "TEST START" in yellow.
        if (System.getProperty("os.name").toLowerCase().contains("windows"))
            System.out.printf("%n\033[33mTEST START\033[0m%n%n");
        else
            System.out.printf("%n\u001B[33mTEST START\u001B[0m%n%n");
        return System.currentTimeMillis();
    }

    static void testEnder(long time)
    {
        if (System.getProperty("os.name").toLowerCase().contains("windows"))
            System.out.printf("\033[33mTime elapsed: %d ms\033[0m%n%n", System.currentTimeMillis() - time);
        else
            System.out.printf("\u001B[33mTime elapsed: %d ms\u001B[0m%n%n", System.currentTimeMillis() - time);
    }

    /** The "U" in "CRUD". */
    @Test
    void getters()
    {
        long time = testStarter();

        System.out.println("userProfileImpl.getAllTitles()");
        System.out.println(userProfileImpl.getAllTitles());
        System.out.println();

        System.out.println("userProfileImpl.getAllPrivileges()");
        System.out.println(userProfileImpl.getAllPrivileges());
        System.out.println();

        System.out.println("userProfileImpl.getValidPrivileges()");
        System.out.println(userProfileImpl.getValidPrivileges());
        System.out.println();

        System.out.println("userProfileImpl.getUserProfilesByPrivilege(\"admin\")");
        System.out.println(userProfileImpl.getUserProfilesByPrivilege("admin"));
        System.out.println();

        System.out.println("userProfileImpl.getUserProfileByTitle(\"Customer\")");
        UserProfile getUserProfileByTitle = userProfileImpl.getUserProfileByTitle("Customer");
        System.out.println(getUserProfileByTitle);
        System.out.println();

        System.out.println("userProfileImpl.getUserProfileById(id)");
        UUID getUserProfileById = getUserProfileByTitle.getId();
        System.out.println(userProfileImpl.getUserProfileById(getUserProfileById));
        System.out.println();

        System.out.println("userProfileImpl.getIdByTitle(\"Customer\")");
        UUID getIdByTitle = userProfileImpl.getIdByTitle("Customer");
        System.out.println(getIdByTitle);
        System.out.println();

        // Perform equality check for the previous two methods.
        System.out.println("getUserProfileById.equals(getIdByTitle)");
        System.out.println(getUserProfileById.equals(getIdByTitle));
        System.out.println();

        // Asserts.
        Assert.isTrue(
                getUserProfileByTitle.getTitle().equals("Customer"),
                "getUserProfileByTitle.getTitle() is not \"Customer\""
        );
        Assert.isTrue(
                getUserProfileByTitle.getPrivilege().equals("customer"),
                "getUserProfileByTitle.getPrivilege() is not \"Customer\""
        );
        Assert.isTrue(
                getUserProfileById.equals(getIdByTitle),
                "getUserProfileById is not getIdByTitle"
        );

        testEnder(time);
    }

    /** The "CUD" in "CRUD". */
    @Test
    void others()
    {
        long time = testStarter();

        Runnable getAllTitles = () -> {
            System.out.println("userProfileImpl.getAllTitles()");
            System.out.println(userProfileImpl.getAllTitles());
            System.out.println();
        };

        System.out.println("userProfileImpl.createByTitle(\"Test Manager\", \"manager\")");
        userProfileImpl.createUserProfile("manager", "Test Manager");
        System.out.println();
        getAllTitles.run();

        System.out.println("userProfileImpl.updateOneTitle(\"Test Manager\", \"Test Manager Updated\")");
        userProfileImpl.updateOneByTitle("Test Manager", "Test Manager Updated");
        System.out.println();
        getAllTitles.run();

        System.out.println("userProfileImpl.updateOnePrivilege(\"Test Manager Updated\", \"admin\")");
        userProfileImpl.updateOneByPrivilege("Test Manager Updated", "admin");
        System.out.println();
        getAllTitles.run();

        System.out.println("userProfileImpl.deleteByTitle(\"Test Manager Updated\")");
        userProfileImpl.suspendOneByTitle("Test Manager Updated");
        System.out.println();
        getAllTitles.run();

        testEnder(time);
    }

    @Test
    void json() throws JsonProcessingException
    {
        long time = testStarter();
        testEnder(time);
    }
}