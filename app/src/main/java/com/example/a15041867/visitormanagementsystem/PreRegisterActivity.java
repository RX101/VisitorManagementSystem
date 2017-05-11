package com.example.a15041867.visitormanagementsystem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by 15039840 on 10/5/2017.
 */

public class PreRegisterActivity extends AppCompatActivity{

    EditText etNRIC, etTextName, etNumber, etEmail;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preregister);

        etEmail = (EditText)findViewById(R.id.editTextEmail);
        etNRIC = (EditText)findViewById(R.id.editTextNRIC);
        etNumber = (EditText)findViewById(R.id.editTextPhoneNumber);
        etTextName = (EditText)findViewById(R.id.editTextName);
        btnSubmit = (Button)findViewById(R.id.buttonSubmit);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.action_cancel) {
            return true;
        }
        return false;
    }
}
