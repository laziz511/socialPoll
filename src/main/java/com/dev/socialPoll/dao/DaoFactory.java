package com.dev.socialPoll.dao;

import com.dev.socialPoll.dao.impl.TopicDaoImpl;
import com.dev.socialPoll.dao.impl.PollDaoImpl;
import com.dev.socialPoll.dao.impl.QuestionDaoImpl;
import com.dev.socialPoll.dao.impl.OptionDaoImpl;
import com.dev.socialPoll.dao.impl.UserDaoImpl;
import com.dev.socialPoll.dao.impl.PollResponseDaoImpl;

public class DaoFactory {
    private final TopicDaoImpl topicDao = new TopicDaoImpl();
    private final PollDao pollDao = new PollDaoImpl();
    private final QuestionDao questionDao = new QuestionDaoImpl();
    private final OptionDao optionDao = new OptionDaoImpl();
    private final UserDao userDao = new UserDaoImpl();
    private final PollResponseDao pollResponseDao = new PollResponseDaoImpl();

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return Holder.INSTANCE;
    }

    public TopicDao getTopicDao() {
        return topicDao;
    }

    public PollDao getPollDao() {
        return pollDao;
    }

    public QuestionDao getQuestionDao() {
        return questionDao;
    }

    public OptionDao getOptionDao() {
        return optionDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public PollResponseDao getPollResponseDao() {
        return pollResponseDao;
    }

    private static class Holder {
        static final DaoFactory INSTANCE = new DaoFactory();
    }
}
