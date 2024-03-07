package com.cs2340.spotifydataapp;

import java.util.ArrayList;

public class SpotifyWrapped {
    ArrayList<String> topArtists;
    ArrayList<String> topTracks;

    public ArrayList<String> getTopArtists() {
        return topArtists;
    }

    public void setTopArtists(ArrayList<String> topArtists) {
        this.topArtists = topArtists;
    }

    public ArrayList<String> getTopTracks() {
        return topTracks;
    }

    public void setTopTracks(ArrayList<String> topTracks) {
        this.topTracks = topTracks;
    }

}
