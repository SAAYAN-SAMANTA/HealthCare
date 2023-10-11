package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);
    }

    public void clickprofile(View view) {
        Intent intent = new Intent(home.this, userprofile.class);
        startActivity(intent);
    }

    public void clickheathcheckup(View view) {
        Intent intent = new Intent(home.this, health_checkup.class);
        startActivity(intent);
    }

    public void prescription(View view) {
        Intent intent = new Intent(home.this, Prescribed_Medicines.class);
        startActivity(intent);
    }

    public void bookdoctor(View view) {
        Intent intent = new Intent(home.this, bookdoctor.class);
        startActivity(intent);
    }
}