/* Filling in the table "topics" */
INSERT INTO topics (topic_name, description)
VALUES
    ('Family', 'Polls related to family matters and relationships.'),
    ('Environment', 'Polls related to environmental issues and sustainability.'),
    ('Gender Equality', 'Polls related to gender equality and womens rights.'),
    ('Politics', 'Polls related to political topics and government policies.');

/* Filling in the table "users" */
INSERT INTO users (first_name, last_name, birthday, gender, email, password, role)
 VALUES ('Laziz', 'Djuraev', '2003-10-11', 'MALE', 'lazizo2004@gmail.com', 'admin', 'ADMIN');

INSERT INTO users (first_name, last_name, birthday, gender, email, password, role)
 VALUES ('Admin', 'Adminov', '2003-10-11', 'MALE', 'admin@gmail.com', 'a', 'ADMIN');
