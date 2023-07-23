package com.dev.socialPoll.dao;

import com.dev.socialPoll.entity.PollResponse;
import com.dev.socialPoll.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface PollResponseDao {
    long save(PollResponse pollResponse) throws DaoException;

    List<PollResponse> findByUserId(long userId) throws DaoException;

    boolean isPollResponseExist(long userId, long pollId) throws DaoException;
}
