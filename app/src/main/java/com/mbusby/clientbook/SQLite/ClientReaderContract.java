package com.mbusby.clientbook.SQLite;

import android.provider.BaseColumns;

public final class ClientReaderContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.

    private ClientReaderContract() {}

    /* Inner class that defines the table contents */
        public static class ClientEntry implements BaseColumns {
        public static final String TABLE_NAME = "clients";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
        }
}