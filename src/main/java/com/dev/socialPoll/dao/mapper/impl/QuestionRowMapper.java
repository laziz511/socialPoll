package com.dev.socialPoll.dao.mapper.impl;

import com.dev.socialPoll.dao.mapper.Column;
import com.dev.socialPoll.dao.mapper.RowMapper;
import com.dev.socialPoll.entity.Question;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionRowMapper implements RowMapper<Question> {

    @Override
    public Question map(ResultSet resultSet) throws SQLException {
        Question question = new Question();
        question.setId(resultSet.getLong(Column.QUESTION_ID));
        question.setPollId(resultSet.getLong(Column.QUESTION_POLL_ID));
        question.setQuestionText(resultSet.getString(Column.QUESTION_TEXT));
        return question;
    }
}
