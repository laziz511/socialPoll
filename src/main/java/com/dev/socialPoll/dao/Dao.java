package com.dev.socialPoll.dao;

import com.dev.socialPoll.exception.DaoException;

import java.util.List;
import java.util.Optional;

/**
 * The Dao interface provides the basic operations to interact with a database table for a specific entity type.
 *
 * @param <T> The entity type that the DAO operates on.
 */
public interface Dao<T> {

    /**
     * Retrieves all entities from the database table.
     *
     * @return List of all entities in the table.
     * @throws DaoException If an error occurs while fetching the data from the database.
     */
    List<T> findAll() throws DaoException;

    /**
     * Retrieves an entity object from the database table by its ID.
     *
     * @param id ID of the entity to find.
     * @return An optional containing the entity object if found, or an empty optional if not found.
     * @throws DaoException If an error occurs while fetching the data from the database.
     */
    Optional<T> findById(long id) throws DaoException;

    /**
     * Saves an entity into the database table.
     *
     * @param item The entity object to save.
     * @return The ID of the newly saved entity.
     * @throws DaoException If an error occurs while saving the entity to the database.
     */
    long save(T item) throws DaoException;

}