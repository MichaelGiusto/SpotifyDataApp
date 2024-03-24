package com.cs2340.spotifydataapp;
import android.provider.BaseColumns;

public class UserContract {

    // Inner class that defines the table contents
    public static final class UserEntry implements BaseColumns {
        // Table name
        public static final String TABLE_NAME = "users";
        // Column names
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_PASSWORD = "password";
        public static final String COLUMN_TOP_ARTISTS = "top_artists";
        public static final String COLUMN_FAVORITE_ALBUM = "favorite_album";

        public static final String COLUMN_TOP_TRACKS = "top_tracks";
        public static final String COLUMN_FAVORITE_ARTIST = "favorite_artist";
        public static final String COLUMN_FAVORITE_SHOW = "favorite_show";
        public static final String COLUMN_PREVIOUS_WRAPPED = "previous_wrapped";

        // SQL query to create the table
        public static final String CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY," +
                        COLUMN_USERNAME + " TEXT," +
                        COLUMN_PASSWORD + " TEXT," +

                        COLUMN_TOP_ARTISTS + " TEXT," +
                        COLUMN_TOP_TRACKS + "TEXT," +

                        COLUMN_FAVORITE_ALBUM + " TEXT," +
                        COLUMN_FAVORITE_ARTIST + " TEXT," +
                        COLUMN_FAVORITE_SHOW + " TEXT," +
                        COLUMN_PREVIOUS_WRAPPED + " TEXT" +
                        ")";
    }
}

