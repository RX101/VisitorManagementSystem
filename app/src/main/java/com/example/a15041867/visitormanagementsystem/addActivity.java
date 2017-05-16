package com.example.a15041867.visitormanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Random;

public class addActivity extends AppCompatActivity {
    EditText etUserNRIC, etUserName, etUserEmail, etUserPhoneNumber, etUserUnitNo;
    Button btnAddUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etUserNRIC = (EditText)findViewById(R.id.editTextUserNRIC);
        etUserName = (EditText)findViewById(R.id.editTextUserName);
        etUserEmail = (EditText)findViewById(R.id.editTextUserEmail);
        etUserPhoneNumber = (EditText)findViewById(R.id.editTextUserPN);
        etUserUnitNo = (EditText)findViewById(R.id.editTextUserUnitNo);
        btnAddUser = (Button)findViewById(R.id.buttonAddUser);

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userNRIC = etUserNRIC.getText().toString();
                String userName = etUserName.getText().toString();
                String strUserPhoneNumber = etUserPhoneNumber.getText().toString();
                int registerPhoneNumber = Integer.parseInt(strUserPhoneNumber);
                String userEmail = etUserEmail.getText().toString();
                String userUnitNo = etUserUnitNo.getText().toString();
                // Get the RadioGroup object
                RadioGroup rgPosition = (RadioGroup) findViewById(R.id.radioGroup);
                // Get the Id of the selected radio button in the RadioGroup
                int selectedButtonId = rgPosition.getCheckedRadioButtonId();
                // Get the radio button object from the Id we had gotten above
                RadioButton rb = (RadioButton) findViewById(selectedButtonId);
                String selectedPosition = rb.getText().toString();
                Random rand = new Random();
                Integer n = rand.nextInt(89999999)+ 10000000;
                String password = n.toString();

                    // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(addActivity.this);
                db.insertUser(userNRIC,userName,password,registerPhoneNumber,userEmail,userUnitNo,selectedPosition);
                db.close();
                Toast.makeText(addActivity.this,"User Added Successful",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(addActivity.this,MainActivity.class));
            }
        });
    }
}
