package com.example.a15041867.visitormanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
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
    DBHelper db;

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
        db = new DBHelper(addActivity.this);

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userNRIC = etUserNRIC.getText().toString();
                String userName = etUserName.getText().toString();
                String strUserPhoneNumber = etUserPhoneNumber.getText().toString();
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
                //Java random passcode generator alphanumeric
                int passwordSize = 10;
                char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
                StringBuilder sb = new StringBuilder();
                Random random = new Random();
                for (int i = 0; i < passwordSize; i++) {
                    char c = chars[random.nextInt(chars.length)];
                    sb.append(c);
                }
                String password = sb.toString();
                if(userNRIC.isEmpty()){
                    etUserNRIC.setError("Please fill up NRIC field.");

                }else if(userNRIC.length() != 9){
                    etUserNRIC.setError("Invalid, Please try again");
                }else if(userName.isEmpty()){
                    etUserName.setError("Please fill up Name field.");
                }else if(strUserPhoneNumber.isEmpty()) {
                    etUserPhoneNumber.setError("Please fill up Phone Number field.");
                }else if(strUserPhoneNumber.length() != 8 ){
                    etUserPhoneNumber.setError("Invalid Phone Number, please try again.");
                }else if(userEmail.isEmpty()){
                        etUserEmail.setError("Please fill up Email field.");
                }else if(!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()){
                    etUserEmail.setError("Invalid Email, Please try again.");
                }else if(userUnitNo.isEmpty()){
                    etUserUnitNo.setError("Please fill up Unit No.");
                }else {
                    int registerPhoneNumber = Integer.parseInt(strUserPhoneNumber);
                    if(db.insertUser(userNRIC,userName,password,registerPhoneNumber,userEmail,userUnitNo,selectedPosition)){
                        Toast.makeText(addActivity.this,"User Added Successful",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(addActivity.this,"User Added failed",Toast.LENGTH_SHORT).show();
                    }
                    db.close();

                    //use finish()
                    finish();
                    //use onResume()
                }

                    // Create the DBHelper object, passing in the
                // activity's Context


            }
        });
    }
}
