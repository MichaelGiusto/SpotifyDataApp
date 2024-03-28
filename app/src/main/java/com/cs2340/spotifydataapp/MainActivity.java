package com.cs2340.spotifydataapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.spotify_auth_button);
        setupSpotifyAuthButton(btn);

        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
    }

    // Code to add users to the database
    public void addUser(String username, String password, String favAlbum, String favArtist, String favShow, Stack<SpotifyWrapped> previousWrapped) {
        String userId = databaseReference.child("users").push().getKey();
        User user = new User(username, password, favAlbum, favArtist, favShow, (Stack<SpotifyWrapped>) previousWrapped);
        assert userId != null;
        databaseReference.child("users").child(userId).setValue(user);
    }

    // Code to get users from the database
    public void getUsers() {
        databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot currentData) {
                for (DataSnapshot userSnapshot : currentData.getChildren()) {
                    User user = userSnapshot.getValue(User.class);
                    if (user != null) {
                        // Data Changes
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
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
}