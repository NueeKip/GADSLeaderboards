package com.example.leaderboard;


import com.example.leaderboard.iq.IqService;
import com.example.leaderboard.learner.LearnerService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit getRetrofit() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gadsapi.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit;
    }

    public static IqService getIqService(){
        IqService iqService = getRetrofit().create(IqService.class);

        return iqService;
    }
    public static LearnerService getLearnerService(){
        LearnerService learnerService = getRetrofit().create(LearnerService.class);

        return learnerService;
    }

}