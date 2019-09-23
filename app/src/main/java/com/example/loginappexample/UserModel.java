package com.example.loginappexample;

import com.google.gson.annotations.SerializedName;

public class UserModel {
    @SerializedName("response")
    private String response;

    @SerializedName("name")
    private String name;

    public String getResponse() {
        return response;
    }

    public String getName() {
        return name;
    }
}
