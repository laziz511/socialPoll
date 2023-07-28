package com.dev.socialPoll.service;

import com.dev.socialPoll.entity.PollResponse;
import com.dev.socialPoll.exception.ServiceException;

import java.util.List;

public interface PollResponseService {

    List<PollResponse> retrievePollResponsesByUser(long userId) throws ServiceException;

    boolean addNewPollResponse(long pollId, long questionId, long optionId, long userId) throws ServiceException;

    boolean hasPollResponse(long userId, long pollId) throws ServiceException;

    List<Long> getPollIdsByUserId(long userId) throws ServiceException;
}
