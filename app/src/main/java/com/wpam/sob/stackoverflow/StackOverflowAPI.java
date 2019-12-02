package com.wpam.sob.stackoverflow;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface StackOverflowAPI {
    @GET("/2.2/search?order=desc&sort=activity&site=stackoverflow")
    Call<StackOverflowSearchResponse> search(@Query("tagged") String tagged);
}
