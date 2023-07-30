package com.dev.socialPoll.service;

import com.dev.socialPoll.entity.User;
import com.dev.socialPoll.entity.UserRole;
import com.dev.socialPoll.exception.ServiceException;

import java.time.LocalDate;
import java.util.Optional;

/**
 * UserService is responsible for managing user-related operations in the social poll application.
 * It provides methods for user login and registration.
 */
public interface UserService {

    /**
     * Performs user login.
     *
     * @param email    The email of the user.
     * @param password The password of the user.
     * @return An optional containing the user if login is successful, or an empty optional if login fails.
     * @throws ServiceException If an error occurs during the login process.
     */
    Optional<User> login(String email, String password) throws ServiceException;

    /**
     * Performs user registration.
     *
     * @param firstName The first name of the user.
     * @param lastName  The last name of the user.
     * @param birthday  The birthday of the user.
     * @param gender    The gender of the user.
     * @param email     The email of the user.
     * @param password  The password of the user.
     * @param role      The role of the user.
     * @return True if registration is successful, false otherwise.
     * @throws ServiceException If an error occurs during the registration process.
     */
    boolean register(String firstName, String lastName, LocalDate birthday, String gender,
                     String email, String password, UserRole role) throws ServiceException;
}
