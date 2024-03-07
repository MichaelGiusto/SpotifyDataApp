package com.cs2340.spotifydataapp;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Track {
    String name;
    //ArrayList<String> genres;
    String imageUrl;
    ArrayList<String> artists;
    int rank;

    Track(String name, String imageUrl, ArrayList<String> artists, int rank) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.artists = artists;
        this.rank = rank;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    /*public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }*/

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setArtists(ArrayList<String> artists) {
        this.artists = artists;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }


    // Getters
    public String getName() {
        return name;
    }

    /*public ArrayList<String> getGenres() {
        return genres;
    }*/

    public String getImageUrl() {
        return imageUrl;
    }

    public ArrayList<String> getArtists() {
        return artists;
    }

    public int getRank() {
        return rank;
    }


    // toString method
    @NonNull
    @Override
    public String toString() {
        String artistsString = String.join(", ", artists);

        return "Song: " + name + "\n" +
                "Image URL: " + imageUrl + "\n" +
                "Artists: " + artistsString + "\n" +
                "Rank: " + rank + "\n";
    }
}

