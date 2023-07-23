package com.dev.socialPoll.service.validator.impl;

import com.dev.socialPoll.service.validator.PollValidator;

public class PollValidatorImpl implements PollValidator {

    private static final PollValidator instance = new PollValidatorImpl();

    public static PollValidator getInstance() {
        return instance;
    }

    @Override
    public boolean checkPollName(String pollName) {
        return pollName.length() >= 3 && pollName.length() <= 30;
    }

    @Override
    public boolean checkPollDescription(String pollDescription) {
        return pollDescription.split(" ").length > 2;
    }
}
