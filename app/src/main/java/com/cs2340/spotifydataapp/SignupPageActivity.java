package com.cs2340.spotifydataapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignupPageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);


        Button switch_to_login_button = (Button) findViewById(R.id.switch_to_login_button);
        switch_to_login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupPageActivity.this, LoginPageActivity.class);
                startActivity(intent);
            }
        });

        Button signup_button = (Button) findViewById(R.id.signup_button);
        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newUsername = ((EditText) findViewById(R.id.signup_username)).getText().toString();
                String newPassword = ((EditText) findViewById(R.id.signup_password)).getText().toString();
                System.out.println(newUsername + "--" + newPassword);
                // TODO: add new user to database.
            }
        });

    }
}
