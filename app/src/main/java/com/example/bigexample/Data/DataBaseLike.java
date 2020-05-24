package com.example.bigexample.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseLike extends SQLiteOpenHelper {

    private static final String DBName = "AppThueTro.db";
    private static final int VERSION = 1;
    private static final String TABLE_NAME = "tableLike";
    private static final String ID_LIKE = "_id";
    private static final String ID_POST = "idPost";
    private static final String ID_USER = "idUser";

    private SQLiteDatabase myDB;

    public DataBaseLike( Context context) {
        super(context, DBName, null, VERSION);
    }

    public static String getIdLike() {
        return ID_LIKE;
    }

    public static String getIdPost() {
        return ID_POST;
    }

    public static String getIdUser() {
        return ID_USER;
    }

    public Cursor Load(String sql){
        openDB();
        return myDB.rawQuery(sql, null);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryTable = "CREATE TABLE " + TABLE_NAME +
                " ( " + ID_LIKE + " INTEGER PRIMARY KEY, " +
                ID_POST + " INTEGER NOT NULL, " +
                ID_USER + " INTEGER NOT NULL" + ")";
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

    public long Insert(int id,int idPost,int idUser){
        ContentValues values = new ContentValues();
        values.put(ID_LIKE, id);
        values.put(ID_POST,idPost);
        values.put(ID_USER, idUser);
        return myDB.insert(TABLE_NAME, null, values);
    }
    public long Update(int id,int idPost,int idUser){
        ContentValues values = new ContentValues();
        values.put(ID_LIKE, id);
        values.put(ID_POST,idPost);
        values.put(ID_USER, idUser);
        String where = ID_USER + " = " + id;
        return myDB.update(TABLE_NAME, values, where, null);
    }
    public long Delete(int id){
        ContentValues values = new ContentValues();
        values.put(ID_LIKE, id);
        String where = ID_LIKE + " = " + id;
        return myDB.delete(TABLE_NAME, where, null);
    }
    public Cursor ALLRecord(String query){
        return myDB.rawQuery(query, null);
    }
}
