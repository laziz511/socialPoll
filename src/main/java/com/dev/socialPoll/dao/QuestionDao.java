package com.dev.socialPoll.dao;

import com.dev.socialPoll.entity.Question;
import com.dev.socialPoll.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface QuestionDao {
    long save(Question question) throws DaoException;

    Optional<Question> findById(long id) throws DaoException;

    List<Question> findByPollId(long pollId) throws DaoException;

    List<Question> update(Question question) throws DaoException;

    void delete(long questionId) throws DaoException;
}
