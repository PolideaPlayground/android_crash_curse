package com.wpam.sob.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {IssueEntity.class, OwnerEntity.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract IssuesDao issueDao();
}
