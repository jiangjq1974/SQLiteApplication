package com.example.administrator.sqliteapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by lsx on 2016/7/31.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "MyDatabaseHelper";
    public static final String CREATE_BOOK = "create table " + BookStoreContract.BookStore.TABLE_NAME
            + " (" + BookStoreContract.BookStore.ID + " integer primary key autoincrement, "
            + BookStoreContract.BookStore.AUTHOR + " text, "
            + BookStoreContract.BookStore.PRICE + " real, "
            + BookStoreContract.BookStore.PAGES + " integer, "
            + BookStoreContract.BookStore.NAME + " text)";

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_BOOK);
        Log.d(TAG, "Create succeeded");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
