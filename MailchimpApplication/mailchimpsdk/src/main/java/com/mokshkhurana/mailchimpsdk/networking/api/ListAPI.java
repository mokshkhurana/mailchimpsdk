package com.mokshkhurana.mailchimpsdk.networking.api;

import com.mokshkhurana.mailchimpsdk.model.ListInfo;
import com.mokshkhurana.mailchimpsdk.networking.request.AddMembersRequest;
import com.mokshkhurana.mailchimpsdk.networking.request.ModifyListRequest;
import com.mokshkhurana.mailchimpsdk.networking.response.AddMembersResponse;
import com.mokshkhurana.mailchimpsdk.networking.response.ListResponse;
import com.squareup.okhttp.ResponseBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ListAPI {
    @GET("lists")
    Call<ListResponse> getLists();

    @GET("lists/{id}")
    Call<ListInfo> getListById(@Path(value = "id", encoded = true) String id, @Query("fields") String fields, @Query("exclude_fields") String excludeFields);

    @POST("lists")
    Call<ListInfo> createList(@Body ModifyListRequest modifyListRequest);

    @DELETE("lists/{id}")
    Call<ResponseBody> deleteList(@Path(value = "id", encoded = true) String id);

    @POST("lists/{id}")
    Call<AddMembersResponse> addMembers(@Path(value = "id", encoded = true) String listId, @Body AddMembersRequest addMembersRequest);

    @PATCH("lists/{id}")
    Call<ListInfo> updateList(@Path(value = "id", encoded = true) String listId, @Body ModifyListRequest modifyListRequest);
}
