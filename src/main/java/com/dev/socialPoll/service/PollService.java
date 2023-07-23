package com.dev.socialPoll.service;

import com.dev.socialPoll.entity.Poll;
import com.dev.socialPoll.entity.PollStatus;
import com.dev.socialPoll.exception.ServiceException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PollService {

    List<Poll> retrievePollsByTopic(long topicId) throws ServiceException;

    Optional<Poll> retrievePollById(long pollId) throws ServiceException;

    boolean addNewPoll(long topicId, String pollName, String description, Map<String, List<String>> questionOptionsMap)
            throws ServiceException;

    boolean updatePollInformation(long pollId, String pollName, String description) throws ServiceException;

    boolean deletePoll(long pollId) throws ServiceException;

}
