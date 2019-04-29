package com.example.kamilazoldyek.theguardianreader.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kamilazoldyek.theguardianreader.R;

import static com.example.kamilazoldyek.theguardianreader.util.Constants.ALL_NEWS;
import static com.example.kamilazoldyek.theguardianreader.util.Constants.WORLD_NEWS;

public class MainActivity extends AppCompatActivity {

    private Button all_button;
    private Button worldNews_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        all_button = findViewById(R.id.button_all);
        worldNews_button = findViewById(R.id.button_world);

        all_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                query_sender(ALL_NEWS);
                }
        });

        worldNews_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                query_sender(WORLD_NEWS);
            }
        });

    }

    public void query_sender(String query){
        Intent intent = new Intent (MainActivity.this, HeadlineListActivity.class);
        intent.putExtra("QUERY", query);
        intent.putExtra("PAGE", 1);
        startActivity(intent);

    }

}
