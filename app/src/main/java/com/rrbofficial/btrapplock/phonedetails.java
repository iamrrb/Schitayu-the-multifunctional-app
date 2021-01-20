package com.rrbofficial.btrapplock;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class phonedetails extends AppCompatActivity {


    Button btn;
    TextView txtview ;
    String str ;
    String setphonetype ="";
    static final int PERMISSION_READ_STATE=123;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonedetails);
    }

    public void start(View view) {



    }
}
