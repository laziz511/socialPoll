package com.dev.socialPoll.service;

import com.dev.socialPoll.entity.Topic;
import com.dev.socialPoll.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface TopicService {

    List<Topic> retrieveTopics() throws ServiceException;

    Optional<Topic> retrieveTopicById(long topicId) throws ServiceException;

}
