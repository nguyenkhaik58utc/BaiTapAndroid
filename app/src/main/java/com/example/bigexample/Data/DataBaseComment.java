package com.example.bigexample.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseComment extends SQLiteOpenHelper {

    private static final String DBName = "AppThueTro.db";
    private static final int VERSION = 1;
    private static final String TABLE_NAME = "tableComment";
    private static final String ID_COMMENT = "_id";
    private static final String ID_POST = "idPost";
    private static final String ID_USER = "idUser";
    private static final String CONTENT_COMMENT = "contentComment";

    private SQLiteDatabase myDB;

    public DataBaseComment( Context context) {
        super(context, DBName, null, VERSION);
    }

    public static String getIdComment() {
        return ID_COMMENT;
    }

    public static String getIdPost() {
        return ID_POST;
    }

    public static String getIdUser() {
        return ID_USER;
    }

    public static String getContentComment() {
        return CONTENT_COMMENT;
    }

    public Cursor Load(String sql){
        openDB();
        return myDB.rawQuery(sql, null);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryTable = "CREATE TABLE " + TABLE_NAME +
                " ( " + ID_COMMENT + " INTEGER PRIMARY KEY, " +
                ID_POST + " INTEGER NOT NULL, " +
                ID_USER + " INTEGER NOT NULL, " +
                CONTENT_COMMENT + " TEXT NOT NULL" + ")";
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

    public long Insert(int id,int idPost,int idUser,String content){
        ContentValues values = new ContentValues();
        values.put(ID_COMMENT, id);
        values.put(ID_POST,idPost);
        values.put(ID_USER, idUser);
        values.put(CONTENT_COMMENT,content);
        return myDB.insert(TABLE_NAME, null, values);
    }
    public long Update(int id,String content){
        ContentValues values = new ContentValues();
        values.put(CONTENT_COMMENT, content);
        String where = ID_COMMENT + " = " + id;
        return myDB.update(TABLE_NAME, values, where, null);
    }
    public long Delete(int id){
        ContentValues values = new ContentValues();
        values.put(ID_COMMENT, id);
        String where = ID_COMMENT + " = " + id;
        return myDB.delete(TABLE_NAME, where, null);
    }
    public Cursor ALLRecord(String query){
        return myDB.rawQuery(query, null);
    }
}

