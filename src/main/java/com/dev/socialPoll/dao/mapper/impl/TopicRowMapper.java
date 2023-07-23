package com.dev.socialPoll.dao.mapper.impl;

import com.dev.socialPoll.dao.mapper.Column;
import com.dev.socialPoll.dao.mapper.RowMapper;
import com.dev.socialPoll.entity.Topic;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TopicRowMapper implements RowMapper<Topic> {

    @Override
    public Topic map(ResultSet resultSet) throws SQLException {
        Topic topic = new Topic();
        topic.setId(resultSet.getLong(Column.TOPIC_ID));
        topic.setTopicName(resultSet.getString(Column.TOPIC_NAME));
        topic.setDescription(resultSet.getString(Column.TOPIC_DESCRIPTION));
        topic.setNumPolls(resultSet.getInt(Column.TOPIC_NUM_POLLS));
        topic.setNumParticipants(resultSet.getInt(Column.TOPIC_NUM_PARTICIPANTS));
        return topic;
    }
}
