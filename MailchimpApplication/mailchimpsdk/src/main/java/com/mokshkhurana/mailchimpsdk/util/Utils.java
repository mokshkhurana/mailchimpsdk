package com.mokshkhurana.mailchimpsdk.util;

import com.mokshkhurana.mailchimpsdk.MailchimpSDK;
import com.mokshkhurana.mailchimpsdk.model.ServiceError;

import java.io.IOException;
import java.util.List;

public class Utils {

    /**
     * Returns a comma separated string from list.
     * @param list A list of type string.
     * @return Returns null if list is null or size == 0. Otherwise return comma separated string.
     */
    public static String getCommaSeparatedString(List<String> list) {
        String result = null;
        if (list != null && list.size() > 0) {
            result = list.get(0);
            for (int index = 1; index < list.size(); index++) {
                result = result + "," + list.get(index);
            }
        }
        return result;
    }

    /**
     * Get the serialized ServiceError object from response.
     * @param response Retrofit response.
     * @return Returns null if response is a success or null. A valid {@link ServiceError} will be returned if not success and able to convert error body of the response.
     * Otherwise return {@link #getEmptyError(String)}.
     */
    public static ServiceError getError(retrofit2.Response response) {
        ServiceError serviceError = null;
        if (response != null && !response.isSuccessful()) {
            if (response.errorBody() != null && MailchimpSDK.errorConverter != null) {
                serviceError = new ServiceError();
                try {
                    serviceError = MailchimpSDK.errorConverter.convert(response.errorBody());
                } catch (IOException e) {
                    e.printStackTrace();
                    serviceError.setDetail(e.getMessage());
                }
            } else {
                serviceError = getEmptyError("");
            }
        }
        return serviceError;
    }

    /**
     * Returns an empty {@link ServiceError} with detail set to message.
     * @param message Message to set.
     * @return An {@link ServiceError}
     */
    public static ServiceError getEmptyError(String message) {
        ServiceError serviceError = new ServiceError();
        serviceError.setDetail(message);
        return serviceError;
    }
}
