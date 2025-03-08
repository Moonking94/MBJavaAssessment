package com.thirdparty.user.util;

import java.time.LocalDateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thirdparty.user.config.LocalDateTimeTypeAdapter;

public class GsonUtil {
    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
            .create();

    public static Gson getGson() {
        return gson;
    }
}
