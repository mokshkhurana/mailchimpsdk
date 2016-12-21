package com.mokshkhurana.mailchimpsdk.model;

import com.google.gson.annotations.SerializedName;

public class Error {

    @SerializedName("email_address")
    private String emailAddress;

    @SerializedName("error")
    private String error;

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getError() {
        return error;
    }
}
