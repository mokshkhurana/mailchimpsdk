package com.mokshkhurana.mailchimpsdk.model;


import com.google.gson.annotations.SerializedName;

public class CampaignDefaults {

    @SerializedName("from_name")
    private String fromName;

    @SerializedName("from_email")
    private String fromEmail;

    @SerializedName("subject")
    private String subject;

    @SerializedName("language")
    private String language;

    public String getFromName() {
        return fromName;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public String getSubject() {
        return subject;
    }

    public String getLanguage() {
        return language;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
