package com.dev.socialPoll.dao;

import com.dev.socialPoll.entity.Poll;
import com.dev.socialPoll.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface PollDao {
    long save(Poll poll) throws DaoException;

    Optional<Poll> findById(long id) throws DaoException;

    List<Poll> findByTopicId(long topicId) throws DaoException;

    int countQuestionsInPoll(long pollId) throws DaoException;

    int countParticipantsInPoll(long pollId) throws DaoException;

    boolean incrementNumParticipants(long pollId) throws DaoException;

    List<Poll> getPollsByCreatorId(long creatorId) throws DaoException;

    boolean update(Poll poll) throws DaoException;

    boolean decreaseNumberOfQuestions(long pollId, int decreaseNum) throws DaoException;

}
