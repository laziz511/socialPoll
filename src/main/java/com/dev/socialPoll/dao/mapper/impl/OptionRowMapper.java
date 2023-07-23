package com.dev.socialPoll.dao.mapper.impl;

import com.dev.socialPoll.dao.mapper.Column;
import com.dev.socialPoll.dao.mapper.RowMapper;
import com.dev.socialPoll.entity.Option;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OptionRowMapper implements RowMapper<Option> {

    @Override
    public Option map(ResultSet resultSet) throws SQLException {
        Option option = new Option();
        option.setId(resultSet.getLong(Column.OPTION_ID));
        option.setQuestionId(resultSet.getLong(Column.OPTION_QUESTION_ID));
        option.setOptionText(resultSet.getString(Column.OPTION_TEXT));
        option.setNumParticipants(resultSet.getInt(Column.OPTION_NUM_PARTICIPANTS));
        return option;
    }
}
