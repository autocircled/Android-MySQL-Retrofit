package com.example.loginappexample.API;

import com.google.gson.annotations.SerializedName;

public class UserModel {
    @SerializedName("reply")
    private String reply;

    @SerializedName("name")
    private String name;

    public String getReply() {
        return reply;
    }

    public String getName() {
        return name;
    }
}
