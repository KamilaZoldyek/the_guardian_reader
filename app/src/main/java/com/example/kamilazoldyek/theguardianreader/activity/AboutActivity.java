package com.example.kamilazoldyek.theguardianreader.activity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.kamilazoldyek.theguardianreader.R;

public class AboutActivity extends AppCompatActivity {

    private LinearLayout linkedin, github, email;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_about);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        context = AboutActivity.this;

        linkedin = findViewById(R.id.linkedin);
        github = findViewById(R.id.github);
        email = findViewById(R.id.email);

        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = context.getResources().getColor(R.color.colorPrimaryDark);

                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();

                builder.setStartAnimations(context, R.anim.fade_in_left, R.anim.fade_out_left);
                builder.setExitAnimations(context, R.anim.fade_in_right, R.anim.fade_out_right);
                builder.setToolbarColor(color);
                builder.setShowTitle(true);

                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(context, Uri.parse("http://linkedin.com/in/kamilaz"));
            }
        });

        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = context.getResources().getColor(R.color.colorPrimaryDark);

                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();

                builder.setStartAnimations(context, R.anim.fade_in_left, R.anim.fade_out_left);
                builder.setExitAnimations(context, R.anim.fade_in_right, R.anim.fade_out_right);
                builder.setToolbarColor(color);
                builder.setShowTitle(true);

                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(context, Uri.parse("http://github.com/KamilaZoldyek"));
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = "mailto:camila_c_araujo@outlook.com";
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse(mail));
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(context, "No email app found!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(AboutActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        Intent intent = new Intent(AboutActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
        return true;
    }
}
