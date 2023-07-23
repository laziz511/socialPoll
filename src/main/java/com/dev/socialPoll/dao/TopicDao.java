package com.dev.socialPoll.dao;

import com.dev.socialPoll.entity.Topic;
import com.dev.socialPoll.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface TopicDao extends Dao<Topic> {
    long save(Topic topic) throws DaoException;

    Optional<Topic> findById(long id) throws DaoException;

    List<Topic> findAll() throws DaoException;

    int countPollsByTopic(long topicId) throws DaoException;

    int countParticipantsByTopic(long topicId) throws DaoException;
}
