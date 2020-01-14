package com.example.riwimi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Captain1Activity extends AppCompatActivity {
    private Button Driverlogin;
    private Button Driverregister;
    private TextView Driverregisterlink;
    private TextView Driverstatus;
    private EditText EmailDriver;
    private EditText PasswordDriver;
    private FirebaseAuth mAuth;
    private ProgressDialog LoadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captain1);
        mAuth= FirebaseAuth.getInstance();

        Driverlogin= findViewById(R.id.Driver_Login_btn);
        Driverregister= findViewById(R.id.DriverRegBtn);
        Driverregisterlink= findViewById(R.id.AskDriver);
        Driverstatus= findViewById(R.id.DriverLogin);
        EmailDriver= findViewById(R.id.Driver_Email);
        PasswordDriver= findViewById(R.id.Driver_Password);

        LoadingBar= new ProgressDialog(this);

        Driverregister.setVisibility(View.INVISIBLE);
        Driverregister.setEnabled(false);

        Driverregisterlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Driverlogin.setVisibility(View.INVISIBLE);
                Driverregisterlink.setVisibility(View.INVISIBLE);
                Driverstatus.setText("Register Captain:");

                Driverregister.setVisibility(View.VISIBLE);
                Driverregister.setEnabled(true);

            }
        });

        Driverregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Email= EmailDriver.getText().toString();
                String Password= PasswordDriver.getText().toString();

                RegisterDriver(Email, Password);


            }
        });

        Driverlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String Email= EmailDriver.getText().toString();
                String Password= PasswordDriver.getText().toString();

                LoginDriver(Email, Password);

            }
        });

    }

    private void LoginDriver(String email, String password)
    {
        if(TextUtils.isEmpty(email))
            Toast.makeText(Captain1Activity.this, "Please fill up your Email....",Toast.LENGTH_SHORT).show();

        if(TextUtils.isEmpty(password))
            Toast.makeText(Captain1Activity.this, "Please fill up your Password....",Toast.LENGTH_SHORT).show();
        else
            LoadingBar.setTitle("Driver");
        LoadingBar.setMessage("Please wait, while system is checking your credentials");
        LoadingBar.show();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(Captain1Activity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            LoadingBar.dismiss();

                            Intent driverintent= new Intent(Captain1Activity.this, DriversMapActivity.class);
                            startActivity(driverintent);
                        }

                        else {
                            Toast.makeText(Captain1Activity.this, "Login Unsuccessful", Toast.LENGTH_SHORT).show();
                            LoadingBar.dismiss();
                        }
                    }
                });


    }

    private void RegisterDriver(String email, String password) {
        if(TextUtils.isEmpty(email))
            Toast.makeText(Captain1Activity.this, "Please fill up your Email....",Toast.LENGTH_SHORT).show();

        if(TextUtils.isEmpty(password))
            Toast.makeText(Captain1Activity.this, "Please fill up your Password....",Toast.LENGTH_SHORT).show();
        else
            LoadingBar.setTitle("Driver");
        LoadingBar.setMessage("Please wait, while system is registering your data");
        LoadingBar.show();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(Captain1Activity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                            LoadingBar.dismiss();
                        }

                        else {
                            Toast.makeText(Captain1Activity.this, "Registration Unsuccessful", Toast.LENGTH_SHORT).show();
                            LoadingBar.dismiss();
                        }
                    }
                });


    }
}
