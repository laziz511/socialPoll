package com.dev.socialPoll.dao.mapper;

import com.dev.socialPoll.dao.mapper.impl.OptionRowMapper;
import com.dev.socialPoll.dao.mapper.impl.PollResponseRowMapper;
import com.dev.socialPoll.dao.mapper.impl.PollRowMapper;
import com.dev.socialPoll.dao.mapper.impl.QuestionRowMapper;
import com.dev.socialPoll.dao.mapper.impl.TopicRowMapper;
import com.dev.socialPoll.dao.mapper.impl.UserRowMapper;

import com.dev.socialPoll.entity.Option;
import com.dev.socialPoll.entity.PollResponse;
import com.dev.socialPoll.entity.Poll;
import com.dev.socialPoll.entity.Question;
import com.dev.socialPoll.entity.Topic;
import com.dev.socialPoll.entity.User;

public class RowMapperFactory {
    private final RowMapper<Option> optionRowMapper = new OptionRowMapper();
    private final RowMapper<PollResponse> pollResponseRowMapper = new PollResponseRowMapper();
    private final RowMapper<Poll> pollRowMapper = new PollRowMapper();
    private final RowMapper<Question> questionRowMapper = new QuestionRowMapper();
    private final RowMapper<Topic> topicRowMapper = new TopicRowMapper();
    private final RowMapper<User> userRowMapper = new UserRowMapper();

    public static RowMapperFactory getInstance() {
        return Holder.INSTANCE;
    }

    public RowMapper<Option> getOptionRowMapper() {
        return optionRowMapper;
    }

    public RowMapper<PollResponse> getPollResponseRowMapper() {
        return pollResponseRowMapper;
    }

    public RowMapper<Poll> getPollRowMapper() {
        return pollRowMapper;
    }

    public RowMapper<Question> getQuestionRowMapper() {
        return questionRowMapper;
    }

    public RowMapper<Topic> getTopicRowMapper() {
        return topicRowMapper;
    }

    public RowMapper<User> getUserRowMapper() {
        return userRowMapper;
    }

    private static class Holder {
        private static final RowMapperFactory INSTANCE = new RowMapperFactory();
    }
}
