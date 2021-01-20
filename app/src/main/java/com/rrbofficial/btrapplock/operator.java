package com.rrbofficial.btrapplock;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.sdsmdg.tastytoast.TastyToast;

public class operator extends AppCompatActivity {


        ImageView img1 ;
        TextView optxt ;
        TelephonyManager td ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operator);
        optxt = (TextView) findViewById(R.id.operatortxt);
        TastyToast.makeText(this,"This information is displayed on the basis of hardware",TastyToast.LENGTH_LONG,TastyToast.DEFAULT);
        td = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        optxt.setText("Mobile Operator Code :" + td.getSimOperator().toString() + "\nSIM Operator Name :" +
                td.getSimOperatorName().toString() +
                "\nCountry ISO :" + td.getSimCountryIso().toString()
                );
    }
    }
