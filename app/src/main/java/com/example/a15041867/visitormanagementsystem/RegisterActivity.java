package com.example.a15041867.visitormanagementsystem;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.PatternMatcher;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    EditText etRegisterName, etRegisterNRIC, etRegisterHP, etRegisterEmail;
    Button btnRegister;
    DBHelper db;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etRegisterEmail = (EditText)findViewById(R.id.editTextRegisterEmail);
        etRegisterNRIC = (EditText)findViewById(R.id.editTextRegisterNRIC);
        etRegisterHP = (EditText)findViewById(R.id.editTextRegisterHP);
        etRegisterName = (EditText)findViewById(R.id.editTextRegisterName);
        btnRegister = (Button)findViewById(R.id.buttonRegister);
        db = new DBHelper(RegisterActivity.this);

        session = new Session(this);
//        if(!session.loggedin()){
//            logout();
//        }

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String registerNRIC = etRegisterNRIC.getText().toString();
                final String registerName = etRegisterName.getText().toString();
                final String strRegisterHP = etRegisterHP.getText().toString();
                final String registerEmail = etRegisterEmail.getText().toString();

                if (registerNRIC.isEmpty()) {
                    etRegisterNRIC.setError(" Please fill up NRIC field.");
                }else if(registerNRIC.length() != 9){
                    etRegisterNRIC.setError("Invalid NRIC, Please try again.");
                } else if (registerName.isEmpty()) {
                    etRegisterName.setError("Please fill up Name field.");
                } else if (strRegisterHP.isEmpty()) {
                    etRegisterHP.setError("Please fill up Handphone field.");
                }else if(strRegisterHP.length() != 8){
                    etRegisterHP.setError("Invalid Handphone number, Please try again.");
                }else if(registerEmail.isEmpty()){
                    etRegisterEmail.setError("Please fill up Email field.");
                }else if(!Patterns.EMAIL_ADDRESS.matcher(registerEmail).matches()){
                    etRegisterEmail.setError("Invalid Email, Please try again.");
                }else {
                    //Create the Dialog Builder
                    AlertDialog.Builder myBuilder = new AlertDialog.Builder(RegisterActivity.this);
                    //Set the dialog details
                    myBuilder.setTitle("Confirmation register visitor:");
                    myBuilder.setMessage("Are you sure to add " + registerNRIC + " into database ?");
                    myBuilder.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            final int registerHP = Integer.parseInt(strRegisterHP);
                            if(db.insertVisitor(registerNRIC, registerName, registerHP, registerEmail)){
                                Toast.makeText(RegisterActivity.this,"User Added Successful",Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(RegisterActivity.this,"User Added failed",Toast.LENGTH_SHORT).show();
                            }
                            db.close();
                            finish();

                        }
                    });
                    myBuilder.setNeutralButton("Cancel", null);
                    //Create and display the Dialog
                    AlertDialog myDialog = myBuilder.create();
                    myDialog.show();
                }


            }
        });


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.action_register_logout) {
            logout();
        }
        return false;
    }
    private void logout(){
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(RegisterActivity.this,MainActivity.class));
    }
}
