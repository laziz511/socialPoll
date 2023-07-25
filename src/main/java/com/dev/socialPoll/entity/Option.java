package com.dev.socialPoll.entity;

import java.io.Serializable;

public class Option implements Identifiable, Serializable {
    private long id;
    private long questionId;
    private String optionText;
    private int numParticipants;

    public Option() {}

    public Option(long id, long questionId, String optionText, int numParticipants) {
        this.id = id;
        this.questionId = questionId;
        this.optionText = optionText;
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

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public int getNumParticipants() {
        return numParticipants;
    }

    public void setNumParticipants(int numParticipants) {
        this.numParticipants = numParticipants;
    }

    // equals, hashCode, and toString methods

    @Override
    public String toString() {
        return "Option{" +
                "id=" + id +
                ", questionId=" + questionId +
                ", optionText='" + optionText + '\'' +
                ", numParticipants=" + numParticipants +
                '}';
    }
}