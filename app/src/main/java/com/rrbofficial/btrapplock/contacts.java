package com.rrbofficial.btrapplock;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.Menu;
import android.widget.TextView;

public class contacts extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{
    TextView textView = null;
    String DISPLAY_NAME = ContactsContract.Contacts.DISPLAY_NAME;
    String NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        textView = (TextView) findViewById(R.id.out);
        getSupportLoaderManager().initLoader(1, null,contacts.this);
    }
    public Loader<Cursor> onCreateLoader(int arg0, Bundle arg1) {
        Uri CONTENT_URI = Phone.CONTENT_URI;
        return new CursorLoader(this, CONTENT_URI, null,null, null, null);
    }
    public void onLoadFinished(Loader<Cursor> arg0, Cursor cursor) {
        StringBuilder sb = new StringBuilder();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            sb.append("\n" + cursor.getString(cursor.getColumnIndex(DISPLAY_NAME)));
            sb.append(":" + cursor.getString(cursor.getColumnIndex(NUMBER)));
            cursor.moveToNext();
        }
        textView.setText(sb);
    }
    public void onLoaderReset(Loader<Cursor> loader) {
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    }


