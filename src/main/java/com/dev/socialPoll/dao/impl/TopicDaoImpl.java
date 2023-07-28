package com.dev.socialPoll.dao.impl;

import com.dev.socialPoll.dao.AbstractDao;
import com.dev.socialPoll.dao.Table;
import com.dev.socialPoll.dao.TopicDao;
import com.dev.socialPoll.dao.mapper.RowMapperFactory;
import com.dev.socialPoll.entity.Topic;
import com.dev.socialPoll.exception.DaoException;

import java.util.List;
import java.util.Optional;

public class TopicDaoImpl extends AbstractDao<Topic> implements TopicDao {
    private static final String FIND_ALL_TOPICS_QUERY = "SELECT * FROM " + Table.TOPICS;
    private static final String FIND_TOPIC_BY_ID_QUERY = "SELECT * FROM " + Table.TOPICS + " WHERE topic_id=?";

    private static final String UPDATE_TOPIC_QUERY = "UPDATE " + Table.TOPICS + " SET num_polls=? WHERE topic_id=?";

    private static final String UPDATE_NUMBER_OF_PARTICIPANTS_QUERY = "UPDATE " + Table.TOPICS + " SET num_participants = num_participants + 1 WHERE topic_id = ?";
    public TopicDaoImpl() {
        super(RowMapperFactory.getInstance().getTopicRowMapper(), Table.TOPICS);
    }

    @Override
    public long save(Topic topic) throws DaoException {
        return executeInsertQuery("INSERT INTO " + Table.TOPICS + " (topic_name, description) VALUES (?, ?)",
                topic.getTopicName(), topic.getDescription());
    }

    @Override
    public Optional<Topic> findById(long id) throws DaoException {
        return executeQueryForSingleResult(FIND_TOPIC_BY_ID_QUERY, id);
    }

    @Override
    public List<Topic> findAll() throws DaoException {
        return executeQuery(FIND_ALL_TOPICS_QUERY);
    }

    @Override
    public void update(Topic topic) throws DaoException {
        executeUpdateQuery(UPDATE_TOPIC_QUERY, topic.getNumPolls(), topic.getId());
    }

    @Override
    public void incrementNumParticipants(long topicId) throws DaoException {
        executeUpdateQuery(UPDATE_NUMBER_OF_PARTICIPANTS_QUERY, topicId);
    }
}