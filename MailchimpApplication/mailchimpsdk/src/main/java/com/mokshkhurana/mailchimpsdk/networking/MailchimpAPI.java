package com.mokshkhurana.mailchimpsdk.networking;

import com.mokshkhurana.mailchimpsdk.model.ListInfo;
import com.mokshkhurana.mailchimpsdk.networking.request.CreateListRequest;
import com.mokshkhurana.mailchimpsdk.networking.response.ListResponse;
import com.squareup.okhttp.ResponseBody;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
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

    @POST("lists")
    Call<ListInfo> createList(@Body CreateListRequest createListRequest);

    @DELETE("lists/{id}")
    Call<ResponseBody> deleteList(@Path(value = "id", encoded = true) String id);
}
