package com.dev.socialPoll.service.validator;

public interface PollValidator {

    boolean checkPollName(String pollName);

    boolean checkPollDescription(String pollDescription);
}
