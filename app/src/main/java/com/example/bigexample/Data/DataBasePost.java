package com.example.bigexample.Data;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBasePost extends SQLiteOpenHelper {

    private static final String DBName = "AppThueTro.db";
    private static final int VERSION = 1;
    private static final String TABLE_NAME = "Post";
    private static final String ID_POST = "_id";
    private static final String ID_USER = "idUser";
    private static final String ADDRESS_POST = "addressPost";
    private static final String PRICE_POST = "pricePost";
    private static final String DESCRIBE_POST = "describePost";
    private static final String IMAGE1_POST = "imagePost1";
    private static final String IMAGE2_POST = "imagePost2";

    private SQLiteDatabase myDB;

    public DataBasePost( Context context) {
        super(context, DBName, null, VERSION);
    }

    public static String getIdPost() {
        return ID_POST;
    }

    public static String getIdUser() {
        return ID_USER;
    }

    public static String getAddressPost() {
        return ADDRESS_POST;
    }

    public static String getPricePost() {
        return PRICE_POST;
    }

    public static String getDescribePost() {
        return DESCRIBE_POST;
    }

    public static String getImage1Post() {
        return IMAGE1_POST;
    }

    public static String getImage2Post() {
        return IMAGE2_POST;
    }

    public Cursor Load(String sql){
        openDB();
        return myDB.rawQuery(sql, null);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryTable = "CREATE TABLE " + TABLE_NAME +
                "( " + ID_POST + " INTEGER PRIMARY KEY, " +
                ID_USER + " INTEGER NOT NULL, " +
                ADDRESS_POST + " TEXT NOT NULL, " +
                PRICE_POST + " TEXT NOT NULL, " +
                DESCRIBE_POST + " TEXT NOT NULL, " +
                IMAGE1_POST + " TEXT NOT NULL, " +
                IMAGE2_POST + " TEXT NOT NULL" + ")";
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

    public long Insert(int id, int idUser, String address, String price, String describe, String image1, String image2){
        ContentValues values = new ContentValues();
        values.put(ID_POST, id);
        values.put(ID_USER,idUser);
        values.put(ADDRESS_POST, address);
        values.put(PRICE_POST, price);
        values.put(DESCRIBE_POST, describe);
        values.put(IMAGE1_POST,image1);
        values.put(IMAGE2_POST,image2);
        return myDB.insert(TABLE_NAME, null, values);
    }
    public long Update(int id,String address, String price, String describe, String image1, String image2){
        ContentValues values = new ContentValues();
        values.put(ADDRESS_POST, address);
        values.put(PRICE_POST, price);
        values.put(DESCRIBE_POST, describe);
        values.put(IMAGE1_POST,image1);
        values.put(IMAGE2_POST,image2);
        String where = ID_POST + " = " + id;
        return myDB.update(TABLE_NAME, values, where, null);
    }
    public long Delete(int id){
        ContentValues values = new ContentValues();
        values.put(ID_POST, id);
        String where = ID_POST + " = " + id;
        return myDB.delete(TABLE_NAME, where, null);
    }
    public Cursor ALLRecord(String query){
        return myDB.rawQuery(query, null);
    }
}

