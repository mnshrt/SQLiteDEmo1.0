package com.manish.android.sqlitedemo10;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by emkayx on 06-11-2015.
 */
public class MyDbHandler extends SQLiteOpenHelper{

    private static final int DB_VERSION =1;
    private static final String DB_NAME="notes.db";
    private static  final String TABLE_NAME="notes";
    private static final String COLUMN_ID="_id";
    private static final String COLUMN_TITLE="title";

    public MyDbHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context,DB_NAME, factory, DB_VERSION);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        String query ="CREATE TABLE "+TABLE_NAME+"("+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"
                +COLUMN_TITLE+" TEXT NOT NULL);";

        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            String query = "DROP TABLE "+TABLE_NAME+" IF EXISTS";
            db.execSQL(query);
            onCreate(db);
    }

    public void deleteNote(String notestitle){

        SQLiteDatabase db = getWritableDatabase();
        String query = "DELETE FROM "+TABLE_NAME+" WHERE "+COLUMN_TITLE+" = \'"+notestitle+"\';";
        db.execSQL(query);


    }

    public void addNote(Notes note){

        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, note.get_notetitle());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME,null,values);
        db.close();

    }
    //print out the database
    public String dbToString(){
        String dbString="";
        String query ="SELECT * FROM "+TABLE_NAME+" WHERE 1";
        SQLiteDatabase db = getWritableDatabase();


        Cursor c =db.rawQuery(query, null);
        c.moveToFirst();

        while(!c.isAfterLast()){

            if(c.getString(c.getColumnIndex(COLUMN_TITLE))!=null){
                dbString += c.getString(c.getColumnIndex(COLUMN_TITLE));
                dbString+="\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }
}
