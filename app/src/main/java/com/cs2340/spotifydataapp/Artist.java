package com.cs2340.spotifydataapp;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Artist {
    String name;
    ArrayList<String> genres;
    String imageUrl;
    int rank;

    Artist(String name, ArrayList<String> genres, String imageUrl, int rank) {
        this.name = name;
        this.genres = genres;
        this.imageUrl = imageUrl;
        this.rank = rank;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getRank() {
        return rank;
    }


    // toString method
    @NonNull
    @Override
    public String toString() {
        String genresString = String.join(", ", genres);

        return "Artist: " + name + "\n" +
                "Genres: " + genresString + "\n" +
                "Image URL: " + imageUrl + "\n" +
                "Rank: " + rank + "\n";
    }
}

