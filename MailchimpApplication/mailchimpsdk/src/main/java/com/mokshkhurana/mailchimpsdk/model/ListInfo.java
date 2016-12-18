package com.mokshkhurana.mailchimpsdk.model;

import com.google.gson.annotations.SerializedName;
import com.mokshkhurana.mailchimpsdk.enums.Visibility;

import java.util.ArrayList;

public class ListInfo {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("contact")
    private Contact contact;

    @SerializedName("permission_reminder")
    private String permissionReminder;

    @SerializedName("use_archive_bar")
    private Boolean useArchiveBar;

    @SerializedName("campaign_defaults")
    private CampaignDefaults campaignDefaults;

    @SerializedName("notify_on_subscribe")
    private String notifyOnSubscribe;

    @SerializedName("notify_on_unsubscribe")
    private String notifyOnUnsubscribe;

    @SerializedName("date_created")
    private String dateCreated;

    @SerializedName("list_rating")
    private Integer listRating;

    @SerializedName("email_type_option")
    private Boolean emailTypeOption;

    @SerializedName("subscribe_url_short")
    private String subscribeUrlShort;

    @SerializedName("subscribe_url_long")
    private String subscribeUrlLong;

    @SerializedName("beamer_address")
    private String beamerAddress;

    @SerializedName("visibility")
    private Visibility visibility;

    @SerializedName("stats")
    private Statistics statistics;

    @SerializedName("_links")
    private ArrayList<Links> links;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Contact getContact() {
        return contact;
    }

    public String getPermissionReminder() {
        return permissionReminder;
    }

    public Boolean shouldUseArchiveBar() {
        return useArchiveBar;
    }

    public CampaignDefaults getCampaignDefaults() {
        return campaignDefaults;
    }

    public String getNotifyOnSubscribe() {
        return notifyOnSubscribe;
    }

    public String getNotifyOnUnsubscribe() {
        return notifyOnUnsubscribe;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public Integer getListRating() {
        return listRating;
    }

    public Boolean getEmailTypeOption() {
        return emailTypeOption;
    }

    public String getSubscribeUrlShort() {
        return subscribeUrlShort;
    }

    public String getSubscribeUrlLong() {
        return subscribeUrlLong;
    }

    public String getBeamerAddress() {
        return beamerAddress;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public ArrayList<Links> getLinks() {
        return links;
    }
}
