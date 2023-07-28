package com.dev.socialPoll.service.impl;

import com.dev.socialPoll.dao.DaoFactory;
import com.dev.socialPoll.dao.PollResponseDao;
import com.dev.socialPoll.entity.PollResponse;
import com.dev.socialPoll.exception.DaoException;
import com.dev.socialPoll.exception.ServiceException;
import com.dev.socialPoll.service.PollResponseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class PollResponseServiceImpl implements PollResponseService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public List<PollResponse> retrievePollResponsesByUser(long userId) throws ServiceException {
        try {
            PollResponseDao pollResponseDao = DaoFactory.getInstance().getPollResponseDao();
            return pollResponseDao.findByUserId(userId);
        } catch (DaoException e) {
            logger.error("Unable to retrieve poll responses by user id!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean addNewPollResponse(long pollId, long questionId, long optionId, long userId) throws ServiceException {
        try {
            logger.info("this is inside a addNewPollResponse PollResponseServiceImpl");
            PollResponseDao pollResponseDao = DaoFactory.getInstance().getPollResponseDao();
            PollResponse newResponse = new PollResponse(0, pollId, questionId, optionId, userId);
            pollResponseDao.save(newResponse);
            return true;
        } catch (DaoException e) {
            logger.error("Unable to add a new poll response!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean hasPollResponse(long userId, long pollId) throws ServiceException {
        try {
            PollResponseDao pollResponseDao = DaoFactory.getInstance().getPollResponseDao();
            return  pollResponseDao.isPollResponseExist(userId, pollId);
        } catch (DaoException e) {
            logger.error("Unable to check poll response existence!", e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Long> getPollIdsByUserId(long userId) throws ServiceException {
        try {
            PollResponseDao pollResponseDao = DaoFactory.getInstance().getPollResponseDao();
            return pollResponseDao.getPollIdsByUserId(userId);
        } catch (DaoException e) {
            logger.error("Unable to get poll IDs by user ID!", e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

}
