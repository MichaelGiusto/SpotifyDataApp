package com.cs2340.spotifydataapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class AccountActivity extends AppCompatActivity {
    private AppBarConfiguration appBarConfiguration;
    private DatabaseHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_settings);

        Button updateBtn = findViewById(R.id.update_account_button);
        Button deleteBtn = findViewById(R.id.delete_account_button);
    }

    void deleteAccount(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //temp value for now
                dbh.deleteAccount("hi");
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
