package com.dev.socialPoll.dao.mapper;

public final class Column {
    public static final String TOPIC_ID = "topic_id";
    public static final String TOPIC_NAME = "topic_name";
    public static final String TOPIC_DESCRIPTION = "description";
    public static final String TOPIC_NUM_POLLS = "num_polls";
    public static final String TOPIC_NUM_PARTICIPANTS = "num_participants";

    public static final String POLL_ID = "poll_id";
    public static final String POLL_TOPIC_ID = "topic_id";
    public static final String POLL_NAME = "poll_name";
    public static final String POLL_DESCRIPTION = "description";
    public static final String POLL_NUM_QUESTIONS = "num_questions";
    public static final String POLL_NUM_PARTICIPANTS = "num_participants";
    public static final String POLL_STATUS = "status";

    public static final String QUESTION_ID = "question_id";
    public static final String QUESTION_POLL_ID = "poll_id";
    public static final String QUESTION_TEXT = "question_text";

    public static final String OPTION_ID = "option_id";
    public static final String OPTION_QUESTION_ID = "question_id";
    public static final String OPTION_TEXT = "option_text";
    public static final String OPTION_NUM_PARTICIPANTS = "num_participants";

    public static final String USER_ID = "user_id";
    public static final String USER_FIRST_NAME = "first_name";
    public static final String USER_LAST_NAME = "last_name";
    public static final String USER_BIRTHDAY = "birthday";
    public static final String USER_GENDER = "gender";
    public static final String USER_EMAIL = "email";
    public static final String USER_PASSWORD = "password";
    public static final String USER_ROLE = "role";

    public static final String POLL_RESPONSE_ID = "response_id";
    public static final String POLL_RESPONSE_POLL_ID = "poll_id";
    public static final String POLL_RESPONSE_QUESTION_ID = "question_id";
    public static final String POLL_RESPONSE_OPTION_ID = "option_id";
    public static final String POLL_RESPONSE_USER_ID = "user_id";
    public static final String POLL_RESPONSE_TIME = "response_time";
}