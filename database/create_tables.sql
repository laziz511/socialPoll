

-- Table for storing topics
CREATE TABLE IF NOT EXISTS topics (
    topic_id           SERIAL PRIMARY KEY,
    topic_name         VARCHAR(100) NOT NULL,
    description        TEXT,
    num_polls          INTEGER DEFAULT 0,
    num_participants   INTEGER DEFAULT 0
);

-- Table for storing polls
CREATE TABLE IF NOT EXISTS polls (
    poll_id             SERIAL PRIMARY KEY,
    topic_id            INT NOT NULL REFERENCES topics(topic_id),
    poll_name           VARCHAR(200) NOT NULL,
    description         TEXT,
    num_questions       INTEGER DEFAULT 0,
    num_participants    INTEGER DEFAULT 0,
    status              VARCHAR(10) NOT NULL CHECK (status IN ('NEW', 'EDITED', 'ARCHIVED', 'DELETED'))
);

-- Table for storing questions
CREATE TABLE IF NOT EXISTS questions (
    question_id         SERIAL PRIMARY KEY,
    poll_id             INT NOT NULL REFERENCES polls(poll_id),
    question_text       TEXT NOT NULL
);

-- Table for storing options
CREATE TABLE IF NOT EXISTS options (
    option_id SERIAL     PRIMARY KEY,
    question_id          INT NOT NULL REFERENCES questions(question_id),
    option_text          TEXT NOT NULL,
    num_participants     INTEGER DEFAULT 0
);

-- Table for storing users
CREATE TABLE IF NOT EXISTS users (
    user_id            SERIAL PRIMARY KEY,
    first_name         VARCHAR(100) NOT NULL,
    last_name          VARCHAR(100) NOT NULL,
    birthday           DATE NOT NULL,
    gender             VARCHAR(10) NOT NULL,
    email              VARCHAR(100) NOT NULL UNIQUE,
    password           VARCHAR(100) NOT NULL,
    role               VARCHAR(10) NOT NULL CHECK (role IN ('ADMIN', 'USER', 'GUEST'))
);

-- Table for storing poll responses
CREATE TABLE IF NOT EXISTS poll_responses (
    response_id         SERIAL PRIMARY KEY,
    poll_id             INT NOT NULL REFERENCES polls(poll_id),
    question_id         INT NOT NULL REFERENCES questions(question_id),
    option_id           INT NOT NULL REFERENCES options(option_id),
    user_id             INT NOT NULL REFERENCES users(user_id)
);
