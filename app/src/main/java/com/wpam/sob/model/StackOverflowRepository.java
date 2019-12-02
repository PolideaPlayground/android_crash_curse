package com.wpam.sob.model;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.wpam.sob.stackoverflow.Issue;
import com.wpam.sob.stackoverflow.StackOverflowAPI;

import java.io.IOException;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StackOverflowRepository {

    StackOverflowAPI stackOverflowApi;

    public StackOverflowRepository() {
        stackOverflowApi = new Retrofit.Builder()
                .baseUrl("http://api.stackexchange.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(StackOverflowAPI.class);
    }

    public List<Issue> search(String query) throws IOException {
        return stackOverflowApi.search(query).execute().body().getItems();
    }
}
