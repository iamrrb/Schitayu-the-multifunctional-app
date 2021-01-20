package com.rrbofficial.btrapplock;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;


import java.security.Permission;

public class home extends Activity {

    ImageView camera, faculty, phone, notes, youtubeimg, flashlg, gallary, status, gcoeawall, thanks, smsicon,updateline;

    public static final int REQUEST_LOCATION = 10;
    private static final int REQUEST_PERMISSIONS = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        int permission_All = 1;

        String[] Permissions = {Manifest.permission.CAMERA, Manifest.permission.CALL_PHONE,
                Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS,
                Manifest.permission.SEND_SMS, Manifest.permission.MEDIA_CONTENT_CONTROL,
                Manifest.permission.INTERNET
        };

        if (!hasPermissions(this, Permissions)) {

            ActivityCompat.requestPermissions(this, Permissions, permission_All);

        }
        smsicon = (ImageView) findViewById(R.id.smsimg);
       thanks = (ImageView) findViewById(R.id.thanksimg);
        camera = (ImageView) findViewById(R.id.cameraimg);
        faculty = (ImageView) findViewById(R.id.facultyimg);
        phone = (ImageView) findViewById(R.id.phonesimg);
        notes = (ImageView) findViewById(R.id.notesimg);
        flashlg = (ImageView) findViewById(R.id.flashlightimg);
       gallary = (ImageView) findViewById(R.id.gallaryimg);
       gcoeawall = (ImageView) findViewById(R.id.gcoeawallimg);
       status = (ImageView) findViewById(R.id.mydeviceimg);



        flashlg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent it = new Intent(home.this, flashlight.class);
                startActivity(it);
            }
        });

        faculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent it = new Intent(home.this, fact_act.class);
                startActivity(it);
            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(home.this, camera_act.class);
                startActivity(it);

            }
        });


        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(home.this, MainActivity.class);
                startActivity(it);
            }
        });

        gcoeawall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(home.this, gcoea_wall.class);
                startActivity(it);
            }
        });

        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(home.this, mydevice.class);
                startActivity(it);
            }
        });


        smsicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent it = new Intent(home.this, sms.class);
                startActivity(it);
            }
        });


    }

    ;

    private static boolean hasPermissions(Context context, String... permissions)

    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && permissions != null) {
            for (String permission : permissions) {

                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return false;
    }
}




