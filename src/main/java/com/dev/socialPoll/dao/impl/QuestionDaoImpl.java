package com.dev.socialPoll.dao.impl;

import com.dev.socialPoll.dao.AbstractDao;
import com.dev.socialPoll.dao.Table;
import com.dev.socialPoll.dao.QuestionDao;
import com.dev.socialPoll.dao.mapper.RowMapperFactory;
import com.dev.socialPoll.entity.Question;
import com.dev.socialPoll.exception.DaoException;

import java.util.List;
import java.util.Optional;

public class QuestionDaoImpl extends AbstractDao<Question> implements QuestionDao {
    private static final String SAVE_QUESTION_QUERY = "INSERT INTO " + Table.QUESTIONS +
            " (poll_id, question_text) VALUES (?, ?)";
    private static final String FIND_QUESTION_BY_ID_QUERY = "SELECT * FROM " + Table.QUESTIONS + " WHERE question_id=?";
    private static final String FIND_QUESTIONS_BY_POLL_ID_QUERY = "SELECT * FROM " + Table.QUESTIONS + " WHERE poll_id=?";
    private static final String UPDATE_QUESTION_QUERY = "UPDATE questions SET question_text = ? WHERE question_id = ?";

    private static final String DELETE_QUESTION_QUERY = "DELETE FROM " + Table.QUESTIONS + " WHERE question_id = ?";
    public QuestionDaoImpl() {
        super(RowMapperFactory.getInstance().getQuestionRowMapper(), Table.QUESTIONS);
    }

    @Override
    public long save(Question question) throws DaoException {
        return executeInsertQuery(SAVE_QUESTION_QUERY, question.getPollId(), question.getQuestionText());
    }

    @Override
    public Optional<Question> findById(long id) throws DaoException {
        return executeQueryForSingleResult(FIND_QUESTION_BY_ID_QUERY, id);
    }

    @Override
    public List<Question> findByPollId(long pollId) throws DaoException {
        return executeQuery(FIND_QUESTIONS_BY_POLL_ID_QUERY, pollId);
    }

    @Override
    public List<Question> update(Question question) throws DaoException {
        return executeQuery(UPDATE_QUESTION_QUERY, question);
    }

    @Override
    public void delete(long questionId) throws DaoException {
        executeUpdateQuery(DELETE_QUESTION_QUERY, questionId);
    }
}
