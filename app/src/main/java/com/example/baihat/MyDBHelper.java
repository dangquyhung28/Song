package com.example.baihat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {
    private static final String DBName = "mydb.db";
    private static final int VERSION = 1;
    private static final String TABLE_NAME = "baihat";
    private static final String ID = "_id";
    private static final String NAME = "name";
    private static final String Singer = "singer";
    private static final String Time = "time";
    private SQLiteDatabase myDB;

    public MyDBHelper(@Nullable Context context) {
        super(context, DBName, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryTable = "CREATE TABLE " + TABLE_NAME + " ( " +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NAME + " TEXT NOT NULL, " +
                Singer + " TEXT NOT NULL, " +
                Time + " FLOAT NOT NULL )";
        db.execSQL(queryTable);
        insertData("Hung","Dang qUY", 3.2F);
        insertData("Phút cuối", "Bằng Kiều", 3.2F);
        insertData("Bông hồng thuỷ tinh", "Bức Tường", 4.18F);
        insertData("Hà Nội mùa thu", "Mỹ Linh", 4.11F);
        insertData("Bà tôi", "Tùng Dương", 3.27F);
        insertData("Gót hồng", "Quang Dũng", 4.01F);
        insertData("Đêm đông", "Bằng Kiều", 4.12F);
    }
    public long insertData(String name, String singer, Float time) {
        ContentValues values = new ContentValues();
        SQLiteDatabase db = getWritableDatabase();
        values.put(NAME, name);
        values.put(Singer, singer);
        values.put(Time, time);
        return  db.insert(TABLE_NAME, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static String getID() {
        return ID;
    }

    public static String getNAME() {
        return NAME;
    }

    public static String getSinger() {
        return Singer;
    }

    public static String getTime() {
        return Time;
    }

    public void openDB(){
        myDB = getWritableDatabase();
    }
    public void closeDB(){
        if (myDB != null && myDB.isOpen()){
            myDB.close();
        }
    }

    // insert
    public long Insert(String name, String singer, float time){
        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(Singer, singer);
        values.put(Time, time);
        return myDB.insert(TABLE_NAME, null, values);
    }

    public Cursor DisplayAll(){
        String query = "SELECT * FROM " + TABLE_NAME;
        return myDB.rawQuery(query,null);
    }

    public long Update(int id, String name, String singer, float time){
        ContentValues values = new ContentValues();
        values.put(ID, id);
        values.put(NAME, name);
        values.put(Singer, singer);
        values.put(Time, time);
        String where = ID + " = " + id;
        return myDB.update(TABLE_NAME, values, where, null);
    }

    public long Delete(int id){
        String where = ID + " = " + id;
        return myDB.delete(TABLE_NAME, where, null);
    }
}

