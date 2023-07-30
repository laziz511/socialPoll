package com.dev.socialPoll.service;

import com.dev.socialPoll.entity.Topic;
import com.dev.socialPoll.exception.ServiceException;

import java.util.List;
import java.util.Optional;

/**
 * TopicService is responsible for managing topics in the social poll application.
 * It provides methods to retrieve topics, retrieve a topic by its ID, update the number of polls for a topic,
 * and increment the number of participants for a topic.
 */
public interface TopicService {

    /**
     * Retrieves a list of all topics.
     *
     * @return A list of all topics.
     * @throws ServiceException If an error occurs while retrieving the topics.
     */
    List<Topic> retrieveTopics() throws ServiceException;

    /**
     * Retrieves a topic by its ID.
     *
     * @param topicId The ID of the topic to retrieve.
     * @return An optional containing the topic with the specified ID if it exists, or an empty optional otherwise.
     * @throws ServiceException If an error occurs while retrieving the topic.
     */
    Optional<Topic> retrieveTopicById(long topicId) throws ServiceException;

    /**
     * Updates the number of polls for a topic.
     *
     * @param topicId The ID of the topic for which the number of polls needs to be updated.
     * @throws ServiceException If an error occurs while updating the number of polls for the topic.
     */
    void updateNumPollsForTopic(long topicId) throws ServiceException;

    /**
     * Increments the number of participants for a topic.
     *
     * @param topicId The ID of the topic for which the number of participants needs to be incremented.
     * @throws ServiceException If an error occurs while incrementing the number of participants for the topic.
     */
    void incrementNumParticipantsForTopic(long topicId) throws ServiceException;

}