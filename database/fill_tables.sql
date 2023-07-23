/* Filling in the table "topics" */
INSERT INTO topics (topic_name, description, num_polls, num_participants)
VALUES ('Science', 'Discuss various scientific topics.', 2, 150);

INSERT INTO topics (topic_name, description, num_polls, num_participants)
VALUES ('Technology', 'Explore the latest tech trends.', 3, 200);

INSERT INTO topics (topic_name, description, num_polls, num_participants)
VALUES ('Sports', 'Share your favorite sports moments.', 1, 100);


/* Filling in the table "polls" */
INSERT INTO polls (topic_id, poll_name, description, num_questions, num_participants, status)
VALUES (1, 'Physics Poll', 'Take this poll on physics topics.', 3, 50, 'NEW');

INSERT INTO polls (topic_id, poll_name, description, num_questions, num_participants, status)
VALUES (1, 'Biology Poll', 'Share your knowledge on biology.', 2, 30, 'NEW');

INSERT INTO polls (topic_id, poll_name, description, num_questions, num_participants, status)
VALUES (2, 'Gadgets Poll', 'Vote for your favorite gadgets.', 4, 80, 'NEW');

INSERT INTO polls (topic_id, poll_name, description, num_questions, num_participants, status)
VALUES (3, 'Football Poll', 'Pick your favorite football team.', 1, 70, 'NEW');



/* Filling in the table "questions" */
INSERT INTO questions (poll_id, question_text)
VALUES (1, 'What is the speed of light in a vacuum?');

INSERT INTO questions (poll_id, question_text)
VALUES (1, 'What is the formula for calculating force?');

INSERT INTO questions (poll_id, question_text)
VALUES (1, 'What is the atomic number of carbon?');

INSERT INTO questions (poll_id, question_text)
VALUES (2, 'What is the process of photosynthesis?');

INSERT INTO questions (poll_id, question_text)
VALUES (2, 'What are the four primary types of organic compounds?');

INSERT INTO questions (poll_id, question_text)
VALUES (3, 'Which smartphone brand do you prefer?');

INSERT INTO questions (poll_id, question_text)
VALUES (3, 'What is your favorite laptop brand?');

INSERT INTO questions (poll_id, question_text)
VALUES (3, 'Which smartwatch do you like the most?');

INSERT INTO questions (poll_id, question_text)
VALUES (3, 'Which gaming console do you use?');

INSERT INTO questions (poll_id, question_text)
VALUES (4, 'Which football team is your favorite?');



/* Filling in the table "options" */
INSERT INTO options (question_id, option_text, num_participants)
VALUES (1, '299,792,458 meters per second', 25);

INSERT INTO options (question_id, option_text, num_participants)
VALUES (1, '300,000,000 meters per second', 15);

INSERT INTO options (question_id, option_text, num_participants)
VALUES (1, '200,000,000 meters per second', 10);

INSERT INTO options (question_id, option_text, num_participants)
VALUES (2, 'F = ma', 18);

INSERT INTO options (question_id, option_text, num_participants)
VALUES (2, 'F = mv', 12);

INSERT INTO options (question_id, option_text, num_participants)
VALUES (3, '6', 20);

INSERT INTO options (question_id, option_text, num_participants)
VALUES (3, '8', 8);

INSERT INTO options (question_id, option_text, num_participants)
VALUES (4, 'Process of converting light into energy', 22);

INSERT INTO options (question_id, option_text, num_participants)
VALUES (4, 'Process of converting carbon dioxide and water into glucose and oxygen', 28);



/* Filling in the table "users" */
INSERT INTO users (first_name, last_name, birthday, gender, email, password, role)
VALUES ('Alice', 'Smith', '1990-05-15', 'Female', 'alice.smith@example.com', 'password123', 'USER');

INSERT INTO users (first_name, last_name, birthday, gender, email, password, role)
VALUES ('Bob', 'Johnson', '1985-10-25', 'Male', 'bob.johnson@example.com', 'securepass', 'ADMIN');


/* Filling in the table "poll_responses" */
INSERT INTO poll_responses (poll_id, question_id, option_id, user_id, response_time)
VALUES (1, 1, 1, 1);

INSERT INTO poll_responses (poll_id, question_id, option_id, user_id, response_time)
VALUES (1, 2, 4, 2);