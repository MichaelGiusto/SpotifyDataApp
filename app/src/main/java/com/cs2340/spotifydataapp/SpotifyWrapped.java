package com.cs2340.spotifydataapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SpotifyWrapped {
    ArrayList<Artist> topArtists;
    ArrayList<Track> topTracks;

    public ArrayList<Artist> getTopArtists() {
        return topArtists;
    }

    public void setTopArtists(JSONObject topArtistsJSON) throws JSONException {
        try {
            JSONArray artists = topArtistsJSON.getJSONArray("items");
            ArrayList<Artist> topArtists = new ArrayList<Artist>();

            for (int i = 0; i < artists.length(); i++) {
                JSONObject artist = artists.getJSONObject(i);

                String artistName = artist.get("name").toString();

                JSONArray artistGenresJSON = artist.getJSONArray("genres");
                ArrayList<String> artistGenres = new ArrayList<String>();
                for (int j = 0; j < artistGenresJSON.length(); j++) {
                    artistGenres.add(artistGenresJSON.get(j).toString());
                }

                String artistImageUrl = artist.getJSONArray("images").getJSONObject(0).get("url").toString();

                topArtists.add(new Artist(artistName, artistGenres, artistImageUrl, (i+1)));
            }
        } catch (JSONException e) {
            Log.d("JSON", "Failed to parse data: " + e);
        }
    }

    public ArrayList<Track> getTopTracks() {
        return topTracks;
    }

    public void setTopTracks(JSONObject topTracksJSON) {
        try {
            JSONArray tracks = topTracksJSON.getJSONArray("items");
            ArrayList<Track> topTracks = new ArrayList<Track>();

            for (int i = 0; i < tracks.length(); i++) {
                JSONObject track = tracks.getJSONObject(i);

                String artistName = track.get("name").toString();

                String trackImageUrl = track.getJSONObject("album").getJSONArray("images").getJSONObject(0).get("url").toString();

                JSONArray trackArtistsJSON = track.getJSONArray("artists");
                ArrayList<String> trackArtists = new ArrayList<String>();
                for (int j = 0; j < trackArtistsJSON.length(); j++) {
                    trackArtists.add(trackArtistsJSON.getJSONObject(j).get("name").toString());
                }

                topTracks.add(new Track(artistName, trackImageUrl, trackArtists, (i+1)));
            }
        } catch (JSONException e) {
            Log.d("JSON", "Failed to parse data: " + e);
        }
    }

}
