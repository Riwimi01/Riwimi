package com.example.riwimi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.riwimi.ui.driversmap.DriversMapFragment;

public class DriversMapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drivers_map_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, DriversMapFragment.newInstance())
                    .commitNow();
        }
    }
}
