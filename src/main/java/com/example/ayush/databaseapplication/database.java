package com.example.ayush.databaseapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ayush on 10/5/2017.
 */

public class database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "myDatabase";
    private static final String TABLE_NAME = "employeeInfo";
    private static final String KEY_ID = "id";
    private static final String KEY_FIRST_NAME = "firstName";
    private static final String KEY_LAST_NAME = "surname";

    public database(MainActivity context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String newTable = "CREATE TABLE " + TABLE_NAME +"(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_FIRST_NAME + " TEXT, " + KEY_LAST_NAME +
                " TEXT" + ")";
        db.execSQL(newTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insert_Data(String first_name, String surname)
    {
        //to write data into the table
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_FIRST_NAME,first_name);
        values.put(KEY_LAST_NAME, surname);
        long res=db.insert(TABLE_NAME,null,values);
        if(res==-1)
        {
            return  false;
            //if data is not inserted return false
        }
        else
        {
            return  true;
            //else return true
        }
    }

    public Cursor showProduct() {
        //fetching data
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from employeeInfo", null);
        if (cursor != null)
            return cursor;
        else
            return null;
    }
}
