package com.wpam.sob.stackoverflow;

import com.google.gson.annotations.SerializedName;

public class Owner {

    @SerializedName("display_name")
    private String name;

    public Owner() {
    }

    public Owner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
