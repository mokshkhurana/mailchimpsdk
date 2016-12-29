package com.mokshkhurana.mailchimpsdk.model;

import com.google.gson.annotations.SerializedName;

public class MergeFields {

    @SerializedName("FNAME")
    private String firstName;

    @SerializedName("LNAME")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
