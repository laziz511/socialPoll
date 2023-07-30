package com.dev.socialPoll.service.impl;

import com.dev.socialPoll.dao.*;
import com.dev.socialPoll.entity.*;
import com.dev.socialPoll.exception.DaoException;
import com.dev.socialPoll.exception.ServiceException;
import com.dev.socialPoll.service.PollResponseService;
import com.dev.socialPoll.service.PollService;
import com.dev.socialPoll.service.ServiceFactory;
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
    public boolean addNewPoll(long topicId, String pollName, String description, int questionCount, Map<String, List<String>> questionOptionsMap, long creatorId)
            throws ServiceException {
        if (pollName == null || description == null || questionOptionsMap == null) {
            return false;
        }

        PollValidator pollValidator = PollValidatorImpl.getInstance();
        if (!pollValidator.checkPollName(pollName) || !pollValidator.checkPollDescription(description)) {
            return false;
        }

        // Create and save the Poll object
        PollDao pollDao = DaoFactory.getInstance().getPollDao();
        Poll poll = new Poll();
        poll.setTopicId(topicId);
        poll.setPollName(pollName);
        poll.setDescription(description);
        poll.setStatus(PollStatus.NEW);
        poll.setNumQuestions(questionCount);
        poll.setCreatorId(creatorId);

        try {
            long pollId = pollDao.save(poll);

            // Create and save the Questions and AnswerOptions
            QuestionDao questionDao = DaoFactory.getInstance().getQuestionDao();
            OptionDao answerOptionDao = DaoFactory.getInstance().getOptionDao();

            for (Map.Entry<String, List<String>> entry : questionOptionsMap.entrySet()) {
                String questionText = entry.getKey();
                List<String> answerOptions = entry.getValue();

                Question question = new Question();
                question.setPollId(pollId);
                question.setQuestionText(questionText);

                long questionId = questionDao.save(question);

                for (String answerOptionText : answerOptions) {
                    Option answerOption = new Option();
                    answerOption.setQuestionId(questionId);
                    answerOption.setOptionText(answerOptionText);
                    answerOption.setNumParticipants(0); // Set the number of participants to 0 explicitly
                    answerOptionDao.save(answerOption);
                }
            }
        } catch (DaoException e) {
            logger.error("Error occurred while adding a new poll.");
            throw new ServiceException(e.getMessage(), e);
        }
        return true;
    }



    @Override
    public boolean updatePollInformation(long pollId, String pollName, String description, int questionCount, Map<String, List<String>> questionOptionsMap) throws ServiceException {
        if (pollName == null || description == null) {
            return false;
        }

        PollValidator pollValidator = PollValidatorImpl.getInstance();
        if (!pollValidator.checkPollName(pollName) || !pollValidator.checkPollDescription(description)) {
            return false;
        }

        try {
            PollDao pollDao = DaoFactory.getInstance().getPollDao();
            Optional<Poll> existingPoll = pollDao.findById(pollId);

            if (existingPoll.isPresent()) {
                Poll poll = existingPoll.get();
                poll.setPollName(pollName);
                poll.setDescription(description);
                poll.setStatus(PollStatus.EDITED);
                poll.setNumQuestions(questionCount);
                pollDao.update(poll);

                // Create and save the Questions and AnswerOptions
                QuestionDao questionDao = DaoFactory.getInstance().getQuestionDao();
                OptionDao answerOptionDao = DaoFactory.getInstance().getOptionDao();

                for (Map.Entry<String, List<String>> entry : questionOptionsMap.entrySet()) {
                    String questionText = entry.getKey();
                    List<String> answerOptions = entry.getValue();

                    Question question = new Question();
                    question.setPollId(pollId);
                    question.setQuestionText(questionText);

                    long questionId = questionDao.save(question);

                    for (String answerOptionText : answerOptions) {
                        Option answerOption = new Option();
                        answerOption.setQuestionId(questionId);
                        answerOption.setOptionText(answerOptionText);
                        answerOptionDao.save(answerOption);
                    }
                }

                return true;
            } else {
                logger.error("Poll not found while updating poll information.");
                return false;
            }
        } catch (DaoException e) {
            logger.error("Error occurred while updating poll information.");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean deletePoll(long pollId) throws ServiceException {
        return false;
    }

    @Override
    public boolean hasPollResponse(long userId, long id) {
        PollResponseService pollResponseService = ServiceFactory.getInstance().getPollResponseService();
        try {
            return pollResponseService.hasPollResponse(userId, id);
        } catch (ServiceException e) {
            logger.error("Unable to execute hasPollResponse method!");
        }
        return false;
    }

    @Override
    public boolean incrementNumParticipants(long pollId) throws ServiceException {
        try {
            PollDao pollDao = DaoFactory.getInstance().getPollDao();
            return pollDao.incrementNumParticipants(pollId);
        } catch (DaoException e) {
            logger.error("Error occurred while incrementing num_participants for the poll.");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Poll> getPollsByCreatorId(long creatorId) throws ServiceException {
        try {
            PollDao pollDao = DaoFactory.getInstance().getPollDao();
            return pollDao.getPollsByCreatorId(creatorId);
        } catch (Exception e) {
            logger.error("Error occurred while getting polls by creator email.");
            throw new ServiceException("Error occurred while retrieving polls by creator email", e);
        }
    }

}
