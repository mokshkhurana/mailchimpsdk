package com.mokshkhurana.mailchimpsdk.model;

import com.google.gson.annotations.SerializedName;

public class Links {

    @SerializedName("rel")
    private String rel;

    @SerializedName("href")
    private String href;

    @SerializedName("method")
    private String method;

    @SerializedName("targetSchema")
    private String targetSchema;

    @SerializedName("schema")
    private String schema;

    public String getRel() {
        return rel;
    }

    public String getHref() {
        return href;
    }

    public String getMethod() {
        return method;
    }

    public String getTargetSchema() {
        return targetSchema;
    }

    public String getSchema() {
        return schema;
    }
}
