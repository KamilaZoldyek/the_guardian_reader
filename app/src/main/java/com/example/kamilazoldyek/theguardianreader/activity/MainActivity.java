package com.example.kamilazoldyek.theguardianreader.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kamilazoldyek.theguardianreader.R;

import static com.example.kamilazoldyek.theguardianreader.util.Constants.ALL_NEWS;
import static com.example.kamilazoldyek.theguardianreader.util.Constants.TECH;
import static com.example.kamilazoldyek.theguardianreader.util.Constants.UK_NEWS;
import static com.example.kamilazoldyek.theguardianreader.util.Constants.WORLD_NEWS;

public class MainActivity extends AppCompatActivity {

    private Button all_button;
    private Button worldNews_button;
    private Button uk_button;
    private Button tech_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        all_button = findViewById(R.id.button_all);
        worldNews_button = findViewById(R.id.button_world);
        uk_button = findViewById(R.id.button_uk);
        tech_button = findViewById(R.id.button_technology);


        all_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                query_sender(ALL_NEWS, "All");
                }
        });
        uk_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {query_sender(UK_NEWS, "United Kingdom");
            }
        });
        tech_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { query_sender(TECH, "Technology");}
        });
        worldNews_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {query_sender(WORLD_NEWS, "World");}
        });

    }

    public void query_sender(String query, String section){
        Intent intent = new Intent (MainActivity.this, HeadlineListActivity.class);
        intent.putExtra("QUERY", query);
        intent.putExtra("SECTION", section);
        intent.putExtra("PAGE", 1);
        startActivity(intent);

    }


}
