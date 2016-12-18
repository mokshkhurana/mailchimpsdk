package com.mokshkhurana.mailchimpsdk.model;

import com.google.gson.annotations.SerializedName;

public class Statistics {

    @SerializedName("member_count")
    private Integer memberCount;

    @SerializedName("unsubscribe_count")
    private Integer unsubscribeCount;

    @SerializedName("cleaned_count")
    private Integer cleanedCount;

    @SerializedName("member_count_since_send")
    private Integer memberCountSinceSend;

    @SerializedName("unsubscribe_count_since_send")
    private Integer unsubscribeCountSinceSend;

    @SerializedName("cleaned_count_since_send")
    private Integer cleanedCountSinceSend;

    @SerializedName("campaign_count")
    private Integer campaignCount;

    @SerializedName("campaign_last_sent")
    private String campaignLastSent;

    @SerializedName("merge_field_count")
    private Integer mergeFieldCount;

    @SerializedName("avg_sub_rate")
    private Number averageSubscriptionRate;

    @SerializedName("avg_unsub_rate")
    private Number averageUnsubscriptionRate;

    @SerializedName("target_sub_rate")
    private Number targetSubscriptionRate;

    @SerializedName("open_rate")
    private Number openRate;

    @SerializedName("click_rate")
    private Number clickRate;

    @SerializedName("last_sub_date")
    private String lastSubscriptionDate;

    @SerializedName("last_unsub_date")
    private String lastUnsubscriptionDate;

    public Integer getMemberCount() {
        return memberCount;
    }

    public Integer getUnsubscribeCount() {
        return unsubscribeCount;
    }

    public Integer getCleanedCount() {
        return cleanedCount;
    }

    public Integer getMemberCountSinceSend() {
        return memberCountSinceSend;
    }

    public Integer getUnsubscribeCountSinceSend() {
        return unsubscribeCountSinceSend;
    }

    public Integer getCleanedCountSinceSend() {
        return cleanedCountSinceSend;
    }

    public Integer getCampaignCount() {
        return campaignCount;
    }

    public String getCampaignLastSent() {
        return campaignLastSent;
    }

    public Integer getMergeFieldCount() {
        return mergeFieldCount;
    }

    public Number getAverageSubscriptionRate() {
        return averageSubscriptionRate;
    }

    public Number getAverageUnsubscriptionRate() {
        return averageUnsubscriptionRate;
    }

    public Number getTargetSubscriptionRate() {
        return targetSubscriptionRate;
    }

    public Number getOpenRate() {
        return openRate;
    }

    public Number getClickRate() {
        return clickRate;
    }

    public String getLastSubscriptionDate() {
        return lastSubscriptionDate;
    }

    public String getLastUnsubscriptionDate() {
        return lastUnsubscriptionDate;
    }
}
