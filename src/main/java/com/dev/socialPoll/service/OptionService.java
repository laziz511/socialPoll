package com.dev.socialPoll.service;

import com.dev.socialPoll.entity.Option;
import com.dev.socialPoll.exception.ServiceException;

import java.util.List;

/**
 * OptionService is responsible for managing options related to a question in the social poll application.
 * It provides methods to retrieve options by question, delete an option, and increase participants count for an option.
 */
public interface OptionService {

    /**
     * Retrieves a list of options associated with a question.
     *
     * @param questionId The ID of the question for which options need to be retrieved.
     * @return A list of options associated with the specified question.
     * @throws ServiceException If an error occurs while retrieving the options.
     */
    List<Option> retrieveOptionsByQuestion(long questionId) throws ServiceException;

    /**
     * Deletes an option with the specified option ID.
     *
     * @param optionId The ID of the option to be deleted.
     * @return true if the option was successfully deleted, false otherwise.
     * @throws ServiceException If the option with the specified ID is not found or an error occurs while deleting the option.
     */
    boolean deleteOption(long optionId) throws ServiceException;

    /**
     * Increases the participant count for an option by one.
     *
     * @param optionId The ID of the option for which the participant count should be increased.
     * @return true if the participant count was successfully increased, false otherwise.
     * @throws ServiceException If an error occurs while increasing the participant count.
     */
    boolean increaseParticipantsCount(long optionId) throws ServiceException;
}
