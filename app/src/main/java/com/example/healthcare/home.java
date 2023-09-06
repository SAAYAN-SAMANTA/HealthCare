package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void clickprofile(View view) {
        Intent intent = new Intent(home.this, profile.class);
        startActivity(intent);
    }

    public void clickheathcheckup(View view) {
        Intent intent = new Intent(home.this, health_checkup.class);
        startActivity(intent);
    }
}