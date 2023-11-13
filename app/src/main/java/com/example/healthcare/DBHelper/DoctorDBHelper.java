
package com.example.healthcare.DBHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DoctorDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "DoctorDB";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "doctors";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_AGE = "AGE";
    public static final String COLUMN_GENDER = "GENDER";
    public static final String COLUMN_ADDRESS = "ADDRESS";
    public static final String COLUMN_EMAIL = "EMAIL";
    public static final String COLUMN_CONTACT = "CONTACT";
    public static final String COLUMN_CATEGORY = "CATEGORY";

    public DoctorDBHelper(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " + COLUMN_AGE + " INTEGER, "
                + COLUMN_GENDER + " TEXT ,"+ COLUMN_ADDRESS + " TEXT ,"+COLUMN_EMAIL +
                "TEXT ," + COLUMN_CONTACT + "LONG ,"+ COLUMN_CATEGORY + "TEXT)";
        sqLiteDatabase.execSQL(createTableQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
       sqLiteDatabase.execSQL("DROP TABLE if EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
