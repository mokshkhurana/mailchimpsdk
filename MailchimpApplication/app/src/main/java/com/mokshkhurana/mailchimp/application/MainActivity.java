package com.mokshkhurana.mailchimp.application;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.mokshkhurana.mailchimpsdk.MailchimpSDK;
import com.mokshkhurana.mailchimpsdk.model.Error;
import com.mokshkhurana.mailchimpsdk.model.ListResponse;
import com.mokshkhurana.mailchimpsdk.networking.Response;


public class MainActivity extends AppCompatActivity {

    private MailchimpSDK sdk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sdk = MailchimpSDK.getInstance();
        sdk.initSDK("api_key");

        getLists();
    }

    private void getLists() {
        sdk.getLists(new Response<ListResponse>() {
            @Override
            public void onSuccess(ListResponse response) {
                Log.d("Mailchimp", "Total items = " + response.getTotalItems());
            }

            @Override
            public void onFailure(Error error) {
                Log.d("Mailchimp", "Error = " + error.getDetail());
            }
        });
    }
}
