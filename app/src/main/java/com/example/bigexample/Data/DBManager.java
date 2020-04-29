package com.example.bigexample.Data;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DBManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "BigManager";
    private static final String TABLE_NAME = "Post";
    private static final String ID = "_id";
    private static final String NAME = "name";
    private static final String PRICE = "price";
    private static final String ADDRESS = "address";
    private static final String DESCRIBE = "describe";
    private static int VERSION = 1;

    public static String getID() {
        return ID;
    }

    public static String getNAME() {
        return NAME;
    }

    public static String getPRICE() {
        return PRICE;
    }

    public static String getADDRESS() {
        return ADDRESS;
    }

    public static String getDESCRIBE() {
        return DESCRIBE;
    }

    public SQLiteDatabase myDB;


    public DBManager(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQLQuery = "CREATE TABLE " + TABLE_NAME + " ( " +
                ID + " interger primary key, " +
                NAME + " TEXT not null, " +
                PRICE + " TEXT not null, " +
                ADDRESS + " TEXT not null, " +
                DESCRIBE + " TEXT not null) ";
        db.execSQL(SQLQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void openDB() {
        myDB = getWritableDatabase();
    }

    public void closeDB() {
        if (myDB != null && myDB.isOpen()) {
            myDB.close();
        }
    }

    public long insert(int mID, String mName, String mPrice, String mAddress, String mDescribe) {
        ContentValues values = new ContentValues(); //nơi truyền dữ liệu vào
        values.put(ID, mID);
        values.put(NAME, mName);
        values.put(PRICE, mPrice);
        values.put(ADDRESS, mAddress);
        values.put(DESCRIBE, mDescribe);
        return myDB.insert(TABLE_NAME, null, values);
    }


    public long update(int mID, String mName, String mPrice, String mAddress, String mDescribe) {
        ContentValues values = new ContentValues();
        values.put(ID, mID);
        values.put(NAME, mName);
        values.put(PRICE, mPrice);
        values.put(ADDRESS, mAddress);
        values.put(DESCRIBE, mDescribe);
        String where = ID + " = " + mID;
        return myDB.update(TABLE_NAME, values, where, null);

    }

    public long delete(String id) {
        String where = ID + " = " + id;
        return myDB.delete(TABLE_NAME, where, null);
    }

    public Cursor getAllRecord() {
        String query = "SELECT * FROM " + TABLE_NAME + " order by _id ASC";
        return myDB.rawQuery(query, null);
    }


}



