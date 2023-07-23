package com.dev.socialPoll.dao.impl;

import com.dev.socialPoll.dao.AbstractDao;
import com.dev.socialPoll.dao.Table;
import com.dev.socialPoll.dao.PollDao;
import com.dev.socialPoll.dao.mapper.RowMapperFactory;
import com.dev.socialPoll.entity.Poll;
import com.dev.socialPoll.exception.DaoException;

import java.util.List;
import java.util.Optional;

public class PollDaoImpl extends AbstractDao<Poll> implements PollDao {
    private static final String SAVE_POLL_QUERY = "INSERT INTO " + Table.POLLS +
            " (topic_id, poll_name, description, num_questions, num_participants, status) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String FIND_POLL_BY_ID_QUERY = "SELECT * FROM " + Table.POLLS + " WHERE poll_id=?";
    private static final String FIND_POLLS_BY_TOPIC_ID_QUERY = "SELECT * FROM " + Table.POLLS + " WHERE topic_id=?";
    private static final String COUNT_QUESTIONS_IN_POLL_QUERY = "SELECT COUNT(*) FROM " + Table.QUESTIONS + " WHERE poll_id=?";
    private static final String COUNT_PARTICIPANTS_IN_POLL_QUERY = "SELECT num_participants FROM " + Table.POLLS + " WHERE poll_id=?";

    public PollDaoImpl() {
        super(RowMapperFactory.getInstance().getPollRowMapper(), Table.POLLS);
    }

    @Override
    public long save(Poll poll) throws DaoException {
        return executeInsertQuery(SAVE_POLL_QUERY, poll.getTopicId(), poll.getPollName(),
                poll.getDescription(), poll.getNumQuestions(), poll.getNumParticipants(), poll.getStatus().name());
    }

    @Override
    public Optional<Poll> findById(long id) throws DaoException {
        return executeQueryForSingleResult(FIND_POLL_BY_ID_QUERY, id);
    }

    @Override
    public List<Poll> findByTopicId(long topicId) throws DaoException {
        return executeQuery(FIND_POLLS_BY_TOPIC_ID_QUERY, topicId);
    }

    @Override
    public int countQuestionsInPoll(long pollId) throws DaoException {
        return executeCountQuery(COUNT_QUESTIONS_IN_POLL_QUERY, pollId);
    }

    @Override
    public int countParticipantsInPoll(long pollId) throws DaoException {
        return executeCountQuery(COUNT_PARTICIPANTS_IN_POLL_QUERY, pollId);
    }
}
