package com.dev.socialPoll.dao.impl;

import com.dev.socialPoll.dao.AbstractDao;
import com.dev.socialPoll.dao.Table;
import com.dev.socialPoll.dao.UserDao;
import com.dev.socialPoll.dao.mapper.RowMapperFactory;
import com.dev.socialPoll.entity.User;
import com.dev.socialPoll.exception.DaoException;

import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    private static final String SAVE_USER_QUERY = "INSERT INTO " + Table.USERS +
            " (first_name, last_name, birthday, gender, email, password, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String FIND_USER_BY_EMAIL_QUERY = "SELECT * FROM " + Table.USERS + " WHERE email=?";
    private static final String FIND_USER_BY_EMAIL_AND_PASSWORD_QUERY = "SELECT * FROM " + Table.USERS + " WHERE email=? AND password=?";

    public UserDaoImpl() {
        super(RowMapperFactory.getInstance().getUserRowMapper(), Table.USERS);
    }

    @Override
    public long save(User user) throws DaoException {
        return executeInsertQuery(SAVE_USER_QUERY, user.getFirstName(), user.getLastName(), user.getBirthday(),
                user.getGender().name(), user.getEmail(), user.getPassword(), user.getRole().name());
    }

    @Override
    public Optional<User> findByEmail(String email) throws DaoException {
        return executeQueryForSingleResult(FIND_USER_BY_EMAIL_QUERY, email);
    }

    @Override
    public Optional<User> findByEmailAndPassword(String email, String password) throws DaoException {
        return executeQueryForSingleResult(FIND_USER_BY_EMAIL_AND_PASSWORD_QUERY, email, password);
    }

    @Override
    public Optional<User> findById(long userId) {
        return null;
    }
}
