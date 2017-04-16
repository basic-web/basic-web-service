package com.github.ququzone.basicweb;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * gson helper.
 *
 * @author Yang XuePing
 */
public class GsonHelper {
    public static final Gson GSON = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    public static String string(Object o) {
        return GSON.toJson(o);
    }
}
