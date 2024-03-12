package com.cs2340.spotifydataapp;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.MediaType;

public class ChatGPTAPIAccessor {
    final private static String apiKey = "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";
    private static final OkHttpClient mOkHttpClient = new OkHttpClient();
    private static Call mCall;

    public static void describeArtists() {
        callSpotifyAPI("https://api.openai.com/v1/chat/completions");
    }

    // Actual REST API call.
    private static void callSpotifyAPI(String targetUrl) {
        if (apiKey == null) {
            return;
        }


        // POST request body:
        MediaType mediaType = MediaType.parse("application/json");
        String postRequestBody = "{\n" +
                "    \"model\": \"gpt-3.5-turbo\",\n" +
                "    \"messages\": [\n" +
                "      {\n" +
                "        \"role\": \"system\",\n" +
                "        \"content\": \"You are a helpful assistant.\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"role\": \"user\",\n" +
                "        \"content\": \"Describe succinctly how a person who listens to the following genres might act: japanese r&b\"\n" +
                "      }\n" +
                "    ]\n" +
                "}";
        RequestBody formBody = RequestBody.create(postRequestBody, mediaType);

        // Create a request to get the user profile.
        final Request request = new Request.Builder()
                .url(targetUrl)
                .addHeader("Authorization", "Bearer " + apiKey)
                .post(formBody)
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
                    System.out.println(jsonObject);
                } catch (JSONException e) {
                    Log.d("JSON", "Failed to parse data: " + e);
                }
            }
        });
    }
}
