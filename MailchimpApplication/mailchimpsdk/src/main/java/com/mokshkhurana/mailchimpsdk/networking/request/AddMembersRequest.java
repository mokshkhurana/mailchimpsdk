package com.mokshkhurana.mailchimpsdk.networking.request;

import com.google.gson.annotations.SerializedName;
import com.mokshkhurana.mailchimpsdk.model.Member;

import java.util.ArrayList;

public class AddMembersRequest {

    @SerializedName("members")
    private ArrayList<Member> members;

    @SerializedName("update_existing")
    private Boolean updateExisting;

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public void setUpdateExisting(Boolean updateExisting) {
        this.updateExisting = updateExisting;
    }
}
