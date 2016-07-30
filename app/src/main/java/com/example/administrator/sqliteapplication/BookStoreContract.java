package com.example.administrator.sqliteapplication;

import android.provider.BaseColumns;

/**
 * Created by Administrator on 16-7-28.
 */
public final class BookStoreContract {

    public BookStoreContract() {
    }

    public static  abstract class BookStore implements BaseColumns {
        public static final String TABLE_NAME="book";
        public static final String ID="id";
        public static final String AUTHOR = "author";
        public static final String PRICE = "price";
        public static final String PAGES="pages";
        public static final String NAME = "name";
    }
}
