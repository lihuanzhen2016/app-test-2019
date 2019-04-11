package com.example.app1.contentproviderdemo;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.app1.R;

public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
    }
    public  void readPerson(View v){
        ContentResolver contentResolver = this.getContentResolver();
        String id = null;
        String mimetype = null;
        Cursor cursor = contentResolver.query(android.provider.ContactsContract.Contacts.CONTENT_URI,
                new String[]{ContactsContract.Contacts._ID}, null, null, null);
        while (cursor.moveToNext()) {
            id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            Cursor contactInfoCursor =
                    contentResolver.query(android.provider.ContactsContract.Data.CONTENT_URI,
                    new String[]{ContactsContract.Data.CONTACT_ID,
                            ContactsContract.Data.MIMETYPE,
                            ContactsContract.Data.DATA1,
                            ContactsContract.Data.DATA15},
                    android.provider.ContactsContract.Data.CONTACT_ID + "=" + id, null, null);
            while (contactInfoCursor.moveToNext()) {
                mimetype = contactInfoCursor.getString(contactInfoCursor.getColumnIndex(ContactsContract.Data.MIMETYPE));
                String value = contactInfoCursor.getString(contactInfoCursor.getColumnIndex(ContactsContract.Data.DATA1));
                if (mimetype.contains("/name")) {
                    Log.i("姓名是" , value);

                } else if (mimetype.contains("/im")) {
                    Log.i("QQ是" , value);
                } else if (mimetype.contains("/email")) {
                    Log.i("邮箱是" , value);
                } else if (mimetype.contains("/phone")) {
                    Log.i("电话是" , value);

                }

            }
            contactInfoCursor.close();
        }
        cursor.close();
    }
}
