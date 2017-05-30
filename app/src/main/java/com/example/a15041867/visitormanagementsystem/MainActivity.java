package com.example.a15041867.visitormanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    EditText etLoginNRIC, etLoginPassword;
    DBHelper db;
    private Session session;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin =(Button)findViewById(R.id.buttonLogin);
        etLoginNRIC = (EditText)findViewById(R.id.editTextloginNRIC);
        etLoginPassword = (EditText)findViewById(R.id.editTextloginPassword);
//        session = new Session(this);
        db = new DBHelper(MainActivity.this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loginNRIC = etLoginNRIC.getText().toString();
                String loginPassword = etLoginPassword.getText().toString();

                if(db.checkLoginUser(loginNRIC,loginPassword)){

                        String position = db.getUserPosition(loginNRIC);
                        if (position.equals("Host")) {
                            i = new Intent(MainActivity.this, PreRegisterActivity.class);
                            startActivity(i);
//                            session.setLoggedin(true);
                        } else if (position.equals("Manager")) {
                            i = new Intent(MainActivity.this, ManagerActivity.class);
                            startActivity(i);
//                            session.setLoggedin(true);
                        } else if (position.equals("Security Staff")) {
                            i = new Intent(MainActivity.this, SignInActivity.class);
                            startActivity(i);
//                            session.setLoggedin(true);
                        } else {
                            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
                        }

                }else if(loginNRIC.isEmpty()){
                    etLoginNRIC.setError("NRIC field is empty");
                }
                else if(loginNRIC.length() > 9){
                    etLoginNRIC.setError("Maximum NRIC character is 9, Please try again.");
                } else if(loginPassword.isEmpty()){
                    etLoginNRIC.setError("Password field is empty");
                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong email/password",Toast.LENGTH_SHORT).show();
                }

//               if(session.loggedin()) {
//                    startActivity(i);
//                    finish();
//
//                }

            }
        });
    db.close();

    }

}
