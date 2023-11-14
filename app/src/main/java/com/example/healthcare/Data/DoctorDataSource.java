package com.example.healthcare.Data;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.healthcare.DBHelper.DoctorDBHelper;
import com.example.healthcare.Tables.Doctors;

import java.util.ArrayList;
import java.util.List;

public class DoctorDataSource {
    private SQLiteDatabase database;
    private DoctorDBHelper dbHelper;

    public DoctorDataSource(Context context) {
        dbHelper = new DoctorDBHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long saveDoctor(String name, long age, String gender, String address, String email, long contact, String category) {
        ContentValues values = new ContentValues();
        values.put(DoctorDBHelper.COLUMN_NAME, name);
        values.put(DoctorDBHelper.COLUMN_AGE, age);
        values.put(DoctorDBHelper.COLUMN_GENDER, gender);
        values.put(DoctorDBHelper.COLUMN_ADDRESS, address);
        values.put(DoctorDBHelper.COLUMN_EMAIL, email);
        values.put(DoctorDBHelper.COLUMN_CONTACT, contact);
        values.put(DoctorDBHelper.COLUMN_CATEGORY, category);
        return database.insert(DoctorDBHelper.TABLE_NAME, null, values);
    }

    public List<Doctors> getAlldoctors() {
        List<Doctors> doctorsList = new ArrayList<>();
        Cursor cursor = database.query(
                DoctorDBHelper.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Doctors doctor = cursorToDoctor(cursor);
            doctorsList.add(doctor);
            cursor.moveToNext();
        }

        cursor.close();
        return doctorsList;
    }

    @SuppressLint("Range")
    private Doctors cursorToDoctor(Cursor cursor) {
        Doctors doctor = new Doctors();
        doctor.setId(cursor.getInt(cursor.getColumnIndex(DoctorDBHelper.COLUMN_ID)));
        doctor.setName(cursor.getString(cursor.getColumnIndex(DoctorDBHelper.COLUMN_NAME)));
        doctor.setAge(cursor.getLong(cursor.getColumnIndex(DoctorDBHelper.COLUMN_AGE)));
        doctor.setGender(cursor.getString(cursor.getColumnIndex(DoctorDBHelper.COLUMN_GENDER)));
        doctor.setAddress(cursor.getString(cursor.getColumnIndex(DoctorDBHelper.COLUMN_ADDRESS)));
        doctor.setEmail(cursor.getString(cursor.getColumnIndex(DoctorDBHelper.COLUMN_EMAIL)));
        doctor.setContact(cursor.getLong(cursor.getColumnIndex(DoctorDBHelper.COLUMN_CONTACT)));
        doctor.setCategory(cursor.getString(cursor.getColumnIndex(DoctorDBHelper.COLUMN_CATEGORY)));
        return doctor;
    }
}
