package com.example.administrator.sqliteapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 1);
        Button createButton = (Button) findViewById(R.id.Activity_Main_Create_Button);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.getWritableDatabase();
            }
        });
    }

    public class MyDatabaseHelper extends SQLiteOpenHelper {
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
}
