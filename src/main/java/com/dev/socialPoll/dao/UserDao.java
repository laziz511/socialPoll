package com.dev.socialPoll.dao;

import com.dev.socialPoll.entity.User;
import com.dev.socialPoll.exception.DaoException;

import java.util.Optional;

public interface UserDao {
    long save(User user) throws DaoException;

    Optional<User> findByEmail(String email) throws DaoException;

    Optional<User> findByEmailAndPassword(String email, String password) throws DaoException;

    Optional<User> findById(long userId);

    void deleteById(long savedUserId)  throws DaoException;
}
