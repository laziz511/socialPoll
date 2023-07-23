package com.dev.socialPoll.service;

import com.dev.socialPoll.service.impl.*;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final UserService userService = new UserServiceImpl();
    private final TopicService topicService = new TopicServiceImpl();
    private final PollService pollService = new PollServiceImpl();
    private final QuestionService questionService = new QuestionServiceImpl();
    private final OptionService optionService = new OptionServiceImpl();
    private final PollResponseService pollResponseService = new PollResponseServiceImpl();

    private ServiceFactory() {
        // Private constructor to prevent instantiation from outside the class
    }

    public static ServiceFactory getInstance() {
        return Holder.INSTANCE;
    }

    public TopicService getTopicService() {
        return topicService;
    }

    public UserService getUserService() {
        return userService;
    }

    public PollService getPollService() {
        return pollService;
    }

    public QuestionService getQuestionService() {
        return questionService;
    }

    public OptionService getOptionService() {
        return optionService;
    }

    public PollResponseService getPollResponseService() {
        return pollResponseService;
    }

    private static class Holder {
        static final ServiceFactory INSTANCE = new ServiceFactory();
    }

}
