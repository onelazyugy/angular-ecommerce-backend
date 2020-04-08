package com.vietle.angularecommercebackend.util;

import com.google.common.hash.Hashing;
import com.vietle.angularecommercebackend.Constant;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EcommerceUtil {
    private EcommerceUtil() {}

    public static String getTimestamp() {
        return new Timestamp(new Date().getTime()).toString();
    }
    public static String getJSONFileBasedOnCategory(int category) {
        Map<Integer, String> categoryToJSONFileMap = new HashMap<>();
        categoryToJSONFileMap.put(Constant.BOOK_CATEGORY, Constant.BOOK_JSON);
        categoryToJSONFileMap.put(Constant.CLOTHES_CATEGORY, Constant.CLOTHES_JSON);
        categoryToJSONFileMap.put(Constant.ELECTRONIC_CATEGORY, Constant.ELECTRONIC_JSON);
        categoryToJSONFileMap.put(Constant.HOME_DISCOUNTED_ITEM_CATEGORY, Constant.HOME_DISCOUNTED_ITEM_JSON);
        categoryToJSONFileMap.put(Constant.HOME_NEW_ARRIVAL_ITEM_CATEGORY, Constant.HOME_NEW_ARRIVAL_ITEM_JSON);
        categoryToJSONFileMap.put(Constant.STORE_MOST_VIEWED_ITEM_CATEGORY, Constant.STORE_MOST_VIEWED_ITEM_JSON);
        categoryToJSONFileMap.put(Constant.STORE_RECENTLY_VIEWED_ITEM_CATEGORY, Constant.STORE_RECENTLY_VIEWED_ITEM_JSON);

        return categoryToJSONFileMap.get(category);
    }

    public static String hash(String string) {
        String sha256hexString = Hashing.sha256()
                .hashString(string, StandardCharsets.UTF_8)
                .toString();
        return sha256hexString;
    }
}
