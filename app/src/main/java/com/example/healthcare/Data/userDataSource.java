package com.example.healthcare.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.healthcare.DBHelper.UserDBHelper;


public class userDataSource {
    private SQLiteDatabase database;
    private UserDBHelper userdbHelper;

    public userDataSource(Context context) {
        userdbHelper=new UserDBHelper(context);
    }

    public void open(){
        database=userdbHelper.getWritableDatabase();
    }

    public void close(){
        userdbHelper.close();
    }

    public long saveUser(String name, long age, String gender, String address, String email, long contact, String role, String username, String password) {
        ContentValues values = new ContentValues();
        values.put(UserDBHelper.USER_NAME, name);
        values.put(UserDBHelper.USER_AGE, age);
        values.put(UserDBHelper.USER_GENDER, gender);
        values.put(UserDBHelper.USER_ADDRESS, address);
        values.put(UserDBHelper.USER_EMAIL, email);
        values.put(UserDBHelper.USER_CONTACT, contact);
        values.put(UserDBHelper.USER_ROLE, role);
        values.put(UserDBHelper.USER_USERNAME, username);
        values.put(UserDBHelper.USER_PASSWORD, password);
        return database.insert(UserDBHelper.TABLE_USER, null, values);
    }


}
