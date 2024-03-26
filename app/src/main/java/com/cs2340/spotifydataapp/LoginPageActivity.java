package com.cs2340.spotifydataapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cs2340.spotifydataapp.databinding.ActivityHomeBinding;

public class LoginPageActivity extends AppCompatActivity {
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

    }
}
