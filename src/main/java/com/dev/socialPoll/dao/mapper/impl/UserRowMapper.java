package com.dev.socialPoll.dao.mapper.impl;

import com.dev.socialPoll.dao.mapper.Column;
import com.dev.socialPoll.dao.mapper.RowMapper;
import com.dev.socialPoll.entity.User;
import com.dev.socialPoll.entity.UserRole;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User map(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong(Column.USER_ID));
        user.setFirstName(resultSet.getString(Column.USER_FIRST_NAME));
        user.setLastName(resultSet.getString(Column.USER_LAST_NAME));
        user.setBirthday(resultSet.getDate(Column.USER_BIRTHDAY).toLocalDate());
        user.setGender(Column.USER_GENDER);
        user.setEmail(resultSet.getString(Column.USER_EMAIL));
        user.setPassword(resultSet.getString(Column.USER_PASSWORD));
        String role = resultSet.getString(Column.USER_ROLE);
        user.setRole(UserRole.valueOf(role));
        return user;
    }
}
