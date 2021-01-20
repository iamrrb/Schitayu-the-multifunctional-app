package com.rrbofficial.btrapplock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.rrbofficial.btrapplock.user_sign.LoginActivity;
import com.rrbofficial.btrapplock.user_sign.RegisterActivity;

public class StartActivity extends AppCompatActivity {


    private Button btnReg,btnLog ;
    private FirebaseAuth fAuth ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btnLog =(Button)findViewById(R.id.start_log_btn);
        btnReg=(Button)findViewById(R.id.start_reg_btn);


        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    private void register() {

        Intent regIntent =new Intent(StartActivity.this, RegisterActivity.class);
        startActivity(regIntent
        );
    }


    private void login() {

        Intent logIntent =new Intent(StartActivity.this, LoginActivity.class);
        startActivity(logIntent);

    }
    private void updateUI(){


        if (fAuth.getCurrentUser()!=null) {

            Log.i("startActivity", "fAuth :null");
        }

        else{
            Intent StartIntent =new Intent(StartActivity.this,StartActivity.class);
            startActivity(StartIntent);
            finish();
            Log.i("startActivity","fAuth!=null");

        }
    }
}
