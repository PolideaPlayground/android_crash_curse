package com.wpam.sob.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface IssuesDao {

    @Query("SELECT * FROM IssueEntity")
    List<IssueEntity> getAll();

    @Query("SELECT * FROM IssueEntity WHERE questionId IS :questionId LIMIT 1")
    IssueEntity findByQuestionId(long questionId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(IssueEntity... issues);

    @Delete
    void delete(IssueEntity issue);
}
