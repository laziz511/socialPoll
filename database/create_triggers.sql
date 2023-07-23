-- Trigger to update num_polls and num_participants in topics table
CREATE OR REPLACE FUNCTION update_topic_counts()
RETURNS TRIGGER AS
$$
BEGIN
    IF TG_OP = 'INSERT' THEN
        UPDATE topics
        SET num_polls = num_polls + 1
        WHERE topic_id = NEW.topic_id;

        UPDATE topics
        SET num_participants = num_participants + 1
        WHERE topic_id = NEW.topic_id;
    ELSIF TG_OP = 'DELETE' THEN
        UPDATE topics
        SET num_polls = num_polls - 1
        WHERE topic_id = OLD.topic_id;

        UPDATE topics
        SET num_participants = num_participants - OLD.num_participants
        WHERE topic_id = OLD.topic_id;
    END IF;
    RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER update_topic_counts
AFTER INSERT OR DELETE
ON polls
FOR EACH ROW
EXECUTE FUNCTION update_topic_counts();

-- Trigger to update num_questions and num_participants in polls table
CREATE OR REPLACE FUNCTION update_poll_counts()
RETURNS TRIGGER AS
$$
BEGIN
    IF TG_OP = 'INSERT' THEN
        UPDATE polls
        SET num_questions = num_questions + 1
        WHERE poll_id = NEW.poll_id;

        UPDATE polls
        SET num_participants = num_participants + 1
        WHERE poll_id = NEW.poll_id;
    ELSIF TG_OP = 'DELETE' THEN
        UPDATE polls
        SET num_questions = num_questions - 1
        WHERE poll_id = OLD.poll_id;

        UPDATE polls
        SET num_participants = num_participants - OLD.num_participants
        WHERE poll_id = OLD.poll_id;
    END IF;
    RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER update_poll_counts
AFTER INSERT OR DELETE
ON questions
FOR EACH ROW
EXECUTE FUNCTION update_poll_counts();