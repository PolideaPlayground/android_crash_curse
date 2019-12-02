package com.wpam.sob.model;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.wpam.sob.stackoverflow.Issue;
import com.wpam.sob.stackoverflow.StackOverflowAPI;
import com.wpam.sob.stackoverflow.StackOverflowSearchResponse;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StackOverflowRepository {

    StackOverflowAPI stackOverflowApi;

    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//	interceptor.(HttpLoggingInterceptor.Level.BODY);
//	client.interceptors().add(interceptor);
//
//    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//    interceptor.leve(HttpLoggingInterceptor.Level.BODY);
//    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


    public StackOverflowRepository() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        stackOverflowApi = new Retrofit.Builder()
                .baseUrl("https://api.stackexchange.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(StackOverflowAPI.class);
    }

    public void search(String query, Callback<StackOverflowSearchResponse> callback) {
        Log.d("StackOverflowRepository", "Search");
        stackOverflowApi.search(query).enqueue(callback);
    }
}
