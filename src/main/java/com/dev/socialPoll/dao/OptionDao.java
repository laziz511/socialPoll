package com.dev.socialPoll.dao;

import com.dev.socialPoll.entity.Option;
import com.dev.socialPoll.exception.DaoException;

import java.util.List;
import java.util.Optional;

/**
 * The OptionDao interface provides the methods to interact with the database table for Option entities.
 */
public interface OptionDao {

    /**
     * Saves an Option entity into the database table.
     *
     * @param option The Option object to save.
     * @return The ID of the newly saved Option.
     * @throws DaoException If an error occurs while saving the Option to the database.
     */
    long save(Option option) throws DaoException;

    /**
     * Retrieves an Option entity from the database table by its ID.
     *
     * @param id ID of the Option to find.
     * @return An optional containing the Option object if found, or an empty optional if not found.
     * @throws DaoException If an error occurs while fetching the data from the database.
     */
    Optional<Option> findById(long id) throws DaoException;

    /**
     * Retrieves a list of Option entities from the database table based on the provided Question ID.
     *
     * @param questionId ID of the Question associated with the Option entities to retrieve.
     * @return A list of Option entities associated with the specified Question ID.
     * @throws DaoException If an error occurs while fetching the data from the database.
     */
    List<Option> findByQuestionId(long questionId) throws DaoException;

    /**
     * Updates the number of participants for an Option entity in the database table.
     *
     * @param optionId ID of the Option for which to update the number of participants.
     * @throws DaoException If an error occurs while updating the data in the database.
     */
    void updateNumParticipants(long optionId) throws DaoException;

    /**
     * Deletes an Option entity from the database table based on its ID.
     *
     * @param optionId ID of the Option to delete.
     * @throws DaoException If an error occurs while deleting the Option from the database.
     */
    void delete(long optionId) throws DaoException;
}
