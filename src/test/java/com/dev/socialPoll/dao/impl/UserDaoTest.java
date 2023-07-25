package com.dev.socialPoll.dao.impl;

import com.dev.socialPoll.dao.connection.ConnectionPool;
import com.dev.socialPoll.entity.User;
import com.dev.socialPoll.entity.UserRole;
import com.dev.socialPoll.exception.ConnectionException;
import com.dev.socialPoll.exception.DaoException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserDaoTest {
    private static UserDaoImpl userDao;

    @BeforeAll
    static void setUp() throws ConnectionException {
        ConnectionPool.getInstance().initialize(); // Initialize the connection pool
        userDao = new UserDaoImpl();
    }

    @Test
    void testSaveUser() throws DaoException {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setBirthday(LocalDate.of(1990, 5, 15));
        user.setGender("Male");
        user.setEmail("john.doe@example.com");
        user.setPassword("password");
        user.setRole(UserRole.USER);

        long savedUserId = userDao.save(user);
        assertTrue(savedUserId > 0);

        userDao.deleteById(savedUserId);
    }

    @Test
    void testFindByEmail() throws DaoException {
        String email = "lazizo2004@gmail.com";
        Optional<User> userOptional = userDao.findByEmail(email);
        assertTrue(userOptional.isPresent(), "User with email " + email + " not found.");

        User user = userOptional.get();
        assertEquals(email, user.getEmail(), "Unexpected email for user with ID " + user.getId());
    }

    @Test
    void testFindByEmailAndPassword() throws DaoException {
        // Assume that there is a user with the email "test@example.com" and password "password" in the database
        String email = "lazizo2004@gmail.com";
        String password = "admin";
        Optional<User> userOptional = userDao.findByEmailAndPassword(email, password);
        assertTrue(userOptional.isPresent());

        User user = userOptional.get();
        assertEquals(email, user.getEmail());
        assertEquals(password, user.getPassword());
    }
}
