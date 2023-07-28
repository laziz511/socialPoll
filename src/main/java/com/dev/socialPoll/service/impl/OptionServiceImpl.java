package com.dev.socialPoll.service.impl;

import com.dev.socialPoll.dao.DaoFactory;
import com.dev.socialPoll.dao.OptionDao;
import com.dev.socialPoll.entity.Option;
import com.dev.socialPoll.exception.DaoException;
import com.dev.socialPoll.exception.ServiceException;
import com.dev.socialPoll.service.OptionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class OptionServiceImpl implements OptionService {
    private static final Logger logger = LogManager.getLogger();


    @Override
    public List<Option> retrieveOptionsByQuestion(long questionId) throws ServiceException {
        try {
            OptionDao optionDao = DaoFactory.getInstance().getOptionDao();
            List<Option> result = optionDao.findByQuestionId(questionId);
            return result;
        } catch (DaoException e) {
            logger.error("Unable to retrieve options by question id!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<Option> retrieveOptionById(long optionId) throws ServiceException {
        OptionDao optionDao = DaoFactory.getInstance().getOptionDao();
        try {
            return optionDao.findById(optionId);
        } catch (DaoException e) {
            logger.error("Unable to retrieve options by question id!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean addNewOption(long questionId, String optionText) throws ServiceException {
        try {
            OptionDao optionDao = DaoFactory.getInstance().getOptionDao();
            Option newOption = new Option(0, questionId, optionText, 0);

            optionDao.save(newOption);
            return true;
        } catch (DaoException e) {
            logger.error("Unable to add a new option!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean updateOptionInformation(long optionId, String optionText) throws ServiceException {
        return false;
    }

    @Override
    public boolean deleteOption(long optionId) throws ServiceException {
        return false;
    }

    @Override
    public boolean increaseParticipantsCount(long optionId, int numParticipants) throws ServiceException {
        try {
            OptionDao optionDao = DaoFactory.getInstance().getOptionDao();
            optionDao.updateNumParticipants(optionId, numParticipants);
            return true;
            } catch (DaoException e) {
            logger.error("Unable to add a new option!");
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
