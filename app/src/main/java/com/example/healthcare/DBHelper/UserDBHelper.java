package com.example.healthcare.DBHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDBHelper extends SQLiteOpenHelper {

    private static final String USERDB = "UserDB";
    private static final int USER_VERSION = 1;
    public static final String TABLE_USER = "Users";
    public static final String USER_ID = "id";
    public static final String USER_NAME = "NAME";
    public static final String USER_AGE = "AGE";
    public static final String USER_GENDER = "GENDER";
    public static final String USER_ADDRESS = "ADDRESS";
    public static final String USER_EMAIL = "EMAIL";
    public static final String USER_CONTACT = "CONTACT";
    public static final String USER_ROLE = "ROLE";
    public static final String USER_USERNAME = "USERNAME";
    public static final String USER_PASSWORD = "PASSWORD";

    public UserDBHelper(Context context) {
        super(context, USERDB,null, USER_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableQuery = "CREATE TABLE " + TABLE_USER + " (" +
                USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                USER_NAME + " TEXT, " + USER_AGE + " INTEGER, "
                + USER_GENDER + " TEXT ,"+ USER_ADDRESS + " TEXT ,"+USER_EMAIL +
                "TEXT ," + USER_CONTACT + "LONG ,"+ USER_ROLE+ "TEXT,"+ USER_USERNAME+"TEXT ,"+
                USER_PASSWORD+"TEXT)";
        sqLiteDatabase.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE if EXISTS " + TABLE_USER);
        onCreate(sqLiteDatabase);
    }
}
