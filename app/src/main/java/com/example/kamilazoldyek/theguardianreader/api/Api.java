package com.example.kamilazoldyek.theguardianreader.api;

import com.example.kamilazoldyek.theguardianreader.model.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

import static com.example.kamilazoldyek.theguardianreader.constants.Constants.MAIN_QUERY;

public interface Api {

    @GET(MAIN_QUERY)
    Call<News> getNews();
}
