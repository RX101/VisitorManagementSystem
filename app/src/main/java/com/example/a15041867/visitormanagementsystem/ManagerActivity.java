package com.example.a15041867.visitormanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManagerActivity extends AppCompatActivity {

    Button btnInfo, btnSummary, btnEvacuation, btnManage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        btnInfo = (Button)findViewById(R.id.btnInfo);
        btnSummary = (Button)findViewById(R.id.btnSummary);
        btnEvacuation = (Button)findViewById(R.id.btnEvacuation);
        btnManage = (Button)findViewById(R.id.btnManage);

        btnInfo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent i = new Intent(ManagerActivity.this, userInfoActivity.class);
                startActivity(i);
            }
        });

        btnSummary.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent i = new Intent(ManagerActivity.this, summaryActivity.class);
                startActivity(i);
            }
        });

        btnEvacuation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent i = new Intent(ManagerActivity.this, evacuationActivity.class);
                startActivity(i);
            }
        });

        btnManage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent i = new Intent(ManagerActivity.this, manageActivity.class);
                startActivity(i);
            }
        });
    }
}
