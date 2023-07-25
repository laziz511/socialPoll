package com.dev.socialPoll.service;

import com.dev.socialPoll.entity.User;
import com.dev.socialPoll.entity.UserRole;
import com.dev.socialPoll.exception.ServiceException;

import java.time.LocalDate;
import java.util.Optional;

public interface UserService {

    Optional<User> login(String email, String password) throws ServiceException;

    boolean register(String firstName, String lastName, LocalDate birthday, String gender,
                            String email, String password, UserRole role) throws ServiceException;

    Optional<User> retrieveUserById(long userId) throws ServiceException;

    boolean increaseParticipantsCount(long userId) throws ServiceException;

    boolean register(String firstName, String lastName, String birthday, String gender, String email, String password) throws ServiceException;
}

