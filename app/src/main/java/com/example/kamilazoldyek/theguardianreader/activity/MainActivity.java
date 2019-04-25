package com.example.kamilazoldyek.theguardianreader.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.kamilazoldyek.theguardianreader.R;
import com.example.kamilazoldyek.theguardianreader.api.Api;
import com.example.kamilazoldyek.theguardianreader.api.ApiClient;
import com.example.kamilazoldyek.theguardianreader.model.News;
import com.example.kamilazoldyek.theguardianreader.model.Response;
import com.example.kamilazoldyek.theguardianreader.model.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

import static com.example.kamilazoldyek.theguardianreader.constants.Constants.API_KEY;
import static com.example.kamilazoldyek.theguardianreader.constants.Constants.MAIN_QUERY;
import static com.example.kamilazoldyek.theguardianreader.constants.Constants.TEST_TAG;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
       // textViewResult = findViewById(R.id.text_view_result);
        //getNews("1");

    }



}
