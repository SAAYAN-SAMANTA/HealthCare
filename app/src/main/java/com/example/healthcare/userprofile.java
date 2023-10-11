package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class userprofile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_userprofile);
    }

    public void back(View view) {
        Intent intent = new Intent(userprofile.this, home.class);
        startActivity(intent);
    }

    public void edit(View view) {
        Intent intent = new Intent(userprofile.this, profile.class);
        startActivity(intent);
    }
}
