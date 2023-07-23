package com.dev.socialPoll.service;

import com.dev.socialPoll.entity.Question;
import com.dev.socialPoll.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    List<Question> retrieveQuestionsByPoll(long pollId) throws ServiceException;

    Optional<Question> retrieveQuestionById(long questionId) throws ServiceException;

    boolean addNewQuestion(long pollId, String questionText) throws ServiceException;

    boolean updateQuestionInformation(long questionId, String questionText) throws ServiceException;

    boolean deleteQuestion(long questionId) throws ServiceException;

    boolean increaseParticipantsCount(long questionId) throws ServiceException;

}
