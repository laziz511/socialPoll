package com.dev.socialPoll.dao;

import com.dev.socialPoll.entity.PollResponse;
import com.dev.socialPoll.exception.DaoException;

import java.util.List;

/**
 * The PollResponseDao interface provides the methods to interact with the database table for PollResponse entities.
 */
public interface PollResponseDao {

    /**
     * Saves a PollResponse entity into the database table.
     *
     * @param pollResponse The PollResponse object to save.
     * @return The ID of the newly saved PollResponse.
     * @throws DaoException If an error occurs while saving the PollResponse to the database.
     */
    long save(PollResponse pollResponse) throws DaoException;

    /**
     * Checks if a PollResponse exists for the given user and poll.
     *
     * @param userId ID of the user associated with the PollResponse.
     * @param pollId ID of the poll associated with the PollResponse.
     * @return True if a PollResponse exists for the given user and poll, false otherwise.
     * @throws DaoException If an error occurs while fetching the data from the database.
     */
    boolean isPollResponseExist(long userId, long pollId) throws DaoException;

    /**
     * Retrieves a list of poll IDs for which the user has responded.
     *
     * @param userId ID of the user for which to retrieve the poll IDs.
     * @return A list of poll IDs for which the user has responded.
     * @throws DaoException If an error occurs while fetching the data from the database.
     */
    List<Long> getPollIdsByUserId(long userId) throws DaoException;

    /**
     * Retrieves a list of PollResponse entities from the database table based on the provided question ID.
     *
     * @param questionId ID of the question associated with the PollResponse entities to retrieve.
     * @return A list of PollResponse entities associated with the specified question ID.
     * @throws DaoException If an error occurs while fetching the data from the database.
     */
    List<PollResponse> findByQuestionId(long questionId) throws DaoException;

    /**
     * Deletes a PollResponse entity from the database table based on its ID.
     *
     * @param id ID of the PollResponse to delete.
     * @throws DaoException If an error occurs while deleting the PollResponse from the database.
     */
    void delete(long id) throws DaoException;

    /**
     * Retrieves a list of IDs representing the options selected by a specific user in a given poll.
     *
     * @param pollId The ID of the poll for which user responses are to be retrieved.
     * @param userId The ID of the user for whom the responses are to be retrieved.
     * @return A list of option IDs representing the user's selected responses in the specified poll.
     * @throws DaoException If an error occurs while retrieving the user's responses from the database.
     */
    List<Long> getUserResponses(long pollId, long userId) throws DaoException;

}
