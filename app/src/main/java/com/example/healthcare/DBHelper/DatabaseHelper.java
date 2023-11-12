package com.example.healthcare.Data;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.healthcare.DBHelper.DatabaseHelper;
import com.example.healthcare.Tables.Status;

import java.util.ArrayList;
import java.util.List;

public class StatusDataSource {
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public StatusDataSource(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long saveStatus(String statusText) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_STATUS, statusText);
        return database.insert(DatabaseHelper.TABLE_STATUS, null, values);
    }

  
}
