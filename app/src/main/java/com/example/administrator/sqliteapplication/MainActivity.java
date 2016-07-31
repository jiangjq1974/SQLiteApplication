package com.example.administrator.sqliteapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.administrator.sqliteapplication.database.BookStoreContract;
import com.example.administrator.sqliteapplication.database.MyDatabaseHelper;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private MyDatabaseHelper dbHelper;
    private Button createButton;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 1);
        createButton = (Button) findViewById(R.id.Activity_Main_Create_Button);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.getWritableDatabase();
            }
        });
        addButton = (Button) findViewById(R.id.Activity_Main_Add_Button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(BookStoreContract.BookStore.NAME,"book1");
                values.put(BookStoreContract.BookStore.AUTHOR, "Tom");
                values.put(BookStoreContract.BookStore.PAGES,"123");
                values.put(BookStoreContract.BookStore.PRICE,"12");
                db.insert(BookStoreContract.BookStore.TABLE_NAME,null,values);
                values.clear();
                values.put(BookStoreContract.BookStore.NAME,"book2");
                values.put(BookStoreContract.BookStore.AUTHOR, "Jerry");
                values.put(BookStoreContract.BookStore.PAGES,"231");
                values.put(BookStoreContract.BookStore.PRICE,"23");
                db.insert(BookStoreContract.BookStore.TABLE_NAME,null,values);
                Log.d(TAG, "Insert records successful!");
            }
        });
    }

}
