package com.example.a15041867.visitormanagementsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText etRegisterName, etRegisterNRIC, etRegisterHP, etRegisterEmail;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etRegisterEmail = (EditText)findViewById(R.id.editTextRegisterEmail);
        etRegisterNRIC = (EditText)findViewById(R.id.editTextRegisterNRIC);
        etRegisterHP = (EditText)findViewById(R.id.editTextRegisterHP);
        etRegisterName = (EditText)findViewById(R.id.editTextRegisterName);
        btnRegister = (Button)findViewById(R.id.buttonRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}
