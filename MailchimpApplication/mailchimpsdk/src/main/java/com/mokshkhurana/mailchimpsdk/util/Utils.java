package com.mokshkhurana.mailchimpsdk.util;

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
}
