package com.example.kamilazoldyek.theguardianreader.activity;

import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import com.example.kamilazoldyek.theguardianreader.R;
import com.example.kamilazoldyek.theguardianreader.adapter.RecyclerAdapter;
import com.example.kamilazoldyek.theguardianreader.api.ApiClient;
import com.example.kamilazoldyek.theguardianreader.model.News;
import com.example.kamilazoldyek.theguardianreader.model.Result;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

import static com.example.kamilazoldyek.theguardianreader.util.Constants.API_KEY;
import static com.example.kamilazoldyek.theguardianreader.util.Constants.TEST_TAG;

public class HeadlineListActivity extends AppCompatActivity {

    public RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private List<Result> resultList;
    private LinearLayout nextButton;
    private NestedScrollView scrollView;
    private LinearLayoutManager linearLayoutManager;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.headlines_activity);

        final String search_query = getIntent().getStringExtra("QUERY");
        int page_number = getIntent().getIntExtra("PAGE", 1);
        final int next_page = page_number++;


        recyclerView = findViewById(R.id.recyclerView);
        nextButton = findViewById(R.id.next);
        resultList = new ArrayList<>();
        scrollView = findViewById(R.id.scrollView);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        linearLayoutManager = new LinearLayoutManager(HeadlineListActivity.this);


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              getNews(search_query, String.valueOf(next_page));
              scrollView.setScrollY(0);

            }
        });

        getNews(search_query, String.valueOf(page_number));
    }

    public void setupRecyclerView(List<Result> resultList){
        recyclerAdapter = new RecyclerAdapter(resultList, HeadlineListActivity.this);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(recyclerAdapter);

    }

    public void getNews(String query, String page_number){

        progressBar.setVisibility(View.VISIBLE);

        Call<News> call2 = ApiClient.getInstance().getApi().getNews(query, page_number, API_KEY);
        call2.enqueue(new Callback<News>() {
            List<Result> list_news = new ArrayList<>();
            @Override
            public void onResponse(Call<News> call, retrofit2.Response<News> response) {
                if(!response.isSuccessful()){
                    Log.i(TEST_TAG, "Code: "+ response.code());
                    if (response.code()==401) {
                        Log.i(TEST_TAG,"Code 401: Unauthorized \n\n" );
                    }
                    return;
                }
                list_news = response.body().getResponse().getResults();
                progressBar.setVisibility(View.GONE);
                setupRecyclerView(list_news);

//
//                for (Result news : list_news){
//                    String content = "";
//                    content += "Title: " + news.getWebTitle() + "\n";
//                    content += "Section: " + news.getSectionName() + "\n";
//                    content += "Date: " + news.getWebPublicationDate() + "\n\n";
//                    Log.i(TEST_TAG,"Successful: " + content );
//                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Log.i(TEST_TAG, t.getMessage());

            }
        });



    }


}
