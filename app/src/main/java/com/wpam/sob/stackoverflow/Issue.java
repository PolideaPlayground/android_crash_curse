package com.wpam.sob.stackoverflow;

import com.google.gson.annotations.SerializedName;

public class Issue {

    @SerializedName("answer_count")
    private int answerCount;
    private String title;
    private Owner owner;

    public Issue(int answerCount, String title, Owner owner) {
        this.answerCount = answerCount;
        this.title = title;
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
}
