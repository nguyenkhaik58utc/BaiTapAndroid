package com.example.bigexample.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseUser extends SQLiteOpenHelper {

    private static final String DBName = "AppThueTro.db";
    private static final int VERSION = 1;
    private static final String TABLE_NAME = "Account";
    private static final String ID_USER = "_id";
    private static final String NAME_USER = "nameUser";
    private static final String NAME_ACCOUNTS = "nameAccounts";
    private static final String PWACCOUNTS = "passWord";
    private static final String YEAROB_USER = "yearobUser";
    private static final String ADDRESS_USER = "addressUser";
    private static final String PHONE_USER = "phoneUser";
    private static final String IMAGEAVATAR_USER = "imageAvatarUser";
    private static final String IMAGEBACKGROUND_USER = "imageBackGroundUser";

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

    public static String getImageavatarUser() {
        return IMAGEAVATAR_USER;
    }

    public static String getImagebackgroundUser() {
        return IMAGEBACKGROUND_USER;
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
                YEAROB_USER + " TEXT NOT NULL, " +
                IMAGEAVATAR_USER + " TEXT NOT NULL, " +
                IMAGEBACKGROUND_USER + " TEXT NOT NULL, " +
                NAME_ACCOUNTS + " TEXT NOT NULL, " +
                PWACCOUNTS + " TEXT NOT NULL" + ")";
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

    public long Insert(int id, String name, String address, String phone, String yearob, String imgAvatar, String imgBackground, String nameAccounts, String passWord){
        ContentValues values = new ContentValues();
        values.put(ID_USER, id);
        values.put(NAME_USER,name);
        values.put(ADDRESS_USER, address);
        values.put(PHONE_USER, phone);
        values.put(YEAROB_USER, yearob);
        values.put(IMAGEAVATAR_USER,imgAvatar);
        values.put(IMAGEBACKGROUND_USER,imgBackground);
        values.put(NAME_ACCOUNTS,nameAccounts);
        values.put(PWACCOUNTS,passWord);
        return myDB.insert(TABLE_NAME, null, values);
    }
    public long Update(int id, String name, String address, String phone, String yearob, String imgAvatar, String nameAccounts){
        ContentValues values = new ContentValues();
        values.put(NAME_USER, name);
        values.put(ADDRESS_USER, address);
        values.put(PHONE_USER, phone);
        values.put(YEAROB_USER, yearob);
        values.put(IMAGEAVATAR_USER,imgAvatar);
        values.put(NAME_ACCOUNTS,nameAccounts);
        String where = ID_USER + " = " + id;
        return myDB.update(TABLE_NAME, values, where, null);
    }
    public long Delete(int id){
        ContentValues values = new ContentValues();
        values.put(ID_USER, id);
        String where = ID_USER + " = " + id;
        return myDB.delete(TABLE_NAME, where, null);
    }
    public Cursor ALLRecord(String query){
        return myDB.rawQuery(query, null);
    }
}
