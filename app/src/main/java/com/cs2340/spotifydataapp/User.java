package com.cs2340.spotifydataapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Stack;

public class User {

    String username;
    String password;
    ArrayList<String> topArtists;
    String favoriteAlbum;
    String favoriteArist;
    String favoriteShow;
    Stack<SpotifyWrapped> previousWrapped;

    public User(String username, String password, ArrayList<String> topArtists,
                String favoriteAlbum, String favoriteArist, String favoriteShow, Stack<SpotifyWrapped> previousWrapped) {
        this.username = username;
        this.password = password;
        this.topArtists = topArtists;
        this.favoriteAlbum = favoriteAlbum;
        this.favoriteArist = favoriteArist;
        this.favoriteShow = favoriteShow;
        this.previousWrapped = previousWrapped;
    }

    public User() {
        this.username = null;
        this.password = null;
        this.topArtists = null;
        this.favoriteAlbum = null;
        this.favoriteArist = null;
        this.favoriteShow = null;
        this.previousWrapped = null;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getTopArtists() {
        return topArtists;
    }

    public void setTopArtists(ArrayList<String> topArtists) {
        this.topArtists = topArtists;
    }

    public String getFavoriteAlbum() {
        return favoriteAlbum;
    }

    public void setFavoriteAlbum(String favoriteAlbum) {
        this.favoriteAlbum = favoriteAlbum;
    }

    public String getFavoriteArist() {
        return favoriteArist;
    }

    public void setFavoriteArist(String favoriteArist) {
        this.favoriteArist = favoriteArist;
    }

    public String getFavoriteShow() {
        return favoriteShow;
    }

    public void setFavoriteShow(String favoriteShow) {
        this.favoriteShow = favoriteShow;
    }

    public Stack<SpotifyWrapped> getPreviousWrapped() {
        return previousWrapped;
    }

    public void setPreviousWrapped(Stack<SpotifyWrapped> previousWrapped) {
        this.previousWrapped = previousWrapped;
    }




}
