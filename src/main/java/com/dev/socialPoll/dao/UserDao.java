package com.dev.socialPoll.dao;

import com.dev.socialPoll.entity.User;
import com.dev.socialPoll.exception.DaoException;

import java.util.Optional;

/**
 * The UserDao interface provides the methods to interact with the database table for User entities.
 */
public interface UserDao {

    /**
     * Saves a User entity into the database table.
     *
     * @param user The User object to save.
     * @return The ID of the newly saved User.
     * @throws DaoException If an error occurs while saving the User to the database.
     */
    long save(User user) throws DaoException;

    /**
     * Retrieves a User entity from the database table based on the provided email.
     *
     * @param email The email of the User to find.
     * @return An Optional containing the User object if found, or an empty Optional if not found.
     * @throws DaoException If an error occurs while fetching the data from the database.
     */
    Optional<User> findByEmail(String email) throws DaoException;

    /**
     * Retrieves a User entity from the database table based on the provided email and password.
     *
     * @param email The email of the User to find.
     * @param password The password of the User to find.
     * @return An Optional containing the User object if found, or an empty Optional if not found.
     * @throws DaoException If an error occurs while fetching the data from the database.
     */
    Optional<User> findByEmailAndPassword(String email, String password) throws DaoException;

    /**
     * Retrieves a User entity from the database table based on the provided user ID.
     *
     * @param userId The ID of the User to find.
     * @return An Optional containing the User object if found, or an empty Optional if not found.
     * @throws DaoException If an error occurs while fetching the data from the database.
     */
    Optional<User> findById(long userId) throws DaoException;

    /**
     * Deletes a User entity from the database table based on the provided user ID.
     *
     * @param userId The ID of the User to delete.
     * @throws DaoException If an error occurs while deleting the User from the database.
     */
    void deleteById(long userId) throws DaoException;
}
