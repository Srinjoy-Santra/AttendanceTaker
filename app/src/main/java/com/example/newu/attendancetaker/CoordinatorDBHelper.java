package com.example.newu.attendancetaker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CoordinatorDBHelper extends SQLiteOpenHelper {


    static final String col1 = "CoordID";
    static final String col2 = "SchoolID";
    static final String col3 = "CoordName";
    static final String col4 = "CoordPhone";
    static final String col5 = "CoordEmail";
    private static final String table_name = "CoordinatorDB";
    String create_query = "create table "
            + table_name + "(" + col1 + " varchar(30) primary key autoincrement,"
            + col2 +" VARCHAR(40) ,"
            + col3 + " VARCHAR(30),"
            + col4 + " VARCHAR(30),"
            + col5 + " VARCHAR(40));";



    public CoordinatorDBHelper(Context context) {
        super(context, "mydb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    long insertdata(String coordID, String schoolID, String coordName, String coordPhone, String coordEmail) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col1, coordID);
        contentValues.put(col2, schoolID);
        contentValues.put(col3, coordName);
        contentValues.put(col4, coordPhone);
        contentValues.put(col5, coordEmail);

        return db.insert(table_name, null, contentValues);
    }
    Cursor login(String email, String password)
    {
        String[] clmns = {col1,col2,col3,col4,col5};
        String selection = col2 + "= ? and " + col3 + "= ?";
        String[] arg = {email,password};
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor= sqLiteDatabase.query(table_name,clmns,selection,arg,null,null,null);
        return cursor;
    }



}
