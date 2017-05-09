package com.example.a15041867.visitormanagementsystem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by 15039840 on 10/5/2017.
 */

public class PreRegisterActivity extends AppCompatActivity{

    EditText etNRIC, etTextName, etNumber, etEmail;
    Button btnSubmit, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preregister);

        etEmail = (EditText)findViewById(R.id.editTextEmail);
        etNRIC = (EditText)findViewById(R.id.editTextNRIC);
        etNumber = (EditText)findViewById(R.id.editTextPhoneNumber);
        etTextName = (EditText)findViewById(R.id.editTextName);
        btnCancel = (Button)findViewById(R.id.buttonCancel);
        btnSubmit = (Button)findViewById(R.id.buttonSubmit);
    }
}
