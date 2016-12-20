package com.mokshkhurana.mailchimpsdk;

import android.util.Log;

import com.mokshkhurana.mailchimpsdk.model.Error;
import com.mokshkhurana.mailchimpsdk.networking.api.ListAPI;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MailchimpSDK {

    private static MailchimpSDK ourInstance = new MailchimpSDK();
    private ListAPI mListAPI;
    private String apiKey;
    private String baseUrl;
    private Retrofit mRetrofit;
    public static Converter<ResponseBody, Error> errorConverter;
    public static final String SDK_NOT_INITIALIZED = "SDK not initialized";

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
    public boolean isSDKInitialized() {
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
        baseUrl = ListAPI.ENDPOINT.replaceAll("<dc>", dc);

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

        errorConverter = mRetrofit.responseBodyConverter(Error.class, new Annotation[0]);

        // Create APIs
        mListAPI = mRetrofit.create(ListAPI.class);
    }

    /**
     * Get the list api
     * @return Returns the list api
     */
    public ListAPI getListAPI() {
        return mListAPI;
    }
}
