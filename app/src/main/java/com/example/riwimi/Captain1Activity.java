package com.example.riwimi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Captain1Activity extends AppCompatActivity {
private Button RegCap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captain1);

        RegCap =  findViewById(R.id.Rcap);

        RegCap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Register = new Intent(Captain1Activity.this, Captain2Activity.class);
                startActivity(Register);
            }
        });

    }
}
