package com.dev.socialPoll.service.impl;

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
            return userDao.findByEmailAndPassword(email, password);
        } catch (Exception e) {
            throw new ServiceException("Error occurred during login.", e);
        }
    }

    @Override
    public boolean register(String firstName, String lastName, LocalDate birthday, String gender,
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
    public boolean userExistsWithCurrentEmail(String email) throws ServiceException {
        try {
            Optional<User> user = userDao.findByEmail(email);
            return user.isPresent();
        } catch (Exception e) {
            throw new ServiceException("Error occurred while checking user availability with email", e);
        }
    }
}
