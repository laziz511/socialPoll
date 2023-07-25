/* Filling in the table "topics" */
INSERT INTO topics (topic_name, description)
VALUES
    ('Family', 'Polls related to family matters and relationships.'),
    ('Environment', 'Polls related to environmental issues and sustainability.'),
    ('Gender Equality', 'Polls related to gender equality and womens rights.'),
    ('Politics', 'Polls related to political topics and government policies.');



/* Filling in the table "polls" */
-- Polls related to 'Family' topic
INSERT INTO polls (topic_id, poll_name, description, num_questions, num_participants, status)
VALUES (1, 'Family Poll 1', 'This is the first poll about family.', 0, 0, 'NEW');

INSERT INTO polls (topic_id, poll_name, description, num_questions, num_participants, status)
VALUES (1, 'Family Poll 2', 'This is the second poll about family.', 0, 0, 'NEW');

-- Polls related to 'Environment' topic
INSERT INTO polls (topic_id, poll_name, description, num_questions, num_participants, status)
VALUES (2, 'Environment Poll 1', 'This is the first poll about the environment.', 0, 0, 'NEW');

INSERT INTO polls (topic_id, poll_name, description, num_questions, num_participants, status)
VALUES (2, 'Environment Poll 2', 'This is the second poll about the environment.', 0, 0, 'NEW');

-- Polls related to 'Gender Equality' topic
INSERT INTO polls (topic_id, poll_name, description, num_questions, num_participants, status)
VALUES (3, 'Gender Equality Poll 1', 'This is the first poll about gender equality.', 0, 0, 'NEW');

INSERT INTO polls (topic_id, poll_name, description, num_questions, num_participants, status)
VALUES (3, 'Gender Equality Poll 2', 'This is the second poll about gender equality.', 0, 0, 'NEW');

-- Polls related to 'Politics' topic
INSERT INTO polls (topic_id, poll_name, description, num_questions, num_participants, status)
VALUES (4, 'Politics Poll 1', 'This is the first poll about politics.', 0, 0, 'NEW');

INSERT INTO polls (topic_id, poll_name, description, num_questions, num_participants, status)
VALUES (4, 'Politics Poll 2', 'This is the second poll about politics.', 0, 0, 'NEW');



/* Filling in the table "questions" */
INSERT INTO questions (poll_id, question_text) VALUES
    (9, 'How important is family time for you?'),
    (9, 'Do you think family support is crucial for personal growth?'),
    (10, 'How do you handle conflicts within your family?'),
    (10, 'What is your favorite family tradition?'),
    (11, 'What do you think is the most pressing environmental issue today?'),
    (11, 'What steps do you take to reduce your environmental footprint?'),
    (12, 'How concerned are you about climate change?'),
    (12, 'Have you participated in any environmental conservation activities?'),
    (13, 'Do you believe gender equality has improved in recent years?'),
    (13, 'What are some challenges that still exist in achieving gender equality?'),
    (14, 'How important is promoting gender equality in educational institutions?'),
    (14, 'Have you witnessed instances of gender discrimination in your workplace?'),
    (15, 'What are the key factors you consider when voting for a political candidate?'),
    (15, 'How satisfied are you with the current state of politics in the country?'),
    (16, 'What is your opinion on the government''s economic policies?'),
    (16, 'Do you believe the government is doing enough to address social issues?');




