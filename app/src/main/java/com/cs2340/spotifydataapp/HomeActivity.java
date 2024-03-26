package com.cs2340.spotifydataapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.cs2340.spotifydataapp.databinding.ActivityHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Button btn = findViewById(R.id.spotify_auth_button);

        TextView name = findViewById(R.id.textView);
        SpotifyAPIAccessor.getUserInfo();
        String username = SpotifyAPIAccessor.currentUser.getUsername();
        //need to DEBUG before uncommenting!
       // name.setText(username);

        ImageButton btn = findViewById(R.id.accountInfo);
        viewAccountInfo(btn);

        List<String> stringList = new ArrayList<>();
        stringList.add("Wrapped 3/26/2024");
        stringList.add("Wrapped 1/20/2024");
        stringList.add("Wrapped 1/19/2024");

        LinearLayout buttonContainer = findViewById(R.id.scroll);

        // Dynamically create buttons and add them to the layout
        for (String text : stringList) {
            Button button = new Button(this);
            button.setText(text);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle button click
                }
            });
            buttonContainer.addView(button);
        }
    }

    void viewAccountInfo(ImageButton btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AccountActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }


}