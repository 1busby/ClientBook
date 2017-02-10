package com.mbusby.clientbook.SQLite;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ClientReaderDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ClientReader.db";

    public ClientReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
        }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
        }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
        }

    private static final String SQL_CREATE_ENTRIES =
    "CREATE TABLE " + ClientReaderContract.ClientEntry.TABLE_NAME + " (" +
            ClientReaderContract.ClientEntry._ID + " INTEGER PRIMARY KEY," +
            ClientReaderContract.ClientEntry.COLUMN_NAME_TITLE + " TEXT," +
            ClientReaderContract.ClientEntry.COLUMN_NAME_SUBTITLE + " TEXT)";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + ClientReaderContract.ClientEntry.TABLE_NAME;
}