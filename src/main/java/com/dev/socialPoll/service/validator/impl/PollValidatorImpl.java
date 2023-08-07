package com.dev.socialPoll.service.validator.impl;

import com.dev.socialPoll.service.validator.PollValidator;

public class PollValidatorImpl implements PollValidator {

    private static final PollValidator instance = new PollValidatorImpl();

    public static PollValidator getInstance() {
        return instance;
    }

    @Override
    public boolean checkPollName(String pollName) {
        // Validates the poll name length (3 to 30 characters).
        return pollName.length() >= 3 && pollName.length() <= 50;
    }

    @Override
    public boolean checkPollDescription(String pollDescription) {
        // Validates the poll description by checking if it contains more than 2 words.
        return pollDescription.split(" ").length >= 2;
    }
}
