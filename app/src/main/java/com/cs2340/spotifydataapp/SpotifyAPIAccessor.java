package com.cs2340.spotifydataapp;

import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SpotifyAPIAccessor {

    private static String mAccessToken;
    private static final OkHttpClient mOkHttpClient = new OkHttpClient();
    private static Call mCall;

    public static void setmAccessToken(String newAccessToken) {
        mAccessToken = newAccessToken;
    }
    public static void test() {
        callSpotifyAPI("https://api.spotify.com/v1/me/top/artists?time_range=long_term&limit=1");
    }

    // Actual REST API call.
    private static void callSpotifyAPI(String targetUrl) {
        if (mAccessToken == null) {
            return;
        }

        // Create a request to get the user profile.
        final Request request = new Request.Builder()
                .url(targetUrl)
                //.url("https://api.spotify.com/v1/me/shows?offset=0&limit=20")
                //.url("https://api.spotify.com/v1/users/mbqxflrx0pzpnmn6xpf3sayql")
                //.url("https://api.spotify.com/v1/users/mbqxflrx0pzpnmn6xpf3sayql/playlists")
                .addHeader("Authorization", "Bearer " + mAccessToken)
                .build();


        cancelCall();
        mCall = mOkHttpClient.newCall(request);

        mCall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("HTTP", "Failed to fetch data: " + e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    final JSONObject jsonObject = new JSONObject(response.body().string());
                    System.out.println(jsonObject.toString());
                } catch (JSONException e) {
                    Log.d("JSON", "Failed to parse data: " + e);
                }
            }
        });
    }

    // Cancel current api call before starting next call.
    private static void cancelCall() {
        if (mCall != null) {
            mCall.cancel();
        }
    }
}
