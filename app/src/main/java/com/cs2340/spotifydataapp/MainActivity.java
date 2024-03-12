package com.cs2340.spotifydataapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.spotify_auth_button);
        setupSpotifyAuthButton(btn);
    }

    void setupSpotifyAuthButton(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SpotifyAuth.class);
                startActivity(intent);
            }
        });
    }
// The code below is for adding users to the database...would happen on click for a user...
//    // Instantiate the database helper class
//    UserDatabase userDatabase = new UserDatabase(getApplicationContext());
//
//    // Create a new user object
//    User user = new User("username", "password", new ArrayList<>(), "favAlbum", "favArtist", "favShow", new Stack<>());
//
//    // Add the user to the database
//    long result = userDatabase.addUser(user);
}