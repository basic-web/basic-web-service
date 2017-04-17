package com.github.ququzone.basicweb.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * gson helper.
 *
 * @author Yang XuePing
 */
public class GsonHelper {
    public static final Gson GSON = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    public static String string(Object o) {
        return GSON.toJson(o);
    }
}
