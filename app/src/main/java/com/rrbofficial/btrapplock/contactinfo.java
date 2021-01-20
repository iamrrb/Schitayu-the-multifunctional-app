package com.rrbofficial.btrapplock;

import android.database.Cursor;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class contactinfo extends AppCompatActivity {
    private static final String TAG = Contacts.class.getSimpleName();
    ListView listView;
    TextView textView;
    Cursor c;
    private  static final int PREMISSION_REQUEST_READ_CONTACTS=100 ;
    ArrayList<String> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactinfo);

        c = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,
                ContactsContract.Contacts.DISPLAY_NAME+"ABC");
        listView=(ListView)findViewById(R.id.idList);
        contacts =new ArrayList<>();
        while (c.moveToNext()){

            String contactName =c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phonenumber =c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            contacts.add("Name :"+contactName+"\n"+"Phone NO :"+phonenumber);
            Log.d(TAG,"ShowContacts"+contacts);
        }
        c.close();

    }

}

