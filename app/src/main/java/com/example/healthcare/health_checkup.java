package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class health_checkup extends AppCompatActivity {
EditText blood_pressure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_health_checkup);
        blood_pressure=(EditText) findViewById(R.id.pressure);
    }

    public void takeappointment(View view) {
        Intent intent = new Intent(health_checkup.this, health_checkup.class);
        startActivity(intent);
    }

    public void examin(View view){
        String check_pressure=blood_pressure.getText().toString();
        int systolic_bp= Integer.parseInt(check_pressure.substring(0,check_pressure.indexOf('/')+1));
        int diastolic_bp=Integer.parseInt(check_pressure.substring(check_pressure.indexOf('/'),(check_pressure.length()+1)));
        if(systolic_bp<=90 && diastolic_bp<=60){
            Toast.makeText(health_checkup.this,"low bp",Toast.LENGTH_SHORT).show();
        } else if (systolic_bp<=120 && diastolic_bp==60) {
            Toast.makeText(health_checkup.this,"Normal bp",Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(health_checkup.this,"high bp",Toast.LENGTH_SHORT).show();
        }
    }
}