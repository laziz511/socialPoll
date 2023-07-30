package com.dev.socialPoll.service;

import com.dev.socialPoll.exception.ServiceException;

import java.util.List;

/**
 * PollResponseService is responsible for managing poll responses in the social poll application.
 * It provides methods to add new poll responses, check if a user has responded to a poll,
 * retrieve poll IDs by user ID, and delete poll responses by question ID.
 */
public interface PollResponseService {

    /**
     * Adds a new poll response to the database.
     *
     * @param pollId     The ID of the poll for which the response is submitted.
     * @param questionId The ID of the question for which the response is submitted.
     * @param optionId   The ID of the option selected as the response.
     * @param userId     The ID of the user who submitted the response.
     * @return true if the poll response was successfully added, false otherwise.
     * @throws ServiceException If an error occurs while adding the poll response.
     */
    boolean addNewPollResponse(long pollId, long questionId, long optionId, long userId) throws ServiceException;

    /**
     * Checks if a user has already responded to a specific poll.
     *
     * @param userId The ID of the user to check.
     * @param pollId The ID of the poll to check.
     * @return true if the user has responded to the poll, false otherwise.
     * @throws ServiceException If an error occurs while checking the poll response.
     */
    boolean hasPollResponse(long userId, long pollId) throws ServiceException;

    /**
     * Retrieves a list of poll IDs for which a user has submitted responses.
     *
     * @param userId The ID of the user for which poll IDs need to be retrieved.
     * @return A list of poll IDs for which the user has submitted responses.
     * @throws ServiceException If an error occurs while retrieving the poll IDs.
     */
    List<Long> getPollIdsByUserId(long userId) throws ServiceException;

    /**
     * Deletes poll responses associated with a specific question.
     *
     * @param removedQuestionId The ID of the question for which poll responses should be deleted.
     * @throws ServiceException If an error occurs while deleting the poll responses.
     */
    void deleteResponsesByQuestion(Long removedQuestionId) throws ServiceException;
}