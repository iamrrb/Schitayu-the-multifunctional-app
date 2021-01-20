package com.rrbofficial.btrapplock.user_sign;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.rrbofficial.btrapplock.R;
import com.rrbofficial.btrapplock.notes;

public class LoginActivity extends AppCompatActivity {


    private TextInputLayout inputEmail,inputPass;
    private Button btnLogIn;
    private FirebaseAuth fAuth ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Firebase.setAndroidContext(this);
        fAuth=FirebaseAuth.getInstance().getInstance();
        inputEmail=(TextInputLayout)findViewById(R.id.input_log_Email);
        inputPass=(TextInputLayout)findViewById(R.id.input_log_pass);
        btnLogIn=(Button)findViewById(R.id.btn_log);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lEmail =inputEmail.getEditText().getText().toString().trim();
                String lPass =inputPass.getEditText().getText().toString().trim();
                if(!TextUtils.isEmpty(lEmail) && !TextUtils.isEmpty(lPass))
                {
                    logIn(lEmail,lPass);
                }
            }
        });
    }
    private  void logIn(String email,String passworrd)
    {

        ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Logging in,please wait..");
        progressDialog.show();
        fAuth.signInWithEmailAndPassword(email,passworrd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                        Intent mainIntent =new Intent(LoginActivity.this, notes.class);
                        startActivity(mainIntent);
                        finish();
                    Toast.makeText(LoginActivity.this,"Sign in successful"+task.getException().getMessage(),Toast.LENGTH_LONG);

                }else {

                    Toast.makeText(LoginActivity.this,"ERROR"+task.getException().getMessage(),Toast.LENGTH_LONG);
                }
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch ((item.getItemId())){

            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}
