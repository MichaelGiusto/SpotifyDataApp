package com.cs2340.spotifydataapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Stack;

public class UserDatabase {

    private SQLiteDatabase db;

    public UserDatabase(Context context) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    // Method to add a new user to the database
    public long addUser(User user) {
        ContentValues values = new ContentValues();
        values.put(UserContract.UserEntry.COLUMN_USERNAME, user.getUsername());
        values.put(UserContract.UserEntry.COLUMN_PASSWORD, user.getPassword());
        values.put(UserContract.UserEntry.COLUMN_FAVORITE_ALBUM, user.getFavoriteAlbum());
        values.put(UserContract.UserEntry.COLUMN_FAVORITE_ARTIST, user.getFavoriteArist());
        values.put(UserContract.UserEntry.COLUMN_FAVORITE_SHOW, user.getFavoriteShow());

        values.put(UserContract.UserEntry.COLUMN_TOP_TRACKS, trackToString(user.getPreviousWrapped().peek().getTopTracks()));
        values.put(UserContract.UserEntry.COLUMN_TOP_ARTISTS, artistToString(user.getPreviousWrapped().peek().getTopArtists()));
        // Convert Stack to String representation
        values.put(UserContract.UserEntry.COLUMN_PREVIOUS_WRAPPED, stackToString(user.getPreviousWrapped()));

        return db.insert(UserContract.UserEntry.TABLE_NAME, null, values);
    }

    // Method to convert ArrayList to comma-separated String
    private String listToString(ArrayList<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String item : list) {
            stringBuilder.append(item).append(",");
        }
        // Remove the last comma
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    // Method to convert Stack to String
    private String stackToString(Stack<SpotifyWrapped> stack) {
        StringBuilder stringBuilder = new StringBuilder();
        for (SpotifyWrapped item : stack) {
            stringBuilder.append(item.toString()).append(",");
        }
        // Remove the last comma
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    private String trackToString(ArrayList<Track> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Track item : list) {
            stringBuilder.append(item.toString()).append(",");
        }
        // Remove the last comma
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    private String artistToString(ArrayList<Artist> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Artist item : list) {
            stringBuilder.append(item.toString()).append(",");
        }
        // Remove the last comma
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}

