package com.dev.socialPoll.service.impl;

import com.dev.socialPoll.dao.DaoFactory;
import com.dev.socialPoll.dao.QuestionDao;
import com.dev.socialPoll.entity.Question;
import com.dev.socialPoll.exception.DaoException;
import com.dev.socialPoll.exception.ServiceException;
import com.dev.socialPoll.service.QuestionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class QuestionServiceImpl implements QuestionService {

    private static final Logger logger = LogManager.getLogger();


    @Override
    public List<Question> retrieveQuestionsByPoll(long pollId) throws ServiceException {
        try {
            QuestionDao questionDao = DaoFactory.getInstance().getQuestionDao();
            List<Question> result = questionDao.findByPollId(pollId);
            return result;
        } catch (DaoException e) {
            logger.error("Unable to retrieve questions by poll id!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean deleteQuestion(long questionId) throws ServiceException {
        try {
            QuestionDao questionDao = DaoFactory.getInstance().getQuestionDao();
            Optional<Question> questionToDelete = questionDao.findById(questionId);

            if (questionToDelete.isPresent()) {
                questionDao.delete(questionId);
                return true;
            } else {
                logger.error("Question with ID " + questionId + " not found.");
                throw new ServiceException("Question with ID " + questionId + " not found.");
            }
        } catch (DaoException e) {
            logger.error("Unable to delete question!");
            throw new ServiceException("Error occurred while deleting the question.", e);
        }
    }
}
