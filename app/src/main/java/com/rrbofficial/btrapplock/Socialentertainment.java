package com.rrbofficial.btrapplock;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class Socialentertainment extends AppCompatActivity {

    ImageView youtube,allnovel,flipk,amazon,discov,cn,allapk,tutorialpt,wwe,linkd, voot, hotstar,fb,insta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socialentertainment);

        youtube= (ImageView) findViewById(R.id.youtubeimg);
        tutorialpt = (ImageView) findViewById(R.id.tutorialptimg);
        fb= (ImageView) findViewById(R.id.facebookicon);

        insta = (ImageView) findViewById(R.id.instaicon);
        voot = (ImageView) findViewById(R.id.vooticon);
        hotstar = (ImageView) findViewById(R.id.hotstaricon);
        linkd = (ImageView) findViewById(R.id.linkedinicon);
        wwe = (ImageView) findViewById(R.id.wweicon);
        hotstar = (ImageView) findViewById(R.id.hotstaricon);
        allapk = (ImageView) findViewById(R.id.allapk);
        amazon = (ImageView) findViewById(R.id.amazonimg);
        allnovel = (ImageView) findViewById(R.id.allnovel);
        flipk = (ImageView) findViewById(R.id.flipkartimg);
        cn = (ImageView) findViewById(R.id.cartoonimg);
        discov = (ImageView) findViewById(R.id.discoveryicon);

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Socialentertainment.this,facebook.class);
                startActivity(it);
            }
        });


        allapk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Socialentertainment.this,allapk.class);
                startActivity(it);
            }
        });

        linkd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Socialentertainment.this,linkedin.class);
                startActivity(it);
            }
        });


        discov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Socialentertainment.this,discovery.class);
                startActivity(it);
            }
        });


        flipk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Socialentertainment.this,flipcart.class);
                startActivity(it);
            }
        });

        amazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Socialentertainment.this,amazon.class);
                startActivity(it);
            }
        });


        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Socialentertainment.this,Instagram.class);
                startActivity(it);
            }
        });

        cn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Socialentertainment.this,cartoonnetwork.class);
                startActivity(it);
            }
        });

        amazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Socialentertainment.this,amazon.class);
                startActivity(it);
            }
        });
        
        allnovel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Socialentertainment.this,allnovel.class);
                startActivity(it);
            }
        });

        hotstar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Socialentertainment.this,hotstar.class);
                startActivity(it);
            }
        });

        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Socialentertainment.this,youtube.class);
                startActivity(it);
            }
        });

        voot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Socialentertainment.this,voot.class);
                startActivity(it);
            }
        });

    }
}
