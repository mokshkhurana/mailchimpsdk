package com.mokshkhurana.mailchimpsdk.networking.service;

import com.mokshkhurana.mailchimpsdk.MailchimpSDK;
import com.mokshkhurana.mailchimpsdk.model.ListInfo;
import com.mokshkhurana.mailchimpsdk.model.ServiceError;
import com.mokshkhurana.mailchimpsdk.networking.request.AddMembersRequest;
import com.mokshkhurana.mailchimpsdk.networking.request.CreateListRequest;
import com.mokshkhurana.mailchimpsdk.networking.response.AddMembersResponse;
import com.mokshkhurana.mailchimpsdk.networking.response.ListResponse;
import com.mokshkhurana.mailchimpsdk.networking.response.Response;
import com.mokshkhurana.mailchimpsdk.util.Utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class ListService {

    /**
     * Gets all the lists by issuing an async request.
     * @param sdk SDK required to check if it's initialized and API call.
     * @param responseListener Listener required to notify onSuccess and onFailure.
     */
    public static void getLists(MailchimpSDK sdk, final Response<ListResponse> responseListener) {
        if (sdk.isSDKInitialized()) {
            Call<ListResponse> list = sdk.getListAPI().getLists();
            list.enqueue(new Callback<ListResponse>() {
                @Override
                public void onResponse(Call<ListResponse> call, retrofit2.Response<ListResponse> response) {
                    ServiceError serviceError;
                    if ((serviceError = Utils.getError(response)) != null) {
                        responseListener.onFailure(serviceError);
                    } else {
                        responseListener.onSuccess(response.body());
                    }
                }

                @Override
                public void onFailure(Call<ListResponse> call, Throwable t) {
                    responseListener.onFailure(Utils.getEmptyError(t.getMessage()));
                }
            });
        } else {
            responseListener.onFailure(Utils.getEmptyError(MailchimpSDK.SDK_NOT_INITIALIZED));
        }
    }

    /**
     * Gets the details of a list by it's ID.
     * @param listId List ID required for fetching it's details.
     * @param fields Fields to include when fetching details. All other fields will return null. Field names are serialized strings and can be found under {@link ListInfo}.
     * @param excludeFields Fields to exclude when fetching details. Fields excluded will be null. Field names are serialized strings and can be found under {@link ListInfo}.
     * @param sdk SDK required to check if it's initialized and API call.
     * @param responseListener Listener required to notify onSuccess and onFailure.
     */
    public static void getListById(String listId, List<String> fields, List<String> excludeFields, MailchimpSDK sdk, final Response<ListInfo> responseListener) {
        if (sdk.isSDKInitialized()) {
            String fieldsString = Utils.getCommaSeparatedString(fields);
            String excludeFieldsString = Utils.getCommaSeparatedString(excludeFields);

            Call<ListInfo> list = sdk.getListAPI().getListById(listId, fieldsString, excludeFieldsString);
            list.enqueue(new Callback<ListInfo>() {
                @Override
                public void onResponse(Call<ListInfo> call, retrofit2.Response<ListInfo> response) {
                    ServiceError serviceError;
                    if ((serviceError = Utils.getError(response)) != null) {
                        responseListener.onFailure(serviceError);
                    } else {
                        responseListener.onSuccess(response.body());
                    }
                }

                @Override
                public void onFailure(Call<ListInfo> call, Throwable t) {
                    responseListener.onFailure(Utils.getEmptyError(t.getMessage()));
                }
            });
        } else {
            responseListener.onFailure(Utils.getEmptyError(MailchimpSDK.SDK_NOT_INITIALIZED));
        }
    }

    /**
     * Creates an empty list
     * @param request {@link CreateListRequest} required to send as body parameter
     * @param sdk SDK required to check if it's initialized and API call.
     * @param responseListener Listener required to notify onSuccess and onFailure.
     */
    public static void createList(CreateListRequest request, MailchimpSDK sdk, final Response<ListInfo> responseListener) {
        if (sdk.isSDKInitialized()) {
            Call<ListInfo> createList = sdk.getListAPI().createList(request);
            createList.enqueue(new Callback<ListInfo>() {
                @Override
                public void onResponse(Call<ListInfo> call, retrofit2.Response<ListInfo> response) {
                    ServiceError serviceError;
                    if ((serviceError = Utils.getError(response)) != null) {
                        responseListener.onFailure(serviceError);
                    } else {
                        responseListener.onSuccess(response.body());
                    }
                }

                @Override
                public void onFailure(Call<ListInfo> call, Throwable t) {
                    responseListener.onFailure(Utils.getEmptyError(t.getMessage()));
                }
            });
        } else {
            responseListener.onFailure(Utils.getEmptyError(MailchimpSDK.SDK_NOT_INITIALIZED));
        }
    }

    /**
     * Delete the list by it's ID
     * @param id ID of the list required to delete
     * @param sdk SDK required to check if it's initialized and API call.
     * @param responseListener Listener required to notify onSuccess and onFailure.
     */
    public static void deleteList(String id, MailchimpSDK sdk, final Response<Object> responseListener) {
        if (sdk.isSDKInitialized()) {
            Call<com.squareup.okhttp.ResponseBody> deleteList = sdk.getListAPI().deleteList(id);
            deleteList.enqueue(new Callback<com.squareup.okhttp.ResponseBody>() {
                @Override
                public void onResponse(Call<com.squareup.okhttp.ResponseBody> call, retrofit2.Response<com.squareup.okhttp.ResponseBody> response) {
                    ServiceError serviceError;
                    if ((serviceError = Utils.getError(response)) != null) {
                        responseListener.onFailure(serviceError);
                    } else {
                        responseListener.onSuccess(response.body());
                    }
                }

                @Override
                public void onFailure(Call<com.squareup.okhttp.ResponseBody> call, Throwable t) {
                    responseListener.onFailure(Utils.getEmptyError(t.getMessage()));
                }
            });
        } else {
            responseListener.onFailure(Utils.getEmptyError(MailchimpSDK.SDK_NOT_INITIALIZED));
        }
    }

    /**
     * Batch subscribe or unsubscribe list members. Maximum members allowed to update per call is 500 by Mailchimp API.
     * @param id List ID required to modify members.
     * @param request Request body for post call.
     * @param sdk SDK required to check if it's initialized and API call.
     * @param responseListener Listener required to notify onSuccess and onFailure.
     */
    public static void addMembers(String id, AddMembersRequest request, MailchimpSDK sdk, final Response<AddMembersResponse> responseListener) {
        if (sdk.isSDKInitialized()) {
            Call<AddMembersResponse> addMembers = sdk.getListAPI().addMembers(id, request);
            addMembers.enqueue(new Callback<AddMembersResponse>() {
                @Override
                public void onResponse(Call<AddMembersResponse> call, retrofit2.Response<AddMembersResponse> response) {
                    ServiceError serviceError;
                    if ((serviceError = Utils.getError(response)) != null) {
                        responseListener.onFailure(serviceError);
                    } else {
                        responseListener.onSuccess(response.body());
                    }
                }

                @Override
                public void onFailure(Call<AddMembersResponse> call, Throwable t) {
                    responseListener.onFailure(Utils.getEmptyError(t.getMessage()));
                }
            });
        }
    }
}
