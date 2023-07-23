package com.dev.socialPoll.service.impl;

import com.dev.socialPoll.entity.Gender;
import com.dev.socialPoll.entity.User;
import com.dev.socialPoll.entity.UserRole;
import com.dev.socialPoll.exception.ServiceException;
import com.dev.socialPoll.dao.UserDao;
import com.dev.socialPoll.dao.DaoFactory;
import com.dev.socialPoll.service.UserService;

import java.time.LocalDate;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl() {
        this.userDao = DaoFactory.getInstance().getUserDao();
    }

    @Override
    public Optional<User> login(String email, String password) throws ServiceException {
        try {
            Optional<User> user = userDao.findByEmailAndPassword(email, password);
            return user;
        } catch (Exception e) {
            throw new ServiceException("Error occurred during login.", e);
        }
    }

    @Override
    public boolean register(String firstName, String lastName, LocalDate birthday, Gender gender,
                            String email, String password, UserRole role) throws ServiceException {
        try {
            User user = new User(firstName, lastName, birthday, gender, email, password, role);
            userDao.save(user);
            return true;
        } catch (Exception e) {
            throw new ServiceException("Error occurred during user registration.", e);
        }
    }

    @Override
    public Optional<User> retrieveUserById(long userId) throws ServiceException {
        try {
            Optional<User> user = userDao.findById(userId);
            return user;
        } catch (Exception e) {
            throw new ServiceException("Error occurred while retrieving user by ID.", e);
        }
    }

    @Override
    public boolean increaseParticipantsCount(long userId) throws ServiceException {
        return false;
    }

    @Override
    public boolean register(String firstName, String lastName, String birthday, String gender, String email, String password) throws ServiceException {
        try {
            User user = new User(firstName, lastName, birthday, gender, email, password);
            userDao.save(user);
            return true;
        } catch (Exception e) {
            throw new ServiceException("Error occurred during user registration.", e);
        }
    }
}
