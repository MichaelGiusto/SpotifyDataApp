package com.cs2340.spotifydataapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cs2340.spotifydataapp.databinding.ActivityHomeBinding;
import com.spotify.sdk.android.auth.AuthorizationClient;
import com.spotify.sdk.android.auth.AuthorizationRequest;
import com.spotify.sdk.android.auth.AuthorizationResponse;

public class LoginPageActivity extends AppCompatActivity {

    public static final String CLIENT_ID = "c595ba6b79e049888c9144dab1a16a39";
    public static final String REDIRECT_URI = "spotifydataapp://auth";
    private String mAccessToken;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        Button switch_to_signup_button = (Button) findViewById(R.id.switch_to_signup_button);
        switch_to_signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPageActivity.this, SignupPageActivity.class);
                startActivity(intent);
            }
        });

        Button login_button = (Button) findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = ((EditText) findViewById(R.id.login_username)).getText().toString();
                String password = ((EditText) findViewById(R.id.login_password)).getText().toString();
                System.out.println(username + "--" + password);
                // TODO: verify user exists and password matches.

                getToken();
            }
        });

    }



    // Get token from Spotify.
    // This method will open the Spotify login activity and get the access token.
    public void getToken() {
        final AuthorizationRequest request = getAuthenticationRequest(AuthorizationResponse.Type.TOKEN);
        AuthorizationClient.openLoginActivity(LoginPageActivity.this, 0, request);
    }

    // When the app leaves this activity to momentarily get a token/code, this function
    // fetches the result of that external activity to get the response from Spotify.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        final AuthorizationResponse response = AuthorizationClient.getResponse(resultCode, data);

        // Get token response from api call.
        mAccessToken = response.getAccessToken();
        // Sets the new access token value in the API Accessor class
        SpotifyAPIAccessor.setmAccessToken(mAccessToken);
        // Gets the relevant user data
        //SpotifyAPIAccessor.getTopUserTracks();
        //SpotifyAPIAccessor.getTopUserArtists();
        //ChatGPTAPIAccessor.describeArtists();
        SpotifyAPIAccessor.getUserInfo();

        // Go to next page: TODO replace target page
        Intent intent = new Intent(LoginPageActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    // Get authentication request
    private AuthorizationRequest getAuthenticationRequest(AuthorizationResponse.Type type) {
        return new AuthorizationRequest.Builder(CLIENT_ID, type, getRedirectUri().toString())
                .setShowDialog(false)
                .setScopes(new String[] { "user-read-email", "user-top-read", "user-follow-read" }) // <--- Change the scope of your requested token here
                .setCampaign("your-campaign-token")
                .build();
    }

    // Gets the redirect Uri for Spotify.
    private Uri getRedirectUri() {
        return Uri.parse(REDIRECT_URI);
    }
}
