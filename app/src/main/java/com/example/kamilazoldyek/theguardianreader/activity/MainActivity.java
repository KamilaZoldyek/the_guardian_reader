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

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

import static com.example.kamilazoldyek.theguardianreader.constants.Constants.MAIN_QUERY;
import static com.example.kamilazoldyek.theguardianreader.constants.Constants.TEST_TAG;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    private Api api;
    public ApiClient apiClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);
        textViewResult = findViewById(R.id.text_view_result);
        apiClient.getApi();
        getNews();

    }

    private void getNews(){
        Call<Response> call = apiClient.getInstance().getApi().getNews(MAIN_QUERY);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                Log.i(TEST_TAG,response.message() );
                if(!response.isSuccessful()){
                    textViewResult.setText("Code: "+ response.code());
                    return;
                }
                List<Result> list_news = response.body().results;

                for (Result news : list_news){
                    String content = "";
                    content += "Title: " + news.getWebTitle() + "\n";
                    content += "Section: " + news.getSectionName() + "\n";
                    content += "Date: " + news.getWebPublicationDate() + "\n";
                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });

    }


}
