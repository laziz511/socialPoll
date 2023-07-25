package com.dev.socialPoll.entity;

import java.io.Serializable;
import java.util.List;

public class Question implements Identifiable, Serializable {
    private long id;
    private long pollId;
    private String questionText;

    private List<Option> options;

    public Question() {}

    public Question(long id, long pollId, String questionText) {
        this.id = id;
        this.pollId = pollId;
        this.questionText = questionText;
    }

    // Getters and setters

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPollId() {
        return pollId;
    }

    public void setPollId(long pollId) {
        this.pollId = pollId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    // equals, hashCode, and toString methods

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", pollId=" + pollId +
                ", questionText='" + questionText + '\'' +
                '}';
    }
}
