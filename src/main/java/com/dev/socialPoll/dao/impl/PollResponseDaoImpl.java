package com.dev.socialPoll.dao.impl;

import com.dev.socialPoll.dao.AbstractDao;
import com.dev.socialPoll.dao.Table;
import com.dev.socialPoll.dao.PollResponseDao;
import com.dev.socialPoll.dao.mapper.RowMapperFactory;
import com.dev.socialPoll.entity.PollResponse;
import com.dev.socialPoll.exception.DaoException;

import java.util.List;

public class PollResponseDaoImpl extends AbstractDao<PollResponse> implements PollResponseDao {
    private static final String SAVE_POLL_RESPONSE_QUERY = "INSERT INTO " + Table.POLL_RESPONSES +
            " (poll_id, question_id, option_id, user_id) VALUES (?, ?, ?, ?)";
    private static final String CHECK_POLL_RESPONSE_EXISTENCE_QUERY = "SELECT COUNT(*) FROM " + Table.POLL_RESPONSES + " WHERE user_id=? AND poll_id=?";
    private static final String FIND_POLL_IDS_BY_USER_ID_QUERY = "SELECT DISTINCT poll_id FROM " + Table.POLL_RESPONSES + " WHERE user_id = ?";
    private static final String FIND_POLL_RESPONSES_BY_QUESTION_ID_QUERY = "SELECT * FROM " + Table.POLL_RESPONSES + " WHERE question_id = ?";
    private static final String DELETE_POLL_RESPONSE_BY_ID_QUERY = "DELETE FROM " + Table.POLL_RESPONSES + " WHERE response_id = ?";
    private static final String FIND_USER_RESPONSES_BY_POLL_ID_QUERY = "SELECT option_id FROM " + Table.POLL_RESPONSES + " WHERE poll_id = ? AND user_id = ?";
    public PollResponseDaoImpl() {
        super(RowMapperFactory.getInstance().getPollResponseRowMapper(), Table.POLL_RESPONSES);
    }

    @Override
    public long save(PollResponse pollResponse) throws DaoException {
        return executeInsertQuery(SAVE_POLL_RESPONSE_QUERY, pollResponse.getPollId(), pollResponse.getQuestionId(),
                pollResponse.getOptionId(), pollResponse.getUserId());
    }

    @Override
    public boolean isPollResponseExist(long userId, long pollId) throws DaoException {
        int count = executeCountQuery(CHECK_POLL_RESPONSE_EXISTENCE_QUERY, userId, pollId);
        return count > 0;
    }

    @Override
    public List<Long> getPollIdsByUserId(long userId) throws DaoException {
        return executeQueryForList(FIND_POLL_IDS_BY_USER_ID_QUERY, userId);
    }

    @Override
    public List<PollResponse> findByQuestionId(long questionId) throws DaoException {
        return executeQuery(FIND_POLL_RESPONSES_BY_QUESTION_ID_QUERY, questionId);
    }

    @Override
    public void delete(long id) throws DaoException {
        executeUpdateQuery(DELETE_POLL_RESPONSE_BY_ID_QUERY, id);
    }

    @Override
    public List<Long> getUserResponses(long pollId, long userId) throws DaoException {
        return executeQueryForList(FIND_USER_RESPONSES_BY_POLL_ID_QUERY, pollId, userId);
    }
}
