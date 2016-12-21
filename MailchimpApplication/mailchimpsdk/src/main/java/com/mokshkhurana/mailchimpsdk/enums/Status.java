package com.mokshkhurana.mailchimpsdk.enums;

import com.google.gson.annotations.SerializedName;

public enum Status {

    @SerializedName("subscribed")
    SUBSCRIBED,
    @SerializedName("unsubscribed")
    UNSUBSCRIBED,
    @SerializedName("cleaned")
    CLEANED,
    @SerializedName("pending")
    PENDING;
}
