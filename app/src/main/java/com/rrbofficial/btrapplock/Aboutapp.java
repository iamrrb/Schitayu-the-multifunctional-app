package com.rrbofficial.btrapplock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class Aboutapp extends AppCompatActivity {

    TextView txtteaser ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Element adsElement =new Element();
        adsElement.setTitle("Advertise here");

        View aboutPage =new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.schitayulogopng)
                .setDescription("This is my description")
                .addItem(new Element().setTitle("version 1.5"))
                .addItem(adsElement)
                .addGroup("connect with us")
                .addEmail("rohit15005026@gmail.com")
                .addWebsite("http:/rrbofficial.com")
                .addFacebook("rohit")
                .addTwitter("my twiteer")
                .addYoutube("youtube")
                .addPlayStore("playsore")
                .addInstagram("rohit")
                .addGitHub("rohit")
                .addItem(createCopyright())
                .create();
        setContentView(aboutPage);

    }

    private Element createCopyright() {

        Element copyright =new Element();
       final String copyrightstring =String.format("Copyright id by Schitayu Gcoea", Calendar.getInstance().get(Calendar.YEAR));
         copyright.setTitle(copyrightstring);
        copyright.setIcon(R.drawable.appicon);
        copyright.setGravity(Gravity.CENTER);
        copyright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Aboutapp.this,copyrightstring,Toast.LENGTH_LONG).show();
            }
        });
        return copyright;
    }

}

