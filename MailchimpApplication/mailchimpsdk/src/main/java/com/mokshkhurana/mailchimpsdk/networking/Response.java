package com.mokshkhurana.mailchimpsdk.networking;

import com.mokshkhurana.mailchimpsdk.model.Error;

public abstract class Response<T> {

    public abstract void onSuccess(T response);
    public abstract void onFailure(Error error);
}