package com.videoteca.androidtv.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class APIConfig {

    private static Retrofit retrofit = null;
    private static String   BASE_URL = "";

    static Retrofit getClient() {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

}
