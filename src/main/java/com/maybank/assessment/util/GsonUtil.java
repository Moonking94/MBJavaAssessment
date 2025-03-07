package com.maybank.assessment.util;

import java.time.Instant;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.maybank.assessment.config.InstantTypeAdapter;

public class GsonUtil {
    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(Instant.class, new InstantTypeAdapter())
            .create();

    public static Gson getGson() {
        return gson;
    }
}
