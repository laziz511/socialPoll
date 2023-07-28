package com.dev.socialPoll.dao;

import com.dev.socialPoll.entity.Option;
import com.dev.socialPoll.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface OptionDao {
    long save(Option option) throws DaoException;

    Optional<Option> findById(long id) throws DaoException;

    List<Option> findByQuestionId(long questionId) throws DaoException;

    void updateNumParticipants(long optionId, int numParticipants) throws DaoException;
}
