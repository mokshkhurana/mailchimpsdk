# MailchimpSDK
Wrapper for Mailchimp API v3 on android

This library is still under development. Please use at your own risk.

## Installation:

```
maven {
url 'https://dl.bintray.com/mokshkhurana/moksh/'
}

dependencies {
compile 'com.mokshkhurana:mailchimpsdk:1.0.0'
}
```
## Usage

```java
MailchimpSDK sdk = MailchimpSDK.getInstance();
sdk.initSDK("your_api_key");
```

## Current methods

* Get lists
* Get list by ID

## Future Planning
Next release: I will be completing post, patch and delete calls for list. After that I will be working account information.
