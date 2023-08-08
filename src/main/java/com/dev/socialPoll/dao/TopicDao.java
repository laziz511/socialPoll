package com.dev.socialPoll.dao;

import com.dev.socialPoll.entity.Topic;
import com.dev.socialPoll.exception.DaoException;

import java.util.List;
import java.util.Optional;

/**
 * The TopicDao interface provides the methods to interact with the database table for Topic entities.
 */
public interface TopicDao extends Dao<Topic> {

    /**
     * Saves a Topic entity into the database table.
     *
     * @param topic The Topic object to save.
     * @return The ID of the newly saved Topic.
     * @throws DaoException If an error occurs while saving the Topic to the database.
     */
    long save(Topic topic) throws DaoException;

    /**
     * Retrieves a Topic entity from the database table based on the provided ID.
     *
     * @param id ID of the Topic to find.
     * @return An Optional containing the Topic object if found, or an empty Optional if not found.
     * @throws DaoException If an error occurs while fetching the data from the database.
     */
    Optional<Topic> findById(long id) throws DaoException;

    /**
     * Retrieves a list of all Topic entities from the database table.
     *
     * @return A list of all Topic entities in the table.
     * @throws DaoException If an error occurs while fetching the data from the database.
     */
    List<Topic> findAll() throws DaoException;

    /**
     * Updates a Topic entity in the database table.
     *
     * @param topic The Topic object to update.
     * @throws DaoException If an error occurs while updating the Topic in the database.
     */
    void update(Topic topic) throws DaoException;

    /**
     * Increments the number of participants for a Topic entity in the database table.
     *
     * @param topicId ID of the Topic for which the number of participants will be incremented.
     * @throws DaoException If an error occurs while incrementing the number of participants in the database.
     */
    void incrementNumParticipants(long topicId) throws DaoException;

    /**
     * Decreases the number of participants for a Topic entity in the database table.
     *
     * @param topicId        ID of the Topic for which the number of participants will be decreased.
     * @param numParticipants The number of participants to be decreased.
     * @throws DaoException If an error occurs while decreasing the number of participants in the database.
     */
    void decreaseNumParticipants(long topicId, int numParticipants) throws DaoException;

    /**
     * Decreases the number of polls for a Topic entity in the database table.
     *
     * @param topicId ID of the Topic for which the number of polls will be decreased.
     * @throws DaoException If an error occurs while decreasing the number of polls in the database.
     */
    void decreaseNumPolls(long topicId) throws DaoException;
}
