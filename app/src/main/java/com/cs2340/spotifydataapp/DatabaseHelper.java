package com.cs2340.spotifydataapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database name
    private static final String DATABASE_NAME = "spotify_users.db";
    // Database version
    private static final int DATABASE_VERSION = 1;

    //table name
    private static final String TABLE_NAME = "userinfo";

    //name for our track column
    private static final String TRACKS_COL = "tracks";

    //name for our artist column
    private static final String ARTISTS_COL = "artists";


    // Constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create user table
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + TRACKS_COL + " TEXT, "
                + ARTISTS_COL + " TEXT)";
        db.execSQL(UserContract.UserEntry.CREATE_TABLE);
    }

    public void addNewUserInfo (String userTracks, String userArtists) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(TRACKS_COL, userTracks);
        cv.put(ARTISTS_COL, userArtists);

        db.insert(TABLE_NAME, null, cv);

        db.close();
    }
    // Upgrade database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + UserContract.UserEntry.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }
}


