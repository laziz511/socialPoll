package com.dev.socialPoll.dao;

import com.dev.socialPoll.entity.Poll;
import com.dev.socialPoll.exception.DaoException;

import java.util.List;
import java.util.Optional;

/**
 * The PollDao interface provides the methods to interact with the database table for Poll entities.
 */
public interface PollDao {

    /**
     * Saves a Poll entity into the database table.
     *
     * @param poll The Poll object to save.
     * @return The ID of the newly saved Poll.
     * @throws DaoException If an error occurs while saving the Poll to the database.
     */
    long save(Poll poll) throws DaoException;

    /**
     * Retrieves a Poll entity from the database table by its ID.
     *
     * @param id ID of the Poll to find.
     * @return An optional containing the Poll object if found, or an empty optional if not found.
     * @throws DaoException If an error occurs while fetching the data from the database.
     */
    Optional<Poll> findById(long id) throws DaoException;

    /**
     * Retrieves a list of Poll entities from the database table based on the provided Topic ID.
     *
     * @param topicId ID of the Topic associated with the Poll entities to retrieve.
     * @return A list of Poll entities associated with the specified Topic ID.
     * @throws DaoException If an error occurs while fetching the data from the database.
     */
    List<Poll> findByTopicId(long topicId) throws DaoException;

    /**
     * Counts the number of questions in a Poll.
     *
     * @param pollId ID of the Poll for which to count the questions.
     * @return The number of questions in the Poll.
     * @throws DaoException If an error occurs while counting the questions in the Poll.
     */
    int countQuestionsInPoll(long pollId) throws DaoException;

    /**
     * Counts the number of participants in a Poll.
     *
     * @param pollId ID of the Poll for which to count the participants.
     * @return The number of participants in the Poll.
     * @throws DaoException If an error occurs while counting the participants in the Poll.
     */
    int countParticipantsInPoll(long pollId) throws DaoException;

    /**
     * Increments the number of participants for a Poll entity in the database table.
     *
     * @param pollId ID of the Poll for which to increment the number of participants.
     * @return True if the increment is successful, false otherwise.
     * @throws DaoException If an error occurs while updating the data in the database.
     */
    boolean incrementNumParticipants(long pollId) throws DaoException;

    /**
     * Retrieves a list of Poll entities from the database table based on the creator's ID.
     *
     * @param creatorId ID of the creator associated with the Poll entities to retrieve.
     * @return A list of Poll entities associated with the specified creator's ID.
     * @throws DaoException If an error occurs while fetching the data from the database.
     */
    List<Poll> getPollsByCreatorId(long creatorId) throws DaoException;

    /**
     * Updates a Poll entity in the database table.
     *
     * @param poll The Poll object to update.
     * @return True if the update is successful, false otherwise.
     * @throws DaoException If an error occurs while updating the data in the database.
     */
    boolean update(Poll poll) throws DaoException;

    /**
     * Decreases the number of questions in a Poll entity in the database table.
     *
     * @param pollId      ID of the Poll for which to decrease the number of questions.
     * @param decreaseNum The number of questions to decrease.
     * @return True if the decrease is successful, false otherwise.
     * @throws DaoException If an error occurs while updating the data in the database.
     */
    boolean decreaseNumberOfQuestions(long pollId, int decreaseNum) throws DaoException;
}
