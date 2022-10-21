package com.example.aa53_botones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    Toast toast = Toast.makeText(getApplicationContext(), "ToggleButton ON", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    // The toggle is disabled
                    Toast toast = Toast.makeText(getApplicationContext(), "ToggleButton OFF", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
        ToggleButton toggle1 = (ToggleButton) findViewById(R.id.toggleButton);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    Toast toast = Toast.makeText(getApplicationContext(), "ToggleButton ON", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    // The toggle is disabled
                    Toast toast = Toast.makeText(getApplicationContext(), "ToggleButton OFF", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
        ToggleButton toggle2 = (ToggleButton) findViewById(R.id.toggleButton);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    Toast toast = Toast.makeText(getApplicationContext(), "ToggleButton ON", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    // The toggle is disabled
                    Toast toast = Toast.makeText(getApplicationContext(), "ToggleButton OFF", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}