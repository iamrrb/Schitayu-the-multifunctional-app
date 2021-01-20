package com.rrbofficial.btrapplock;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class error extends AppCompatActivity {

    private Button send;
    private TextView mValueView;
    private Firebase mRef ;
    private static final int GALLARY_INTENT = 2;
    private ProgressDialog mProcessDialog;
    private StorageReference mStorage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);
        Firebase.setAndroidContext(this);
        mValueView = (TextView) findViewById(R.id.hometext);
        send = (Button) findViewById(R.id.sendscreenshot);
        mStorage = FirebaseStorage.getInstance().getReference();
        mProcessDialog = new ProgressDialog(this);
        mRef= new Firebase("https://gcoean-s-schitayu.firebaseio.com/");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value =dataSnapshot.getValue(String.class);
                mValueView.setText(value);
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, GALLARY_INTENT);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLARY_INTENT && resultCode == RESULT_OK) {

            mProcessDialog.setMessage("Sending to developers...");
            mProcessDialog.show();
            Uri uri = data.getData();
            StorageReference filepath = mStorage.child("errorphotos").child(uri.getLastPathSegment());
            filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(error.this, "send successful", Toast.LENGTH_LONG).show();
                    mProcessDialog.dismiss();
                }
            });
        }
    }
}


