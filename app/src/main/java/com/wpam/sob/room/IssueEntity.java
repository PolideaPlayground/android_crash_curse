package com.wpam.sob.room;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.wpam.sob.stackoverflow.Issue;
import com.wpam.sob.stackoverflow.Owner;

@Entity
public class IssueEntity {
    @PrimaryKey
    public long questionId;

    @ColumnInfo(name = "answer_count")
    public int answerCount;

    @ColumnInfo(name = "score")
    public int score;

    @ColumnInfo(name = "title")
    public String title;

    @Embedded
    public OwnerEntity owner;

    public IssueEntity() {
    }

    public IssueEntity(Issue issue) {
        questionId = issue.getQuestionId();
        answerCount = issue.getAnswerCount();
        score = issue.getScore();
        title = issue.getTitle();
        owner = new OwnerEntity(issue.getOwner());
    }
}
