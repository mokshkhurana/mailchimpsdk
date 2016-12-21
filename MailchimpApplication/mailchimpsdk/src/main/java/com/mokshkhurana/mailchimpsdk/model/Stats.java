package com.mokshkhurana.mailchimpsdk.model;

import com.google.gson.annotations.SerializedName;

public class Stats {

    @SerializedName("avg_open_rate")
    private Number averageOpenRate;

    @SerializedName("avg_click_rate")
    private Number averageClickRate;

    public Number getAverageClickRate() {
        return averageClickRate;
    }

    public Number getAverageOpenRate() {
        return averageOpenRate;
    }
}
