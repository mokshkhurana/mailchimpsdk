package com.mokshkhurana.mailchimpsdk.networking.response;

import com.mokshkhurana.mailchimpsdk.model.ServiceError;

public abstract class Response<T> {

    public abstract void onSuccess(T response);
    public abstract void onFailure(ServiceError serviceError);
}
