package com.dev.socialPoll.service.impl;

import com.dev.socialPoll.dao.DaoFactory;
import com.dev.socialPoll.dao.TopicDao;
import com.dev.socialPoll.entity.Topic;
import com.dev.socialPoll.exception.DaoException;
import com.dev.socialPoll.exception.ServiceException;
import com.dev.socialPoll.service.TopicService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class TopicServiceImpl implements TopicService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public List<Topic> retrieveTopics() throws ServiceException {
        try {
            TopicDao topicDao = DaoFactory.getInstance().getTopicDao();
            List<Topic> result = null;
            result = topicDao.findAll();
            return result;
        } catch (DaoException e) {
            logger.error("Unable to retrieve topics!");
            throw new ServiceException(e.getMessage(),e);
        }
    }

    @Override
    public Optional<Topic> retrieveTopicById(long topicId) throws ServiceException {
        try {
            TopicDao topicDao = DaoFactory.getInstance().getTopicDao();
            Optional<Topic> result;
            result = topicDao.findById(topicId);
            return result;
        } catch (DaoException e) {
            logger.error("Unable to retrieve topic by id!");
            throw new ServiceException(e.getMessage(),e);
        }
    }
}
