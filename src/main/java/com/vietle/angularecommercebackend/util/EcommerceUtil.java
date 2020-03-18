package com.vietle.angularecommercebackend.util;

import java.sql.Timestamp;
import java.util.Date;

public class EcommerceUtil {
    private EcommerceUtil() {}

    public static String getTimestamp() {
        return new Timestamp(new Date().getTime()).toString();
    }
}
