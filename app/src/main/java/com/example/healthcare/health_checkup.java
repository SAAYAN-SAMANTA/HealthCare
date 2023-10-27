package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class health_checkup extends AppCompatActivity {
    double temperatures;
    int pulses,sugars;
    int checkerbp=0,checkertemp=0,checkerpulse=0,checkersugar=0;
    String statusbp,statustemp,statuspulse,statussugar;
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
                    checkerbp=1;
                    statusbp="Low";
                } else if (systolic>=125 || diastolic>60) {
                    checkerbp=1;
                    statusbp="High";
                }else {
                    checkerbp=1;
                   statusbp="Normal";
                }

            } else {
                invalid_bp.setText("Please!, Enter the blood pressure in the format xx/xx");
            }
//            blood_pressure

//            body_temperature
                    String temperatureReading = body_temperature.getText().toString().trim();
                    if (isValidTemperatureFormat(temperatureReading)) {
                        double temperature = extractTemperatureValue(temperatureReading);
                        temperatures=temperature;
                        if(temperature>=90){
                            checkertemp=1;
                            statustemp="High";
                        } else if (temperature<=30)
                        {
                            checkertemp=1;
                            statustemp="Low";
                        }
                        else {
                            checkertemp=1;
                            statustemp="Normal";
                        }
                    } else {
                        invalid_temp.setText("Please!, Enter the body temperature in the format xx 'C");
                    }
            //body_temperature

            //pulse Rate
            String pulseRateReading = pulse.getText().toString().trim();
            if (isValidPulseRateFormat(pulseRateReading)) {
                int pulseRate = extractPulseRateValue(pulseRateReading);
                pulses=pulseRate;
                if (pulseRate>100){
                    checkerpulse=1;
                    statuspulse="High";
                } else if (pulseRate<60) {
                    checkerpulse=1;
                    statuspulse="Low";
                } else {
                    checkerpulse=1;
                    statuspulse="Normal";
                }
            } else {
                invalid_pulse.setText("Please!, Enter the pulse in the format xx beats per min");
            }
            //pulse Rate

            //sugar
            String sugarLevelReading = sugar.getText().toString().trim();
            if (isValidSugarLevelFormat(sugarLevelReading)) {
                int sugarLevel = extractSugarLevelValue(sugarLevelReading);
                sugars=sugarLevel;
                if(sugarLevel>100){
                    checkersugar=1;
                    statussugar="High";
                } else if (sugarLevel<70) {
                    checkersugar=1;
                    statussugar="Low";
                } else {
                    checkersugar=1;
                    statussugar="Normal";
                }
            } else {
                invalid_sugar.setText("Please!, Enter the sugar level in the format xx mg/dL");
            }
            //sugar
            if(checkerbp==1&&checkertemp==1&&checkerpulse==1&&checkersugar==1) {
                CustomDialog customDialog = new CustomDialog(this);
                String temp = Double.toString(temperatures);
                String pulse = Integer.toString(pulses);
                String sugar = Integer.toString(sugars);
                customDialog.setParameters(bloodPressureReading, temp, pulse, sugar);
                customDialog.setstatus(statusbp,statustemp,statuspulse,statussugar);
                customDialog.show();
            }
            }

            public void doctor(View view){
                Intent intent = new Intent(health_checkup.this, bookdoctor.class);
                startActivity(intent);
            }

            public void medicine(View view){
                Intent intent = new Intent(health_checkup.this, Prescribed_Medicines.class);
                startActivity(intent);
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
        String regex = "\\d{2,3} beats per min";
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
