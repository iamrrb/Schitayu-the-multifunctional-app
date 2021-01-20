package com.rrbofficial.btrapplock;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.sdsmdg.tastytoast.TastyToast;

public class deviceinfo extends AppCompatActivity {
    ImageView getinfo ;
    TextView gettext ;
    String ModelNumber = Build.MODEL;
    String Board =Build.BOARD ;
   String brd =Build.BRAND ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deviceinfo);

        final TextView textView = (TextView)findViewById(R.id.info_display);

        TastyToast.makeText(this,"This information is displayed on the basis of hardware",TastyToast.LENGTH_LONG,TastyToast.DEFAULT);


                textView.setText(
                                "SERIAL NO:" + Build.SERIAL + "\n" +
                                "MODEL:"     + Build.MODEL + "\n" +
                                "YOUR DEVICE ID:"     + Build.ID + "\n" +
                                "YOUR Manufacture:"     + Build.MANUFACTURER + "\n" +
                                "YOUR Brand:"     + Build.BRAND + "\n" +
                                "YOUR Type:"     + Build.TYPE + "\n" +
                                "User:"     + Build.USER + "\n" +
                                "BASE:"     + Build.VERSION_CODES.BASE + "\n" +
                                "INCREMENTAL:"     + Build.VERSION.INCREMENTAL + "\n" +
                                "SDK:"     + Build.VERSION.SDK + "\n" +
                                "BOARD:"     + Build.BOARD + "\n" +
                                "BRAND:"     + Build.BRAND + "\n" +
                                "HOST:"     + Build.HOST + "\n" +
                                "FINGERPRINT:\n"     +Build.FINGERPRINT + "\n" +
                                "Version Code:"     + Build.VERSION.RELEASE
                );
            }

    }
