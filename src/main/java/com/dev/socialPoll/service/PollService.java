package com.dev.socialPoll.service;

import com.dev.socialPoll.entity.Poll;
import com.dev.socialPoll.exception.ServiceException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * PollService is responsible for managing polls in the social poll application.
 * It provides methods to retrieve polls by topic, retrieve poll by ID, add a new poll,
 * update poll information, check if a user has responded to a poll, increment the number of participants,
 * decrease the number of questions, and get polls created by a specific user.
 */
public interface PollService {

    /**
     * Retrieves a list of polls belonging to a specific topic.
     *
     * @param topicId The ID of the topic for which polls need to be retrieved.
     * @return A list of polls belonging to the specified topic.
     * @throws ServiceException If an error occurs while retrieving the polls.
     */
    List<Poll> retrievePollsByTopic(long topicId) throws ServiceException;

    /**
     * Retrieves a poll by its ID.
     *
     * @param pollId The ID of the poll to retrieve.
     * @return An Optional containing the retrieved poll, or an empty Optional if the poll is not found.
     * @throws ServiceException If an error occurs while retrieving the poll.
     */
    Optional<Poll> retrievePollById(long pollId) throws ServiceException;

    /**
     * Adds a new poll to the database.
     *
     * @param topicId           The ID of the topic to which the poll belongs.
     * @param pollName          The name of the poll.
     * @param description       The description of the poll.
     * @param questionCount     The number of questions in the poll.
     * @param questionOptionsMap A map containing the question texts as keys and lists of answer options as values.
     * @param creatorId         The ID of the user who creates the poll.
     * @return true if the poll was successfully added, false otherwise.
     * @throws ServiceException If an error occurs while adding the poll.
     */
    boolean addNewPoll(long topicId, String pollName, String description, int questionCount, Map<String, List<String>> questionOptionsMap, long creatorId)
            throws ServiceException;

    /**
     * Updates the information of an existing poll.
     *
     * @param pollId             The ID of the poll to update.
     * @param pollName           The new name of the poll.
     * @param description        The new description of the poll.
     * @param questionCount      The new number of questions in the poll.
     * @param questionOptionsMap A map containing the question texts as keys and lists of answer options as values.
     * @return true if the poll information was successfully updated, false otherwise.
     * @throws ServiceException If an error occurs while updating the poll information.
     */
    boolean updatePollInformation(long pollId, String pollName, String description, int questionCount, Map<String, List<String>> questionOptionsMap)
            throws ServiceException;

    /**
     * Checks if a user has responded to a specific poll.
     *
     * @param userId The ID of the user to check.
     * @param id     The ID of the poll to check.
     * @return true if the user has responded to the poll, false otherwise.
     * @throws ServiceException If an error occurs while checking the poll response.
     */
    boolean hasPollResponse(long userId, long id) throws ServiceException;

    /**
     * Increments the number of participants for a specific poll.
     *
     * @param pollId The ID of the poll for which the number of participants should be incremented.
     * @return true if the number of participants was successfully incremented, false otherwise.
     * @throws ServiceException If an error occurs while incrementing the number of participants.
     */
    boolean incrementNumParticipants(long pollId) throws ServiceException;

    /**
     * Decreases the number of questions in a specific poll.
     *
     * @param pollId      The ID of the poll for which the number of questions should be decreased.
     * @param decreaseNum The number by which the number of questions should be decreased.
     * @return true if the number of questions was successfully decreased, false otherwise.
     * @throws ServiceException If an error occurs while decreasing the number of questions.
     */
    boolean decreaseNumQuestions(long pollId, int decreaseNum) throws ServiceException;

    /**
     * Retrieves a list of polls created by a specific user.
     *
     * @param creatorId The ID of the user for which polls need to be retrieved.
     * @return A list of polls created by the specified user.
     * @throws ServiceException If an error occurs while retrieving the polls.
     */
    List<Poll> getPollsByCreatorId(long creatorId) throws ServiceException;

    /**
     * Deletes a poll along with its associated poll responses.
     *
     * @param pollId The ID of the poll to be deleted.
     * @throws ServiceException If an error occurs while deleting the poll and its associated data.
     */
    void deletePoll(long pollId) throws ServiceException;

}
