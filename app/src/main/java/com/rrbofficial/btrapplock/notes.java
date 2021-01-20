package com.rrbofficial.btrapplock;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;

public class notes extends AppCompatActivity {


    private FirebaseAuth fAuth ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        fAuth=(FirebaseAuth.getInstance());
        updateUI();


    }

    private void updateUI() {

        if (fAuth.getCurrentUser()!=null) {

            Log.i("NotesActivity", "fAuth :null");
        }
        else{
            Intent StartIntent =new Intent(notes.this,StartActivity.class);
            startActivity(StartIntent);
            finish();
            Log.i("Notes","fAuth!=null");

        }
    }
}

