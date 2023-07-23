package com.dev.socialPoll.service.impl;

import com.dev.socialPoll.dao.DaoFactory;
import com.dev.socialPoll.dao.PollDao;
import com.dev.socialPoll.dao.TopicDao;
import com.dev.socialPoll.entity.Poll;
import com.dev.socialPoll.entity.Topic;
import com.dev.socialPoll.exception.DaoException;
import com.dev.socialPoll.exception.ServiceException;
import com.dev.socialPoll.service.PollService;
import com.dev.socialPoll.service.validator.PollValidator;
import com.dev.socialPoll.service.validator.impl.PollValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PollServiceImpl implements PollService {
    private static final  Logger logger = LogManager.getLogger();

    @Override
    public List<Poll> retrievePollsByTopic(long topicId) throws ServiceException {
        try {
            PollDao pollDao = DaoFactory.getInstance().getPollDao();
            List<Poll> result = pollDao.findByTopicId(topicId);
            return result;
        } catch (DaoException e) {
            logger.error("Unable to retrieve polls by topic id!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<Poll> retrievePollById(long pollId) throws ServiceException {
        try {
            PollDao pollDao = DaoFactory.getInstance().getPollDao();
            Optional<Poll> result = pollDao.findById(pollId);
            return result;
        } catch (DaoException e) {
            logger.error("Unable to retrieve poll by id!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean addNewPoll(long topicId, String pollName, String description, Map<String, List<String>> questionOptionsMap)
            throws ServiceException {
        if ( pollName == null || description == null || questionOptionsMap == null) {
            return false;
        }

        PollValidator pollValidator = PollValidatorImpl.getInstance();
        if (!pollValidator.checkPollName(pollName) || !pollValidator.checkPollDescription(description)) {
            return false;
        }

        PollDao pollDao = DaoFactory.getInstance().getPollDao();
        Poll poll = new Poll();

        return true;
    }

    @Override
    public boolean updatePollInformation(long pollId, String pollName, String description) throws ServiceException {
        return false;
    }

    @Override
    public boolean deletePoll(long pollId) throws ServiceException {
        return false;
    }
}
