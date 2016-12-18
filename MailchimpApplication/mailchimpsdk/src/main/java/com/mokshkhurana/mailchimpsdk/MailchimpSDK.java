package com.mokshkhurana.mailchimpsdk;

import android.util.Log;

import com.mokshkhurana.mailchimpsdk.model.Error;
import com.mokshkhurana.mailchimpsdk.model.ListInfo;
import com.mokshkhurana.mailchimpsdk.networking.MailchimpAPI;
import com.mokshkhurana.mailchimpsdk.networking.request.CreateListRequest;
import com.mokshkhurana.mailchimpsdk.networking.response.ListResponse;
import com.mokshkhurana.mailchimpsdk.networking.response.Response;
import com.mokshkhurana.mailchimpsdk.util.Utils;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MailchimpSDK {

    private static MailchimpSDK ourInstance = new MailchimpSDK();
    private MailchimpAPI mMailchimpAPI;
    private String apiKey;
    private String baseUrl;
    private Retrofit mRetrofit;

    /**
     * Create a singleton instance of the SDK
     * @return Returns an instance of the SDK
     */
    public static MailchimpSDK getInstance() {
        return ourInstance;
    }

    private MailchimpSDK() {
    }

    /**
     * Checks if SDK is initialized by checking API KEY and base URL.
     * @return Returns true if SDK is initialized, false otherwise.
     */
    private boolean isSDKInitialized() {
        if (apiKey == null || apiKey.isEmpty()) {
            Log.d("Mailchimp", "apiKey cannot be null or empty");
            return false;
        } else if (baseUrl == null || baseUrl.isEmpty()) {
            Log.d("Mailchimp", "base url cannot be null or empty");
            return false;
        }
        return true;
    }

    /**
     * Initializes http client with API key passed as authorization in header for all requests. Also initializes retrofit with gson and base url.
     * @param apiKey API Key required to connect to Mailchimp endpoint.
     */
    public void initSDK(final String apiKey) {
        this.apiKey = apiKey;

        // Get the <dc> for endpoint from apikey
        String dc = apiKey.substring(apiKey.lastIndexOf('-') + 1).trim();
        baseUrl = MailchimpAPI.ENDPOINT.replaceAll("<dc>", dc);

        // Set up http client to pass apiKey in header for all requests
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder().addHeader("Authorization", "apikey " + apiKey).build();
                return chain.proceed(request);
            }
        });

        OkHttpClient client = httpClient.build();

        // Set up retrofit and create reference for mailchimp api
        mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        mMailchimpAPI = mRetrofit.create(MailchimpAPI.class);
    }

    /**
     * Gets all the lists by issuing an async request.
     * @param responseListener Listener required to notify onSuccess and onFailure.
     */
    public void getLists(final Response<ListResponse> responseListener) {
        if (isSDKInitialized()) {
            Call<ListResponse> list = mMailchimpAPI.getLists();
            list.enqueue(new Callback<ListResponse>() {
                @Override
                public void onResponse(Call<ListResponse> call, retrofit2.Response<ListResponse> response) {
                    Error error;
                    if ((error = getError(response)) != null) {
                        responseListener.onFailure(error);
                    } else  {
                        responseListener.onSuccess(response.body());
                    }
                }

                @Override
                public void onFailure(Call<ListResponse> call, Throwable t) {
                    responseListener.onFailure(getEmptyError(t.getMessage()));
                }
            });
        } else {
            responseListener.onFailure(getEmptyError("SDK not initialized"));
        }
    }

    /**
     * Gets the details of a list by it's ID.
     * @param listId List ID required for fetching it's details.
     * @param fields Fields to include when fetching details. All other fields will return null. Field names are serialized strings and can be found under {@link ListInfo}.
     * @param excludeFields Fields to exclude when fetching details. Fields excluded will be null. Field names are serialized strings and can be found under {@link ListInfo}.
     * @param responseListener Listener required to notify onSuccess and onFailure.
     */
    public void getListById(String listId, List<String> fields, List<String> excludeFields, final Response<ListInfo> responseListener) {
        if (isSDKInitialized()) {
            String fieldsString = Utils.getCommaSeparatedString(fields);
            String excludeFieldsString = Utils.getCommaSeparatedString(excludeFields);

            Call<ListInfo> list = mMailchimpAPI.getListById(listId, fieldsString, excludeFieldsString);
            list.enqueue(new Callback<ListInfo>() {
                @Override
                public void onResponse(Call<ListInfo> call, retrofit2.Response<ListInfo> response) {
                    Error error;
                    if ((error = getError(response)) != null) {
                        responseListener.onFailure(error);
                    } else {
                        responseListener.onSuccess(response.body());
                    }
                }

                @Override
                public void onFailure(Call<ListInfo> call, Throwable t) {
                    responseListener.onFailure(getEmptyError(t.getMessage()));
                }
            });
        } else {
            responseListener.onFailure(getEmptyError("SDK not initialized"));
        }
    }

    /**
     * Creates an empty list
     * @param request {@link CreateListRequest} required to send as body parameter
     * @param responseListener Listener required to notify onSuccess and onFailure.
     */
    public void createList(CreateListRequest request, final Response<ListInfo> responseListener) {
        if (isSDKInitialized()) {
            Call<ListInfo> createList = mMailchimpAPI.createList(request);
            createList.enqueue(new Callback<ListInfo>() {
                @Override
                public void onResponse(Call<ListInfo> call, retrofit2.Response<ListInfo> response) {
                    Error error;
                    if ((error = getError(response)) != null) {
                        responseListener.onFailure(error);
                    } else {
                        responseListener.onSuccess(response.body());
                    }
                }

                @Override
                public void onFailure(Call<ListInfo> call, Throwable t) {
                    responseListener.onFailure(getEmptyError(t.getMessage()));
                }
            });
        } else {
            responseListener.onFailure(getEmptyError("SDK not initialized"));
        }
    }

    /**
     * Delete the list by it's ID
     * @param id ID of the list required to delete
     * @param responseListener Listener required to notify onSuccess and onFailure.
     */
    public void deleteList(String id, final Response<Object> responseListener) {
        if (isSDKInitialized()) {
            Call<com.squareup.okhttp.ResponseBody> deleteList = mMailchimpAPI.deleteList(id);
            deleteList.enqueue(new Callback<com.squareup.okhttp.ResponseBody>() {
                @Override
                public void onResponse(Call<com.squareup.okhttp.ResponseBody> call, retrofit2.Response<com.squareup.okhttp.ResponseBody> response) {
                    Error error;
                    if ((error = getError(response)) != null) {
                        responseListener.onFailure(error);
                    } else {
                        responseListener.onSuccess(response.body());
                    }
                }

                @Override
                public void onFailure(Call<com.squareup.okhttp.ResponseBody> call, Throwable t) {
                    responseListener.onFailure(getEmptyError(t.getMessage()));
                }
            });
        } else {
            responseListener.onFailure(getEmptyError("SDK not initialized"));
        }
    }

    /**
     * Get the serialized Error object from response.
     * @param response Retrofit response.
     * @return Returns null if response is a success or null. A valid {@link Error} will be returned if not success and able to convert error body of the response.
     * Otherwise return {@link #getEmptyError(String)}.
     */
    private Error getError(retrofit2.Response response) {
        Error error = null;
        if (response != null && !response.isSuccessful()) {
            if (response.errorBody() != null) {
                error = new Error();
                Converter<ResponseBody, Error> errorConverter = mRetrofit.responseBodyConverter(Error.class, new Annotation[0]);
                try {
                    error = errorConverter.convert(response.errorBody());
                } catch (IOException e) {
                    e.printStackTrace();
                    error.setDetail(e.getMessage());
                }
            } else {
                error = getEmptyError("");
            }
        }
        return error;
    }

    /**
     * Returns an empty {@link Error} with detail set to message.
     * @param message Message to set.
     * @return An {@link Error}
     */
    private Error getEmptyError(String message) {
        Error error = new Error();
        error.setDetail(message);
        return error;
    }
}
