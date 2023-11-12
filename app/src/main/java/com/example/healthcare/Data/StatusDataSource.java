
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

    public List<Status> getAllStatus() {
        List<Status> statusList = new ArrayList<>();
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_STATUS,
                null,
                null,
                null,
                null,
                null,
                null
        );

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Status status = cursorToStatus(cursor);
            statusList.add(status);
            cursor.moveToNext();
        }

        cursor.close();
        return statusList;
    }

    @SuppressLint("Range")
    private Status cursorToStatus(Cursor cursor) {
        Status status = new Status();
        status.setId(cursor.getLong(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID)));
        status.setStatusText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_STATUS)));
        return status;
    }

    public void deleteAllHealthStatus() {
        database.delete(DatabaseHelper.TABLE_STATUS, null, null);
    }
 
}
