package com.dev.socialPoll.service;

import com.dev.socialPoll.entity.Question;
import com.dev.socialPoll.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    List<Question> retrieveQuestionsByPoll(long pollId) throws ServiceException;
    boolean deleteQuestion(long questionId) throws ServiceException;
}
