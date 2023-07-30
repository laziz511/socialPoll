package com.dev.socialPoll.service;

import com.dev.socialPoll.entity.Option;
import com.dev.socialPoll.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface OptionService {

    List<Option> retrieveOptionsByQuestion(long questionId) throws ServiceException;

    Optional<Option> retrieveOptionById(long optionId) throws ServiceException;

    boolean addNewOption(long questionId, String optionText) throws ServiceException;

    boolean updateOptionInformation(long optionId, String optionText) throws ServiceException;

    boolean deleteOption(long optionId) throws ServiceException;

    boolean increaseParticipantsCount(long optionId) throws ServiceException;
}
