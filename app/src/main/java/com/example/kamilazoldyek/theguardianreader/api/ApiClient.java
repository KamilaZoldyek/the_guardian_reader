package com.example.kamilazoldyek.theguardianreader.api;

import retrofit2.Retrofit;
import okhttp3.OkHttpClient;
import retrofit2.converter.gson.GsonConverterFactory;


import static com.example.kamilazoldyek.theguardianreader.util.Constants.BASE_URL;

public class ApiClient {

   private static ApiClient mInstance;
   private Retrofit retrofit;

   private ApiClient(){
       retrofit = new Retrofit.Builder()
               .baseUrl(BASE_URL)
               .client(new OkHttpClient())
               .addConverterFactory(GsonConverterFactory.create())
               .build();
   }

   public static synchronized ApiClient getInstance(){
       if (mInstance == null){
           mInstance = new ApiClient();
       }
       return mInstance;
   }

   public Api getApi(){ return retrofit.create(Api.class);}

}
