package com.rrbofficial.btrapplock;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class gcoeasite extends AppCompatActivity {
    private WebView clgsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gcoeasite);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        clgsite = (WebView) findViewById(R.id.gcoeasite_webview);

        WebSettings webSettings = clgsite.getSettings();
        webSettings.setJavaScriptEnabled(true);

        clgsite.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                setTitle("Loading...");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                setTitle(view.getTitle());
            }
        });
        clgsite.loadUrl("https://www.gcoea.ac.in/home");
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
        if (clgsite.canGoBack()) {
            clgsite.goBack();
        } else {

            super.onBackPressed();
        }
    }
}
