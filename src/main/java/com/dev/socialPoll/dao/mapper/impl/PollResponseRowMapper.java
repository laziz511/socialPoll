package com.dev.socialPoll.dao.mapper.impl;

import com.dev.socialPoll.dao.mapper.Column;
import com.dev.socialPoll.dao.mapper.RowMapper;
import com.dev.socialPoll.entity.PollResponse;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class PollResponseRowMapper implements RowMapper<PollResponse> {

    @Override
    public PollResponse map(ResultSet resultSet) throws SQLException {
        PollResponse pollResponse = new PollResponse();
        pollResponse.setId(resultSet.getLong(Column.POLL_RESPONSE_ID));
        pollResponse.setPollId(resultSet.getLong(Column.POLL_RESPONSE_POLL_ID));
        pollResponse.setQuestionId(resultSet.getLong(Column.POLL_RESPONSE_QUESTION_ID));
        pollResponse.setOptionId(resultSet.getLong(Column.POLL_RESPONSE_OPTION_ID));
        pollResponse.setUserId(resultSet.getLong(Column.POLL_RESPONSE_USER_ID));
        return pollResponse;
    }
}
