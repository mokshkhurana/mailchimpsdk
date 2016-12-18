package com.mokshkhurana.mailchimp.application;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mokshkhurana.mailchimpsdk.MailchimpSDK;


public class MainActivity extends AppCompatActivity {

    private MailchimpSDK sdk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sdk = MailchimpSDK.getInstance();
        sdk.initSDK("api_key");
    }
}
