package com.dev.socialPoll.entity;

import java.io.Serializable;
import java.util.List;

public class Poll implements Identifiable, Serializable {
    private long id;
    private long topicId;
    private String pollName;
    private String description;
    private int numQuestions;
    private int numParticipants;
    private PollStatus status;
    private List<Question> questions;

    public Poll() {}

    public Poll(long id, long topicId, String pollName, String description, int numQuestions, int numParticipants, PollStatus status) {
        this.id = id;
        this.topicId = topicId;
        this.pollName = pollName;
        this.description = description;
        this.numQuestions = numQuestions;
        this.numParticipants = numParticipants;
        this.status = status;
    }

    // Getters and setters

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTopicId() {
        return topicId;
    }

    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }

    public String getPollName() {
        return pollName;
    }

    public void setPollName(String pollName) {
        this.pollName = pollName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumQuestions() {
        return numQuestions;
    }

    public void setNumQuestions(int numQuestions) {
        this.numQuestions = numQuestions;
    }

    public int getNumParticipants() {
        return numParticipants;
    }

    public void setNumParticipants(int numParticipants) {
        this.numParticipants = numParticipants;
    }

    public PollStatus getStatus() {
        return status;
    }

    public void setStatus(PollStatus status) {
        this.status = status;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    // equals, hashCode, and toString methods

    @Override
    public String toString() {
        return "Poll{" +
                "id=" + id +
                ", topicId=" + topicId +
                ", pollName='" + pollName + '\'' +
                ", description='" + description + '\'' +
                ", numQuestions=" + numQuestions +
                ", numParticipants=" + numParticipants +
                ", status=" + status +
                '}';
    }
}
