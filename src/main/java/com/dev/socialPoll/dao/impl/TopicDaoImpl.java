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
    private static final String COUNT_POLLS_BY_TOPIC_QUERY = "SELECT COUNT(*) FROM " + Table.POLLS + " WHERE topic_id=?";
    private static final String COUNT_PARTICIPANTS_BY_TOPIC_QUERY = "SELECT SUM(num_participants) FROM " + Table.POLLS + " WHERE topic_id=?";

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
    public int countPollsByTopic(long topicId) throws DaoException {
        return executeCountQuery(COUNT_POLLS_BY_TOPIC_QUERY, topicId);
    }

    @Override
    public int countParticipantsByTopic(long topicId) throws DaoException {
        return executeCountQuery(COUNT_PARTICIPANTS_BY_TOPIC_QUERY, topicId);
    }
}
