package com.dev.socialPoll.entity;


public class PollResponse implements Identifiable {
    private long id;
    private long pollId;
    private long questionId;
    private long optionId;
    private long userId;

    public PollResponse() {}

    public PollResponse(long id, long pollId, long questionId, long optionId, long userId) {
        this.id = id;
        this.pollId = pollId;
        this.questionId = questionId;
        this.optionId = optionId;
        this.userId = userId;
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

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public long getOptionId() {
        return optionId;
    }

    public void setOptionId(long optionId) {
        this.optionId = optionId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    // equals, hashCode, and toString methods

    @Override
    public String toString() {
        return "PollResponse{" +
                "id=" + id +
                ", pollId=" + pollId +
                ", questionId=" + questionId +
                ", optionId=" + optionId +
                ", userId=" + userId +
                '}';
    }
}
