package com.mokshkhurana.mailchimpsdk.networking;

import com.mokshkhurana.mailchimpsdk.model.ListInfo;
import com.mokshkhurana.mailchimpsdk.model.ListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MailchimpAPI {

    /**
     * Endpoint for mailchimp v3
     */
    String ENDPOINT = "https://<dc>.api.mailchimp.com/3.0/";


    @GET("lists")
    Call<ListResponse> getLists();

    @GET("lists/{id}")
    Call<ListInfo> getListById(@Path(value = "id", encoded = true) String id, @Query("fields") String fields, @Query("exclude_fields") String excludeFields);
}
