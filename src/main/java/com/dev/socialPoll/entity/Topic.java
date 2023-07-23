package com.dev.socialPoll.entity;

import java.io.Serializable;



public class Topic implements Identifiable, Serializable {
    private long id;
    private String topicName;
    private String description;
    private int numPolls;
    private int numParticipants;

    public Topic() {}

    public Topic(long id, String topicName, String description, int numPolls, int numParticipants) {
        this.id = id;
        this.topicName = topicName;
        this.description = description;
        this.numPolls = numPolls;
        this.numParticipants = numParticipants;
    }

    // Getters and setters

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumPolls() {
        return numPolls;
    }

    public void setNumPolls(int numPolls) {
        this.numPolls = numPolls;
    }

    public int getNumParticipants() {
        return numParticipants;
    }

    public void setNumParticipants(int numParticipants) {
        this.numParticipants = numParticipants;
    }

    // equals, hashCode, and toString methods
}