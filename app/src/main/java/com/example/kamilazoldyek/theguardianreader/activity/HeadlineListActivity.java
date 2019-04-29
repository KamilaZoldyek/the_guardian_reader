package com.example.kamilazoldyek.theguardianreader.activity;

import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.kamilazoldyek.theguardianreader.R;
import com.example.kamilazoldyek.theguardianreader.adapter.RecyclerAdapter;
import com.example.kamilazoldyek.theguardianreader.api.ApiClient;
import com.example.kamilazoldyek.theguardianreader.model.News;
import com.example.kamilazoldyek.theguardianreader.model.Result;
import com.example.kamilazoldyek.theguardianreader.util.LocalData;

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
    private ImageView previousImageView;
    private ImageView nextImageView;
    private TextView pageTV;
    private NestedScrollView scrollView;
    private LinearLayoutManager linearLayoutManager;
    private ProgressBar progressBar;
    private LocalData localData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.headlines_activity);

        final String search_query = getIntent().getStringExtra("QUERY");
        final int page_number = getIntent().getIntExtra("PAGE", 1);


        recyclerView = findViewById(R.id.recyclerView);
        nextImageView = findViewById(R.id.next_imageView);
        scrollView = findViewById(R.id.scrollView);
        previousImageView = findViewById(R.id.previous_imageView);
        progressBar = findViewById(R.id.progressBar);
        pageTV = findViewById(R.id.pageTV);

        localData = new LocalData(HeadlineListActivity.this);
        localData.setCurrentPage(page_number);

        resultList = new ArrayList<>();
        linearLayoutManager = new LinearLayoutManager(HeadlineListActivity.this);

        progressBar.setVisibility(View.GONE);

        if (localData.getCurrentPage() == 1) {
            previousImageView.setVisibility(View.GONE);
            pageTV.setText("Page " + page_number);
        }else{
            previousImageView.setVisibility(View.VISIBLE);
        }


        nextImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int next = localData.getCurrentPage() + 1;
                getNews(search_query, String.valueOf(next));
                pageTV.setText("Page " + next);
                localData.setCurrentPage(next);
                previousImageView.setVisibility(View.VISIBLE);
                scrollView.setScrollY(0);

            }
        });

        previousImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int prev = localData.getCurrentPage() - 1;
                if (prev < 1) {
                    getNews(search_query, "1");
                    pageTV.setText("Page " + 1);
                    localData.setCurrentPage(1);
                    scrollView.setScrollY(0);
                    previousImageView.setVisibility(View.GONE);
                } else {
                    getNews(search_query, String.valueOf(prev));
                    pageTV.setText("Page " + prev);
                    localData.setCurrentPage(prev);
                    scrollView.setScrollY(0);
                }

            }
        });


        getNews(search_query, String.valueOf(page_number));
    }

    public void setupRecyclerView(List<Result> resultList) {
        recyclerAdapter = new RecyclerAdapter(resultList, HeadlineListActivity.this);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(recyclerAdapter);

    }

    public void getNews(String searchQuery, String currentPage) {

        progressBar.setVisibility(View.VISIBLE);

        Call<News> call2 = ApiClient.getInstance().getApi().getNews(searchQuery, currentPage, API_KEY);
        call2.enqueue(new Callback<News>() {
            List<Result> list_news = new ArrayList<>();

            @Override
            public void onResponse(Call<News> call, retrofit2.Response<News> response) {
                if (!response.isSuccessful()) {
                    Log.i(TEST_TAG, "Code: " + response.code());
                    if (response.code() == 401) {
                        Log.i(TEST_TAG, "Code 401: Unauthorized \n\n");
                    }
                    return;
                }

                list_news = response.body().getResponse().getResults();
                String page = response.body().response.currentPage.toString();
                progressBar.setVisibility(View.GONE);


                for (Result news : list_news) {
                    String content = "\n\n";
                    content += "Page: " + page + "\n";
                    content += "Title: " + news.getWebTitle() + "\n";
                    content += "Section: " + news.getSectionName() + "\n";
                    Log.i(TEST_TAG, content);
                }

                setupRecyclerView(list_news);
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Log.i(TEST_TAG, t.getMessage());

            }
        });


    }


}
