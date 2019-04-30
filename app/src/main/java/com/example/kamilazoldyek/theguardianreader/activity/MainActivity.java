package com.example.kamilazoldyek.theguardianreader.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;

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
    private LinearLayout app_title;
    private ImageView arrowLeft;
    private ImageView arrowRight;
    private TableLayout table1;
    private TableLayout table2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        all_button = findViewById(R.id.button_all);
        worldNews_button = findViewById(R.id.button_world);
        uk_button = findViewById(R.id.button_uk);
        tech_button = findViewById(R.id.button_technology);
        app_title = findViewById(R.id.app_title);
        arrowLeft = findViewById(R.id.arrowLeftIV);
        arrowRight = findViewById(R.id.arrowRightIV);
        table1 = findViewById(R.id.table1);
        table2 = findViewById(R.id.table2);

        app_title.setAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_transition));
        arrowRight.setAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.arrow_anim_right));
        arrowLeft.setAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.arrow_anim_left));
        table2.setVisibility(View.GONE);


        all_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                query_sender(ALL_NEWS, "All");
            }
        });
        uk_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                query_sender(UK_NEWS, "United Kingdom");
            }
        });
        tech_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                query_sender(TECH, "Technology");
            }
        });
        worldNews_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                query_sender(WORLD_NEWS, "World");
            }
        });
        arrowRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (table1.getVisibility() == View.VISIBLE) {
                    table1.setAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_out_right));
                    table1.setVisibility(View.GONE);
                    table2.setAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in_right));
                    table2.setVisibility(View.VISIBLE);
                } else if (table2.getVisibility() == View.VISIBLE) {
                    table2.setAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_out_right));
                    table2.setVisibility(View.GONE);
                    table1.setAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in_right));
                    table1.setVisibility(View.VISIBLE);
                }
            }
        });
        arrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (table1.getVisibility() == View.VISIBLE) {
                    table1.setAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_out_left));
                    table1.setVisibility(View.GONE);
                    table2.setAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in_left));
                    table2.setVisibility(View.VISIBLE);
                } else if (table2.getVisibility() == View.VISIBLE) {
                    table2.setAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_out_left));
                    table2.setVisibility(View.GONE);
                    table1.setAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in_left));
                    table1.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    public void query_sender(String query, String section) {
        Intent intent = new Intent(MainActivity.this, HeadlineListActivity.class);
        intent.putExtra("QUERY", query);
        intent.putExtra("SECTION", section);
        intent.putExtra("PAGE", 1);
        startActivity(intent);

    }

    @Override
    protected void onResume() {
        super.onResume();
        app_title.setAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_transition));

    }
}
