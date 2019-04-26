package com.example.kamilazoldyek.theguardianreader.api;

import com.example.kamilazoldyek.theguardianreader.model.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface Api {

    @GET
    Call<News> getNews(
            @Url String url,
            @Query("page") String page,
            @Query("api-key") String apiKey
    );
}
