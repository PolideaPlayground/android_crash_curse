package com.wpam.sob.stackoverflow;

import com.google.gson.annotations.SerializedName;
import com.wpam.sob.room.IssueEntity;

public class Issue {

    @SerializedName("answer_count")
    private int answerCount;
    @SerializedName("question_id")
    private long questionId;
    private int score;
    private String title;
    private Owner owner;

    public Issue() {
    }

    public Issue(int answerCount, String title, Owner owner) {
        this.answerCount = answerCount;
        this.title = title;
        this.owner = owner;
    }

    public Issue(IssueEntity issueEntity) {
        answerCount = issueEntity.answerCount;
        questionId = issueEntity.questionId;
        score = issueEntity.score;
        title = issueEntity.title;
        owner = new Owner(issueEntity.owner);
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public String getTitle() {
        return title;
    }

    public Owner getOwner() {
        return owner;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }
}
