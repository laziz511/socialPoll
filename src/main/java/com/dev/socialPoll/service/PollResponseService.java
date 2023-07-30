package com.dev.socialPoll.service;

import com.dev.socialPoll.entity.PollResponse;
import com.dev.socialPoll.exception.ServiceException;

import java.util.List;

public interface PollResponseService {

    boolean addNewPollResponse(long pollId, long questionId, long optionId, long userId) throws ServiceException;

    boolean hasPollResponse(long userId, long pollId) throws ServiceException;

    List<Long> getPollIdsByUserId(long userId) throws ServiceException;

    void deleteResponsesByQuestion(Long removedQuestionId) throws ServiceException;

}
