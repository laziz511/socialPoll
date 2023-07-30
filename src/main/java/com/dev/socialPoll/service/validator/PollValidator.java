package com.dev.socialPoll.service.validator;

public interface PollValidator {

    /**
     * Checks if the poll name is valid.
     *
     * @param pollName the poll name to be checked.
     * @return true if the poll name is valid, false otherwise.
     */
    boolean checkPollName(String pollName);

    /**
     * Checks if the poll description is valid.
     *
     * @param pollDescription the poll description to be checked.
     * @return true if the poll description is valid, false otherwise.
     */
    boolean checkPollDescription(String pollDescription);
}
