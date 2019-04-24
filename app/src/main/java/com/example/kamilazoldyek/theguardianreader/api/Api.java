package com.example.kamilazoldyek.theguardianreader.api;

import com.example.kamilazoldyek.theguardianreader.model.News;
import com.example.kamilazoldyek.theguardianreader.model.Response;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Url;

import static com.example.kamilazoldyek.theguardianreader.constants.Constants.MAIN_QUERY;

public interface Api {

    @GET
    Call<Response> getNews(@Url String url);
}
