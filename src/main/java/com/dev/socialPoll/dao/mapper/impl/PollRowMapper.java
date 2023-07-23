package com.dev.socialPoll.dao.mapper.impl;

import com.dev.socialPoll.dao.mapper.Column;
import com.dev.socialPoll.dao.mapper.RowMapper;
import com.dev.socialPoll.entity.Poll;
import com.dev.socialPoll.entity.PollStatus;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PollRowMapper implements RowMapper<Poll> {

    @Override
    public Poll map(ResultSet resultSet) throws SQLException {
        Poll poll = new Poll();
        poll.setId(resultSet.getLong(Column.POLL_ID));
        poll.setTopicId(resultSet.getLong(Column.POLL_TOPIC_ID));
        poll.setPollName(resultSet.getString(Column.POLL_NAME));
        poll.setDescription(resultSet.getString(Column.POLL_DESCRIPTION));
        poll.setNumQuestions(resultSet.getInt(Column.POLL_NUM_QUESTIONS));
        poll.setNumParticipants(resultSet.getInt(Column.POLL_NUM_PARTICIPANTS));
        String status = resultSet.getString(Column.POLL_STATUS);
        poll.setStatus(PollStatus.valueOf(status));
        return poll;
    }
}
