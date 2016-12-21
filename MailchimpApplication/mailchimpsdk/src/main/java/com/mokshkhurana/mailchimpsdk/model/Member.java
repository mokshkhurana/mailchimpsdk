package com.mokshkhurana.mailchimpsdk.model;

import com.google.gson.annotations.SerializedName;
import com.mokshkhurana.mailchimpsdk.enums.Status;

import java.util.ArrayList;

public class Member {

    @SerializedName("email_address")
    private String emailAddress;

    @SerializedName("email_type")
    private String emailType;

    @SerializedName("status")
    private Status status;

    @SerializedName("language")
    private String language;

    @SerializedName("vip")
    private Boolean vip;

    @SerializedName("location")
    private Location location;

    @SerializedName("ip_signup")
    private String ipSignup;

    @SerializedName("timestamp_signup")
    private String timestampSignup;

    @SerializedName("ip_opt")
    private String ipOpt;

    @SerializedName("timestamp_opt")
    private String timestampOpt;

    @SerializedName("id")
    private String id;

    @SerializedName("unique_email_id")
    private String uniqueEmailId;

    @SerializedName("stats")
    private Stats stats;

    @SerializedName("member_rating")
    private Integer memberRating;

    @SerializedName("last_changed")
    private String lastChanged;

    @SerializedName("email_client")
    private String emailClient;

    @SerializedName("last_note")
    private Note lastNote;

    @SerializedName("list_id")
    private String listId;

    @SerializedName("_links")
    private ArrayList<Links> links;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getVip() {
        return vip;
    }

    public void setVip(Boolean vip) {
        this.vip = vip;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getIpSignup() {
        return ipSignup;
    }

    public void setIpSignup(String ipSignup) {
        this.ipSignup = ipSignup;
    }

    public String getTimestampSignup() {
        return timestampSignup;
    }

    public void setTimestampSignup(String timestampSignup) {
        this.timestampSignup = timestampSignup;
    }

    public String getIpOpt() {
        return ipOpt;
    }

    public void setIpOpt(String ipOpt) {
        this.ipOpt = ipOpt;
    }

    public String getTimestampOpt() {
        return timestampOpt;
    }

    public void setTimestampOpt(String timestampOpt) {
        this.timestampOpt = timestampOpt;
    }

    public String getId() {
        return id;
    }

    public String getUniqueEmailId() {
        return uniqueEmailId;
    }

    public Stats getStats() {
        return stats;
    }

    public Integer getMemberRating() {
        return memberRating;
    }

    public String getLastChanged() {
        return lastChanged;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public Note getLastNote() {
        return lastNote;
    }

    public String getListId() {
        return listId;
    }

    public ArrayList<Links> getLinks() {
        return links;
    }
}
