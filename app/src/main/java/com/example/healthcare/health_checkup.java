package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class health_checkup extends AppCompatActivity {
EditText blood_pressure;
TextView invalid_bp;
EditText body_temperature;
TextView invalid_temp;
EditText pulse;
TextView invalid_pulse;
EditText sugar;
TextView invalid_sugar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_health_checkup);
        blood_pressure=(EditText) findViewById(R.id.pressure);
        invalid_bp=(TextView) findViewById(R.id.invalid_bp);
        body_temperature=(EditText) findViewById(R.id.tempreture);
        invalid_temp=(TextView) findViewById(R.id.invalid_temp);
        pulse=(EditText) findViewById(R.id.pulse);
        invalid_pulse=(TextView) findViewById(R.id.invalid_pulse);
        sugar=(EditText) findViewById(R.id.sugar);
        invalid_sugar=(TextView) findViewById(R.id.invalid_sugar);
    }

    public void takeappointment(View view) {
        Intent intent = new Intent(health_checkup.this, bookdoctor.class);
        startActivity(intent);
    }
        public void check(View view) {
//        blood_pressure
            String bloodPressureReading = blood_pressure.getText().toString().trim();
            if (isValidBloodPressureFormat(bloodPressureReading)) {
                String[] parts = bloodPressureReading.split("/");
                int systolic = Integer.parseInt(parts[0]);
                int diastolic = Integer.parseInt(parts[1]);
                if(systolic<=110 || diastolic<60){
                    Toast.makeText(health_checkup.this,"Low bp",Toast.LENGTH_SHORT).show();
                } else if (systolic>=125 || diastolic>60) {
                    Toast.makeText(health_checkup.this,"High bp",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(health_checkup.this,"Normal bp",Toast.LENGTH_SHORT).show();
                }

            } else {
                invalid_bp.setText("Please!, Enter the blood pressure in the format xx/xx");
            }
//            blood_pressure

//            body_temperature
                    String temperatureReading = body_temperature.getText().toString().trim();
                    if (isValidTemperatureFormat(temperatureReading)) {
                        double temperature = extractTemperatureValue(temperatureReading);
                        if(temperature>=90){
                            Toast.makeText(health_checkup.this,"High body temperature",Toast.LENGTH_SHORT).show();
                        } else if (temperature<=30)
                        {
                            Toast.makeText(health_checkup.this,"Low body temperature",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(health_checkup.this,"Normal body temperature",Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        invalid_temp.setText("Please!, Enter the body temperature in the format xx'C");
                    }
            //body_temperature

            //pulse Rate
            String pulseRateReading = pulse.getText().toString().trim();
            if (isValidPulseRateFormat(pulseRateReading)) {
                int pulseRate = extractPulseRateValue(pulseRateReading);
                if (pulseRate>100){
                    Toast.makeText(health_checkup.this,"High Pulse Rate",Toast.LENGTH_SHORT).show();
                } else if (pulseRate<60) {
                    Toast.makeText(health_checkup.this,"Low Pulse Rate",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(health_checkup.this,"Normal Pulse Rate",Toast.LENGTH_SHORT).show();
                }
            } else {
                invalid_pulse.setText("Please!, Enter the pulse in the format xx beats per min");
            }
            //pulse Rate

            //sugar
            String sugarLevelReading = sugar.getText().toString().trim();
            if (isValidSugarLevelFormat(sugarLevelReading)) {
                int sugarLevel = extractSugarLevelValue(sugarLevelReading);
                if(sugarLevel>100){
                    Toast.makeText(health_checkup.this,"High Sugar Level",Toast.LENGTH_SHORT).show();
                } else if (sugarLevel<70) {
                    Toast.makeText(health_checkup.this,"Low Sugar Level",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(health_checkup.this,"Normal Sugar Level",Toast.LENGTH_SHORT).show();
                }
            } else {
                invalid_sugar.setText("Please!, Enter the sugar level in the format xx mg/dL");
            }
            //sugar
            }
    //blood pressure
        public static boolean isValidBloodPressureFormat(String reading) {
            String regex = "\\d{2,3}/\\d{2,3}";
            return reading.matches(regex);
        }
    //blood pressure

    //body temperature
    public static boolean isValidTemperatureFormat(String reading) {
        // Regular expression to match the format "XXX 'C" where X represents a digit (0-9).
        String regex = "\\d{2,3} 'C";
        return reading.matches(regex);
    }

    public static double extractTemperatureValue(String reading) {
        // Remove the non-numeric characters and convert to a double value.
        String numericValue = reading.replaceAll("[^0-9.]", "");
        return Double.parseDouble(numericValue);
    }
    //body temperature

    //pulse Rate
    public static boolean isValidPulseRateFormat(String reading) {
        // Regular expression to match the format "XXX beats per minute" where X represents a digit (0-9).
        String regex = "\\d{2,3} beats per minute";
        return reading.matches(regex);
    }

    public static int extractPulseRateValue(String reading) {
        // Remove non-numeric characters and convert to an integer value.
        String numericValue = reading.replaceAll("[^0-9]", "");
        return Integer.parseInt(numericValue);
    }
    //pulse Rate

    //sugar
    public static boolean isValidSugarLevelFormat(String reading) {
        // Regular expression to match the format "XXX mg/dL" where X represents a digit (0-9).
        String regex = "\\d{2,3} mg/dL";
        return reading.matches(regex);
    }

    public static int extractSugarLevelValue(String reading) {
        // Remove non-numeric characters and convert to an integer value.
        String numericValue = reading.replaceAll("[^0-9]", "");
        return Integer.parseInt(numericValue);
    }
    //sugar
}