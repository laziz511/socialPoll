package com.dev.socialPoll.dao;

import com.dev.socialPoll.entity.PollResponse;
import com.dev.socialPoll.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface PollResponseDao {
    long save(PollResponse pollResponse) throws DaoException;

    boolean isPollResponseExist(long userId, long pollId) throws DaoException;

    List<Long> getPollIdsByUserId(long userId) throws DaoException;

    List<PollResponse> findByQuestionId(long questionId) throws DaoException;
    void delete(long id) throws DaoException;
}
