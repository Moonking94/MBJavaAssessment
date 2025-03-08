package com.maybank.assessment.util;

import java.time.LocalDateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.maybank.assessment.config.LocalDateTimeTypeAdapter;

public class GsonUtil {
    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
            .create();

    public static Gson getGson() {
        return gson;
    }
}
