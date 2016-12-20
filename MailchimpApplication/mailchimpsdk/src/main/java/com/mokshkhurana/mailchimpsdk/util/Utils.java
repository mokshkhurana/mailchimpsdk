package com.mokshkhurana.mailchimpsdk.util;

import com.mokshkhurana.mailchimpsdk.MailchimpSDK;
import com.mokshkhurana.mailchimpsdk.model.Error;

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
     * Get the serialized Error object from response.
     * @param response Retrofit response.
     * @return Returns null if response is a success or null. A valid {@link Error} will be returned if not success and able to convert error body of the response.
     * Otherwise return {@link #getEmptyError(String)}.
     */
    public static Error getError(retrofit2.Response response) {
        Error error = null;
        if (response != null && !response.isSuccessful()) {
            if (response.errorBody() != null && MailchimpSDK.errorConverter != null) {
                error = new Error();
                try {
                    error = MailchimpSDK.errorConverter.convert(response.errorBody());
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
    public static Error getEmptyError(String message) {
        Error error = new Error();
        error.setDetail(message);
        return error;
    }
}
