package com.example.healthcare;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

public class CustomDialog extends Dialog {
    private TextView etBloodPressure, etBodyTemperature, etPulseRate, etSugarLevel;
    private TextView sBloodPressure, sBodyTemperature, sPulseRate, sSugarLevel;

    public CustomDialog(Context context) {
        super(context);
        setContentView(R.layout.checker_dialog);

        etBloodPressure = findViewById(R.id.etBloodPressure);
        etBodyTemperature = findViewById(R.id.etBodyTemperature);
        etPulseRate = findViewById(R.id.etPulseRate);
        etSugarLevel = findViewById(R.id.etSugarLevel);

        sBloodPressure=findViewById(R.id.sbp);
        sBodyTemperature=findViewById(R.id.stemp);
        sPulseRate=findViewById(R.id.spulse);
        sSugarLevel=findViewById(R.id.ssugar);
    }

    public void setParameters(String bloodPressure, String bodyTemperature, String pulseRate, String sugarLevel) {
        etBloodPressure.setText(bloodPressure);
        etBodyTemperature.setText(bodyTemperature);
        etPulseRate.setText(pulseRate);
        etSugarLevel.setText(sugarLevel);
    }

    public void setstatus(String sbloodPressure, String sbodyTemperature, String spulseRate, String ssugarLevel){
        sBloodPressure.setText(sbloodPressure);
        sBodyTemperature.setText(sbodyTemperature);
        sPulseRate.setText(spulseRate);
        sSugarLevel.setText(ssugarLevel);
    }

}