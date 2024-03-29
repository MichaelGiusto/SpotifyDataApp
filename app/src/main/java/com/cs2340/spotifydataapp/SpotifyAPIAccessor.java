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

    public static User currentUser =  new User();

    public static void setmAccessToken(String newAccessToken) {
        mAccessToken = newAccessToken;
    }
    public static void getTopUserTracks() {
        callSpotifyAPI("https://api.spotify.com/v1/me/top/tracks?time_range=long_term&limit=1", "track");
    }

    public static void getTopUserArtists() {
        callSpotifyAPI("https://api.spotify.com/v1/me/top/artists?time_range=long_term&limit=1", "artist");
    }
    public static void getUserInfo() {
        callSpotifyAPI("https://api.spotify.com/v1/me", "user");
    }

    // Actual REST API call.
    private static void callSpotifyAPI(String targetUrl, String returnType) {
        if (mAccessToken == null) {
            return;
        }

        // Create a request to get the user profile.
        final Request request = new Request.Builder()
                .url(targetUrl)
                .addHeader("Authorization", "Bearer " + mAccessToken)
                .build();


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
                    //System.out.println(jsonObject);
                    // PASS DATA FROM HERE TO DATABASE
                    SpotifyWrapped temp = new SpotifyWrapped();
                    if (returnType.equals("artist"))
                        temp.setTopArtists(jsonObject);
                    else if (returnType.equals("track"))
                        temp.setTopTracks(jsonObject);
                    currentUser.setUsername(jsonObject.get("display_name").toString());
                } catch (JSONException e) {
                    Log.d("JSON", "Failed to parse data: " + e);
                }
            }
        });
    }
}


// SAMPLE RESPONSE FROM getTopUserArtists()
/*
{
   "items": [
      {
         "external_urls": {
            "spotify": "https:\/\/open.spotify.com\/artist\/0kpcv0xdcnCWiCXr3htCwx"
         },
         "followers": {
            "href": null,
            "total": 30156
         },
         "genres": [
            "japanese r&b"
         ],
         "href": "https:\/\/api.spotify.com\/v1\/artists\/0kpcv0xdcnCWiCXr3htCwx",
         "id": "0kpcv0xdcnCWiCXr3htCwx",
         "images": [
            {
               "height": 640,
               "url": "https:\/\/i.scdn.co\/image\/ab6761610000e5ebae2afb684ff386fc8e7e9bde",
               "width": 640
            },
            {
               "height": 320,
               "url": "https:\/\/i.scdn.co\/image\/ab67616100005174ae2afb684ff386fc8e7e9bde",
               "width": 320
            },
            {
               "height": 160,
               "url": "https:\/\/i.scdn.co\/image\/ab6761610000f178ae2afb684ff386fc8e7e9bde",
               "width": 160
            }
         ],
         "name": "Kenta Dedachi",
         "popularity": 32,
         "type": "artist",
         "uri": "spotify:artist:0kpcv0xdcnCWiCXr3htCwx"
      }
   ],
   "total": 120,
   "limit": 1,
   "offset": 0,
   "href": "https:\/\/api.spotify.com\/v1\/me\/top\/artists?limit=1&time_range=long_term",
   "next": "https:\/\/api.spotify.com\/v1\/me\/top\/artists?offset=1&limit=1&time_range=long_term",
   "previous": null
}
 */