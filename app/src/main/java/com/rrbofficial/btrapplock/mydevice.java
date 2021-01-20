package com.rrbofficial.btrapplock;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.sdsmdg.tastytoast.TastyToast;

public class mydevice extends AppCompatActivity {


    ImageView youtube,silent ,vibration,tutorialpt ,general ,bon, boff, woff,won,crickbuzz ,fb,operatorinfo ,deviceinfo,deviceid,battry,insta,googlemap ;
    private BluetoothAdapter BA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydevice);
        final AudioManager audioManager=(AudioManager) getSystemService(getApplicationContext().AUDIO_SERVICE);
        won =(ImageView)findViewById(R.id.wifionimg);
        woff =(ImageView)findViewById(R.id.wifioffimg);
        vibration = (ImageView) findViewById(R.id.vibrateimg);
        deviceid = (ImageView) findViewById(R.id.deviceinfoimg);
        deviceinfo = (ImageView) findViewById(R.id.deviceinfoimg);
        silent = (ImageView) findViewById(R.id.silentimg);
        general = (ImageView) findViewById(R.id.generalimg);
        operatorinfo = (ImageView) findViewById(R.id.operatorimg);
        googlemap=(ImageView)findViewById(R.id.locationimg);
        googlemap=(ImageView)findViewById(R.id.locationimg);
        bon=(ImageView)findViewById(R.id.bluetoothonimg);
        boff =(ImageView)findViewById(R.id.bluetoothoffimg);
        BA = BluetoothAdapter.getDefaultAdapter();
        final WifiManager wifiManager =(WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        googlemap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mydevice.this,"Make Sure That Your Google Play Service is Updated",Toast.LENGTH_SHORT).show();
                Intent it = new Intent(mydevice.this, mapactivty.class);
                startActivity(it);
            }
        });


        silent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                TastyToast.makeText(mydevice.this,"Silent Mode Active",TastyToast.LENGTH_LONG,TastyToast.DEFAULT);

            }
        });



        bon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!BA.isEnabled()) {
                    Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(turnOn, 0);
                    TastyToast.makeText(mydevice.this,"Bluetooth is on",TastyToast.LENGTH_LONG,TastyToast.DEFAULT);
                } else {
                    TastyToast.makeText(mydevice.this,"Bluetooth is already on",TastyToast.LENGTH_LONG,TastyToast.DEFAULT);
                }

            }
        });

        won.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!wifiManager.isWifiEnabled()) {
                    wifiManager.setWifiEnabled(true);
                    TastyToast.makeText(mydevice.this,"wifi is on",TastyToast.LENGTH_LONG,TastyToast.DEFAULT);
                }


            }
        });

        woff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wifiManager.isWifiEnabled()) {
                    wifiManager.setWifiEnabled(false);
                    TastyToast.makeText(mydevice.this,"wifi is off",TastyToast.LENGTH_LONG,TastyToast.DEFAULT);
                }


            }
        });


        boff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent it =new Intent(mydevice.this,batterystatus.class);
            startActivity(it);
            }
        });

        vibration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                TastyToast.makeText(mydevice.this,"Vibration Mode Active",TastyToast.LENGTH_LONG,TastyToast.DEFAULT);
            }
        });

        general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                TastyToast.makeText(mydevice.this,"General Mode Active",TastyToast.LENGTH_LONG,TastyToast.DEFAULT);
            }
        });



        operatorinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(mydevice.this, operator.class);
                startActivity(it);
            }
        });



        deviceinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(mydevice.this, deviceinfo.class);
                startActivity(it);
            }
        });



    }
}
