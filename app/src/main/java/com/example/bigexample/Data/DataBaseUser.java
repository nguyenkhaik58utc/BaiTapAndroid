package com.example.bigexample.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseUser extends SQLiteOpenHelper {

    private static final String DBName = "AppThueTro.db";
    private static final int VERSION = 1;
    private static final String TABLE_NAME = "User";
    private static final String ID_USER = "_idUser";
    private static final String NAME_USER = "nameUser";
    private static final String YEAROB_USER = "yearobUser";
    private static final String ADDRESS_USER = "addressUser";
    private static final String PHONE_USER = "phoneUser";

    private SQLiteDatabase myDB;

    public DataBaseUser( Context context) {
        super(context, DBName, null, VERSION);
    }

    public static String getIdUser() {
        return ID_USER;
    }

    public static String getNameUser() {
        return NAME_USER;
    }

    public static String getYearobUser() {
        return YEAROB_USER;
    }

    public static String getAddressUser() {
        return ADDRESS_USER;
    }

    public static String getPhoneUser() {
        return PHONE_USER;
    }

    public Cursor Load(String sql){
        openDB();
        return myDB.rawQuery(sql, null);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryTable = "CREATE TABLE " + TABLE_NAME +
                "( " + ID_USER + " INTEGER PRIMARY KEY, " +
                NAME_USER + " TEXT NOT NULL, " +
                ADDRESS_USER + " TEXT NOT NULL, " +
                PHONE_USER + " TEXT NOT NULL, " +
                YEAROB_USER + " INTEGER NOT NULL" + ")";
        db.execSQL(queryTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void openDB(){
        myDB = getWritableDatabase();
    }
    public void closeDB(){
        if(myDB != null && myDB.isOpen()){
            myDB.close();
        }
    }

    public long Insert(int id, String name, int yearob, String address, String phone){
        ContentValues values = new ContentValues();
        values.put(ID_USER, id);
        values.put(NAME_USER, name);
        values.put(ADDRESS_USER, address);
        values.put(PHONE_USER, phone);
        values.put(YEAROB_USER, yearob);
        return myDB.insert(TABLE_NAME, null, values);
    }
    public long Update(int id, String name, int yearob, String address, String phone){
        ContentValues values = new ContentValues();
        values.put(NAME_USER, name);
        values.put(ADDRESS_USER, address);
        values.put(PHONE_USER, phone);
        values.put(YEAROB_USER, yearob);
        String where = ID_USER + " = " + id;
        return myDB.update(TABLE_NAME, values, where, null);
    }
    public long Delete(int id){
        ContentValues values = new ContentValues();
        values.put(ID_USER, id);
        String where = ID_USER + " = " + id;
        return myDB.delete(TABLE_NAME, where, null);
    }
    public Cursor ALLRecord(){
        String query = "SELECT * FROM " + TABLE_NAME + " Where " + ID_USER + " = 2" ;
        return myDB.rawQuery(query, null);
    }

}
