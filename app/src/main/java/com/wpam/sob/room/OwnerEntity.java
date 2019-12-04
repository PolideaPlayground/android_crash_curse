package com.wpam.sob.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.wpam.sob.stackoverflow.Owner;

@Entity
public class OwnerEntity {
    @PrimaryKey
    public long userId;

    @ColumnInfo
    public String name;

    @ColumnInfo
    public String avatartUrl;

    public OwnerEntity() {
    }

    public OwnerEntity(Owner owner) {
        userId = owner.getUserId();
        name = owner.getName();
        avatartUrl = owner.getAvatarUrl();
    }
}
