package com.example.bigexample.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataChat extends SQLiteOpenHelper {

    private static final String DBName = "AppThueTro.db";
    private static final int VERSION = 1;
    private static final String TABLE_NAME = "tableChat";
    private static final String ID_CHAT = "_id";
    private static final String ID_USER1 = "idUser1";
    private static final String ID_USER2 = "idUser2";
    private static final String CONTENT_CHAT = "contentChat";

    private SQLiteDatabase myDB;

    public DataChat( Context context) {
        super(context, DBName, null, VERSION);
    }

    public static String getIdChat() {
        return ID_CHAT;
    }

    public static String getIdUser1() {
        return ID_USER1;
    }

    public static String getIdUser2() {
        return ID_USER2;
    }

    public Cursor Load(String sql){
        openDB();
        return myDB.rawQuery(sql, null);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryTable = "CREATE TABLE " + TABLE_NAME +
                " ( " + ID_CHAT + " INTEGER PRIMARY KEY, " +
                ID_USER1 + " INTEGER NOT NULL, " +
                ID_USER2 + " INTEGER NOT NULL, " +
                CONTENT_CHAT + " TEXT NOT NULL" + ")";
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

    public long Insert(int id,int idUser1,int idUser2,String content){
        ContentValues values = new ContentValues();
        values.put(ID_CHAT, id);
        values.put(ID_USER1,idUser1);
        values.put(ID_USER2, idUser2);
        values.put(CONTENT_CHAT,content);
        return myDB.insert(TABLE_NAME, null, values);
    }
    public long Update(int id,int idUser1,int idUser2,String content){
        ContentValues values = new ContentValues();
        values.put(ID_USER1,idUser1);
        values.put(ID_USER2, idUser2);
        values.put(CONTENT_CHAT,content);
        String where = ID_CHAT + " = " + id;
        return myDB.update(TABLE_NAME, values, where, null);
    }
    public long Delete(int id){
        ContentValues values = new ContentValues();
        values.put(ID_CHAT, id);
        String where = ID_CHAT + " = " + id;
        return myDB.delete(TABLE_NAME, where, null);
    }
    public Cursor ALLRecord(String query){
        return myDB.rawQuery(query, null);
    }
}

