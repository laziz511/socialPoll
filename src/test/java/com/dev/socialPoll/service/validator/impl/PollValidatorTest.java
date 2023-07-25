package com.dev.socialPoll.service.validator.impl;

import com.dev.socialPoll.service.validator.PollValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PollValidatorTest {

    private final PollValidator pollValidator = PollValidatorImpl.getInstance();

    @Test
    void testCheckPollName_ShouldReturnTrue_WhenPollNameIsCorrect() {
        String correctPollName = "Social Media Usage";
        boolean isValid = pollValidator.checkPollName(correctPollName);
        assertTrue(isValid);
    }

    @Test
    void testCheckPollName_ShouldReturnFalse_WhenPollNameIsTooShort() {
        String shortPollName = "A";
        boolean isValid = pollValidator.checkPollName(shortPollName);
        assertFalse(isValid);
    }

    @Test
    void testCheckPollName_ShouldReturnFalse_WhenPollNameIsTooLong() {
        String longPollName = "This is a very long poll name that exceeds the maximum limit";
        boolean isValid = pollValidator.checkPollName(longPollName);
        assertFalse(isValid);
    }

    @Test
    void testCheckPollDescription_ShouldReturnTrue_WhenPollDescriptionIsCorrect() {
        String correctPollDescription = "This is a poll about social media usage";
        boolean isValid = pollValidator.checkPollDescription(correctPollDescription);
        assertTrue(isValid);
    }

    @Test
    void testCheckPollDescription_ShouldReturnFalse_WhenPollDescriptionHasTooFewWords() {
        String descriptionWithFewWords = "This poll";
        boolean isValid = pollValidator.checkPollDescription(descriptionWithFewWords);
        assertFalse(isValid);
    }
}
