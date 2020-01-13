package com.example.riwimi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button cap;
    private Button cus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cap= findViewById(R.id.captain);
        cus= findViewById(R.id.customer);

        cap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Captain = new Intent( MainActivity.this, Captain1Activity.class);
                startActivity(Captain);
            }
        });

        cus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Customer = new Intent(MainActivity.this, Customer1Activity.class);
                startActivity(Customer);
            }
        });

    }


}