/* Filling in the table "options" */
INSERT INTO options (question_id, option_text) VALUES
    (2, 'Extremely important'),
    (2, 'Very important'),
    (2, 'Moderately important'),
    (3, 'Yes, it is crucial'),
    (3, 'It can be helpful in some cases'),
    (3, 'No, it is not essential'),
    (4, 'Open communication and discussion'),
    (4, 'Listening and understanding each other'),
    (4, 'Compromise and finding common ground'),
    (5, 'Celebrating birthdays and holidays together'),
    (5, 'Gathering for family meals'),
    (5, 'Passing down family traditions to younger generations'),
    (6, 'Climate change'),
    (6, 'Deforestation'),
    (6, 'Water pollution'),
    (7, 'Using energy-efficient appliances'),
    (7, 'Reducing, reusing, and recycling'),
    (7, 'Conserving water and electricity'),
    (8, 'Very concerned'),
    (8, 'Moderately concerned'),
    (8, 'Not concerned'),
    (9, 'Yes, I actively participate'),
    (9, 'I have participated in the past'),
    (9, 'No, I have not participated'),
    (10, 'Yes, it has improved significantly'),
    (10, 'Yes, but progress is slow'),
    (10, 'No, it has not improved'),
    (11, 'Equal pay and opportunities'),
    (11, 'Gender stereotypes and biases'),
    (11, 'Access to education and healthcare'),
    (12, 'Very important'),
    (12, 'Somewhat important'),
    (12, 'Not very important'),
    (13, 'Yes, I have witnessed instances'),
    (13, 'I have not witnessed any instances'),
    (13, 'I am not sure'),
    (14, 'Candidate''s stance on important issues'),
    (14, 'Candidate''s track record and experience'),
    (14, 'Candidate''s ability to bring about change'),
    (15, 'Satisfied'),
    (15, 'Neutral'),
    (15, 'Dissatisfied'),
    (16, 'I agree with them'),
    (16, 'I disagree with them'),
    (16, 'I am unsure'),
    (17, 'Yes, the government is doing enough'),
    (17, 'No, more needs to be done'),
    (17, 'I am undecided');



/* Filling in the table "users" */
INSERT INTO users (first_name, last_name, birthday, gender, email, password, role)
 VALUES ('Laziz', 'Djuraev', '2003-10-11', 'MALE', 'lazizo2004@gmail.com', 'admin', 'ADMIN');



/* Filling in the table "poll_responses" */
-- Question 1 response
INSERT INTO poll_responses (poll_id, question_id, option_id, user_id)
VALUES (9, 2, 3, 1);

-- Question 2 response
INSERT INTO poll_responses (poll_id, question_id, option_id, user_id)
VALUES (9, 3, 6, 1);

-- Question 3 response
INSERT INTO poll_responses (poll_id, question_id, option_id, user_id)
VALUES (10, 4, 9, 1);

-- Question 4 response
INSERT INTO poll_responses (poll_id, question_id, option_id, user_id)
VALUES (10, 5, 12, 1);

-- Question 5 response
INSERT INTO poll_responses (poll_id, question_id, option_id, user_id)
VALUES (11, 6, 15, 1);

-- Question 6 response
INSERT INTO poll_responses (poll_id, question_id, option_id, user_id)
VALUES (11, 7, 18, 1);

-- Question 7 response
INSERT INTO poll_responses (poll_id, question_id, option_id, user_id)
VALUES (12, 8, 21, 1);

-- Question 8 response
INSERT INTO poll_responses (poll_id, question_id, option_id, user_id)
VALUES (12, 9, 24, 1);

-- Question 9 response
INSERT INTO poll_responses (poll_id, question_id, option_id, user_id)
VALUES (13, 10, 27, 1);

-- Question 10 response
INSERT INTO poll_responses (poll_id, question_id, option_id, user_id)
VALUES (13, 11, 30, 1);

-- Question 11 response
INSERT INTO poll_responses (poll_id, question_id, option_id, user_id)
VALUES (14, 12, 33, 1);

-- Question 12 response
INSERT INTO poll_responses (poll_id, question_id, option_id, user_id)
VALUES (14, 13, 36, 1);

-- Question 13 response
INSERT INTO poll_responses (poll_id, question_id, option_id, user_id)
VALUES (15, 14, 39, 1);

-- Question 14 response
INSERT INTO poll_responses (poll_id, question_id, option_id, user_id)
VALUES (15, 15, 42, 1);

-- Question 15 response
INSERT INTO poll_responses (poll_id, question_id, option_id, user_id)
VALUES (16, 16, 45, 1);

-- Question 16 response
INSERT INTO poll_responses (poll_id, question_id, option_id, user_id)
VALUES (16, 17, 48, 1);