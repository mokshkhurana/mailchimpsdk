package com.mokshkhurana.mailchimpsdk.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ListResponse {

    @SerializedName("lists")
    private ArrayList<ListInfo> listArray;

    @SerializedName("total_items")
    private Integer totalItems;

    @SerializedName("_links")
    private ArrayList<Links> links;

    public ArrayList<ListInfo> getListArray() {
        return listArray;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public ArrayList<Links> getLinks() {
        return links;
    }
}
