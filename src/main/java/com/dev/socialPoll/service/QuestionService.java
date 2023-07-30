package com.dev.socialPoll.service;

import com.dev.socialPoll.entity.Question;
import com.dev.socialPoll.exception.ServiceException;

import java.util.List;

/**
 * QuestionService is responsible for managing questions in the social poll application.
 * It provides methods to retrieve questions by poll ID and delete a question by its ID.
 */
public interface QuestionService {

    /**
     * Retrieves a list of questions belonging to a specific poll.
     *
     * @param pollId The ID of the poll for which questions need to be retrieved.
     * @return A list of questions belonging to the specified poll.
     * @throws ServiceException If an error occurs while retrieving the questions.
     */
    List<Question> retrieveQuestionsByPoll(long pollId) throws ServiceException;

    /**
     * Deletes a question by its ID.
     *
     * @param questionId The ID of the question to delete.
     * @return true if the question was successfully deleted, false otherwise.
     * @throws ServiceException If the question with the specified ID is not found or an error occurs while deleting it.
     */
    boolean deleteQuestion(long questionId) throws ServiceException;
}
