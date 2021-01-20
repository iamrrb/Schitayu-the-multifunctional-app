package com.rrbofficial.btrapplock;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class flipcart extends AppCompatActivity {
    private WebView fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flipcart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fb = (WebView) findViewById(R.id.flipkart_webview); //https://www.flipkart.com/?gclid=CjwKCAjwxILdBRBqEiwAHL2R80VJDTt_xr8Bx9W2R8RjPS_Rm-iCOQOiwpyLckuKT1MxoztoYlDbLxoCGQMQAvD_BwE&semcmpid=sem_8024046704_brand_eta_goog&s_kwcid=AL!739!3!260681129911!p!!g!!flipckart&ef_id=W3ZOzwAABCdQCwfd:20180918222142:s

        WebSettings webSettings = fb.getSettings();
        webSettings.setJavaScriptEnabled(true);

        fb.setWebViewClient(new WebViewClient(){
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
        fb.loadUrl("https://www.flipkart.com/");
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
        if (fb.canGoBack()) {
            fb.goBack();
        } else {

            super.onBackPressed();
        }
    }
}
