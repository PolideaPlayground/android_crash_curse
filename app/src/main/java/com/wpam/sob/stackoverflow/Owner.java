package com.wpam.sob.stackoverflow;

import com.google.gson.annotations.SerializedName;
import com.wpam.sob.room.OwnerEntity;

public class Owner {

    @SerializedName("user_id")
    private long userId;

    @SerializedName("display_name")
    private String name;

    @SerializedName("profile_image")
    private String avatarUrl;

    public Owner() {
    }

    public Owner(String name) {
        this.name = name;
    }

    public Owner(OwnerEntity owner) {
        name = owner.name;
        avatarUrl = owner.avatartUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
