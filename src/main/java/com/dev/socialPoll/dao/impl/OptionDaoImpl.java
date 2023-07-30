package com.dev.socialPoll.dao.impl;

import com.dev.socialPoll.dao.AbstractDao;
import com.dev.socialPoll.dao.Table;
import com.dev.socialPoll.dao.OptionDao;
import com.dev.socialPoll.dao.mapper.RowMapperFactory;
import com.dev.socialPoll.entity.Option;
import com.dev.socialPoll.exception.DaoException;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class OptionDaoImpl extends AbstractDao<Option> implements OptionDao {
    private static final String SAVE_OPTION_QUERY = "INSERT INTO " + Table.OPTIONS +
            " (question_id, option_text) VALUES (?, ?)";
    private static final String FIND_OPTION_BY_ID_QUERY = "SELECT * FROM " + Table.OPTIONS + " WHERE option_id=?";
    private static final String FIND_OPTIONS_BY_QUESTION_ID_QUERY = "SELECT * FROM " + Table.OPTIONS + " WHERE question_id=?";

    private static final String UPDATE_NUM_PARTICIPANTS_QUERY = "UPDATE " + Table.OPTIONS + " SET num_participants = num_participants + 1 WHERE option_id = ?";
    private static final String DELETE_OPTION_BY_ID_QUERY = "DELETE FROM " + Table.OPTIONS + " WHERE option_id = ?";
    public OptionDaoImpl() {
        super(RowMapperFactory.getInstance().getOptionRowMapper(), Table.OPTIONS);
    }

    @Override
    public long save(Option option) throws DaoException {
        return executeInsertQuery(SAVE_OPTION_QUERY, option.getQuestionId(), option.getOptionText());
    }

    @Override
    public Optional<Option> findById(long id) throws DaoException {
        return executeQueryForSingleResult(FIND_OPTION_BY_ID_QUERY, id);
    }

    @Override
    public List<Option> findByQuestionId(long questionId) throws DaoException {
        return executeQuery(FIND_OPTIONS_BY_QUESTION_ID_QUERY, questionId);
    }


    @Override
    public void updateNumParticipants(long optionId) throws DaoException {
        executeUpdateQuery(UPDATE_NUM_PARTICIPANTS_QUERY, optionId);
    }

    @Override
    public void delete(long optionId) throws DaoException {
        executeUpdateQuery(DELETE_OPTION_BY_ID_QUERY, optionId);
    }
}
