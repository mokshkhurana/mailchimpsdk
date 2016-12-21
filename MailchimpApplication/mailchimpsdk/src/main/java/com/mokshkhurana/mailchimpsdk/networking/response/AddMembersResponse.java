package com.mokshkhurana.mailchimpsdk.networking.response;

import com.google.gson.annotations.SerializedName;
import com.mokshkhurana.mailchimpsdk.model.Error;
import com.mokshkhurana.mailchimpsdk.model.Links;
import com.mokshkhurana.mailchimpsdk.model.Member;

import java.util.ArrayList;

public class AddMembersResponse {

    @SerializedName("new_members")
    private ArrayList<Member> newMembers;

    @SerializedName("updated_members")
    private ArrayList<Member> updatedMembers;

    @SerializedName("total_created")
    private Integer totalCreated;

    @SerializedName("total_updated")
    private Integer totalUpdated;

    @SerializedName("error_count")
    private Integer errorCount;

    @SerializedName("_links")
    private ArrayList<Links> links;

    @SerializedName("errors")
    private ArrayList<Error> errors;

    public ArrayList<Member> getNewMembers() {
        return newMembers;
    }

    public ArrayList<Member> getUpdatedMembers() {
        return updatedMembers;
    }

    public Integer getTotalCreated() {
        return totalCreated;
    }

    public Integer getTotalUpdated() {
        return totalUpdated;
    }

    public Integer getErrorCount() {
        return errorCount;
    }

    public ArrayList<Links> getLinks() {
        return links;
    }

    public ArrayList<Error> getErrors() {
        return errors;
    }
}
