package com.dev.socialPoll.dao;

import com.dev.socialPoll.entity.Question;
import com.dev.socialPoll.exception.DaoException;

import java.util.List;
import java.util.Optional;

/**
 * The QuestionDao interface provides the methods to interact with the database table for Question entities.
 */
public interface QuestionDao {

    /**
     * Saves a Question entity into the database table.
     *
     * @param question The Question object to save.
     * @return The ID of the newly saved Question.
     * @throws DaoException If an error occurs while saving the Question to the database.
     */
    long save(Question question) throws DaoException;

    /**
     * Retrieves a Question entity from the database table based on the provided ID.
     *
     * @param id ID of the Question to find.
     * @return An Optional containing the Question object if found, or an empty Optional if not found.
     * @throws DaoException If an error occurs while fetching the data from the database.
     */
    Optional<Question> findById(long id) throws DaoException;

    /**
     * Retrieves a list of Question entities from the database table based on the provided poll ID.
     *
     * @param pollId ID of the poll associated with the Question entities to retrieve.
     * @return A list of Question entities associated with the specified poll ID.
     * @throws DaoException If an error occurs while fetching the data from the database.
     */
    List<Question> findByPollId(long pollId) throws DaoException;

    /**
     * Updates a Question entity in the database table.
     *
     * @param question The Question object to update.
     * @return A list of updated Question entities.
     * @throws DaoException If an error occurs while updating the Question in the database.
     */
    List<Question> update(Question question) throws DaoException;

    /**
     * Deletes a Question entity from the database table based on its ID.
     *
     * @param questionId ID of the Question to delete.
     * @throws DaoException If an error occurs while deleting the Question from the database.
     */
    void delete(long questionId) throws DaoException;
}
