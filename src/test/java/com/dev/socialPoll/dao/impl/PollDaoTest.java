package com.dev.socialPoll.dao.impl;

import com.dev.socialPoll.entity.Poll;
import com.dev.socialPoll.entity.PollStatus;
import com.dev.socialPoll.exception.DaoException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PollDaoTest {
    private static PollDaoImpl pollDao;

    @BeforeAll
    static void setUp() {
        pollDao = new PollDaoImpl();
    }

    @Test
    void testSavePoll() throws DaoException {
        Poll poll = new Poll();
        poll.setTopicId(1);
        poll.setPollName("Test Poll");
        poll.setDescription("This is a test poll");
        poll.setNumQuestions(5);
        poll.setNumParticipants(0);
        poll.setStatus(PollStatus.NEW);

        long savedPollId = pollDao.save(poll);
        assertTrue(savedPollId > 0);

        // Clean up: Delete the test poll from the database
//        pollDao.deleteById(savedPollId);
    }

    @Test
    void testFindPollById() throws DaoException {
        long pollId = 10;
        Optional<Poll> pollOptional = pollDao.findById(pollId);
        assertTrue(pollOptional.isPresent());

        Poll poll = pollOptional.get();
        assertEquals(pollId, poll.getId());
    }

    @Test
    void testFindPollByTopicId() throws DaoException {
        long topicId = 1;
        List<Poll> polls = pollDao.findByTopicId(topicId);
        assertFalse(polls.isEmpty());
    }

    @Test
    void testCountQuestionsInPoll() throws DaoException {
        // Assume that there is a poll with ID 1 in the database
        long pollId = 1;
        int questionCount = pollDao.countQuestionsInPoll(pollId);
        assertTrue(questionCount >= 0);
    }

    @Test
    void testCountParticipantsInPoll() throws DaoException {
        // Assume that there is a poll with ID 1 in the database
        long pollId = 1;
        int participantCount = pollDao.countParticipantsInPoll(pollId);
        assertTrue(participantCount >= 0);
    }
}
