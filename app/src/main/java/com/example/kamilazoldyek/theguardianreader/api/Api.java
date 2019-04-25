package com.example.kamilazoldyek.theguardianreader.api;

import com.example.kamilazoldyek.theguardianreader.model.News;
import com.example.kamilazoldyek.theguardianreader.model.Response;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

import static com.example.kamilazoldyek.theguardianreader.constants.Constants.API_KEY;
import static com.example.kamilazoldyek.theguardianreader.constants.Constants.MAIN_QUERY;

public interface Api {

    @GET("search")
    Call<News> getNews(
            @Query("page") String page,
            @Query("api-key") String apiKey
    );
}
