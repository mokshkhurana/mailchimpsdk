package com.mokshkhurana.mailchimpsdk.model;

import com.google.gson.annotations.SerializedName;

public class Error {

    @SerializedName("type")
    private String type;

    @SerializedName("title")
    private String title;

    @SerializedName("status")
    private Integer status = -1;

    @SerializedName("detail")
    private String detail;

    @SerializedName("instance")
    private String instance;

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDetail() {
        return detail;
    }

    public String getInstance() {
        return instance;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
