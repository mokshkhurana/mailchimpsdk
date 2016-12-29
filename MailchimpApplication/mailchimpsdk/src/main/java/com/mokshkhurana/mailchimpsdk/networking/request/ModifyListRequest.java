package com.mokshkhurana.mailchimpsdk.networking.request;

import com.google.gson.annotations.SerializedName;
import com.mokshkhurana.mailchimpsdk.enums.Visibility;
import com.mokshkhurana.mailchimpsdk.model.CampaignDefaults;
import com.mokshkhurana.mailchimpsdk.model.Contact;

public class ModifyListRequest {

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

    @SerializedName("email_type_option")
    private Boolean emailTypeOption;

    @SerializedName("visibility")
    private Visibility visibility;

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public void setPermissionReminder(String permissionReminder) {
        this.permissionReminder = permissionReminder;
    }

    public void setUseArchiveBar(Boolean useArchiveBar) {
        this.useArchiveBar = useArchiveBar;
    }

    public void setCampaignDefaults(CampaignDefaults campaignDefaults) {
        this.campaignDefaults = campaignDefaults;
    }

    public void setNotifyOnSubscribe(String notifyOnSubscribe) {
        this.notifyOnSubscribe = notifyOnSubscribe;
    }

    public void setNotifyOnUnsubscribe(String notifyOnUnsubscribe) {
        this.notifyOnUnsubscribe = notifyOnUnsubscribe;
    }

    public void setEmailTypeOption(Boolean emailTypeOption) {
        this.emailTypeOption = emailTypeOption;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }
}
