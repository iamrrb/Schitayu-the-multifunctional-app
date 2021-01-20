package com.rrbofficial.btrapplock;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class feedback extends AppCompatActivity {

        private WebView feed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        feed =(WebView) findViewById(R.id.feedback_webview);

        WebSettings webSettings =feed.getSettings();
        webSettings.setJavaScriptEnabled(true);

        feed.setWebViewClient(new WebViewClient());
        feed.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSfz5EydijJAe8GE2Ur6zVK_OgNQGH2GhhKCRpgLjWM6fw5_OA/viewform?usp=sf_link");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id =item.getItemId();
                if (id ==android.R.id.home){{
                    this.finish();
                }}
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(feed.canGoBack())
        {
            feed.goBack();
        }
        else
        {
            super.onBackPressed();

        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onStop();
                Intent it = new Intent(feedback.this, home.class);
                startActivity(it);
            }




        });
    }

}
