package com.dev.socialPoll.service.impl;

import com.dev.socialPoll.entity.User;

import com.dev.socialPoll.exception.DaoException;
import com.dev.socialPoll.exception.ServiceException;
import com.dev.socialPoll.service.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserServiceTest {

    private static UserService userService;

    @BeforeAll
    static void setUp() {
        userService = new UserServiceImpl();
    }

    @Test
    void testLogin_ShouldReturnUserWhenCredentialsAreCorrect() throws ServiceException, DaoException {
        // Call the service method with correct email and password
        String email = "lazizo2004@gmail.com";
        String password = "admin";
        Optional<User> userOptional = userService.login(email, password);

        // Verify the result
        assertTrue(userOptional.isPresent());
        User user = userOptional.get();
        assertEquals(email, user.getEmail());
        assertEquals("Laziz", user.getFirstName());
        assertEquals("Djuraev", user.getLastName());
    }

    @Test
    void testLogin_ShouldReturnEmptyOptionalWhenCredentialsAreIncorrect() throws ServiceException, DaoException {
        // Call the service method with incorrect email and password
        String email = "wrong.email@example.com";
        String password = "wrongpassword";
        Optional<User> userOptional = userService.login(email, password);

        // Verify the result
        assertFalse(userOptional.isPresent());
    }
}
