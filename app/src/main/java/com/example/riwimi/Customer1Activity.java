package com.example.riwimi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Customer1Activity extends AppCompatActivity {
private Button RegCus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer1);

        RegCus = findViewById(R.id.Rcus);

        RegCus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Register = new Intent(Customer1Activity.this, Customer2Activity.class);
                startActivity(Register);
            }
        });



    }
}
