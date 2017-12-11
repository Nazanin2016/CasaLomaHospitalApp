package com.example.nazanin.casalomahospitalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class TestFinalResult extends AppCompatActivity {
    DatabaseHelper thelper=new DatabaseHelper(this);


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_test_final_result);

            TextView testResult=(TextView)findViewById(R.id.testResultTextView);
            Button button = (Button) findViewById(R.id.button);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(TestFinalResult.this, CasaLomaHospitalapp.class);
                    startActivity(intent);
                }

            });

            String pid= getIntent().getStringExtra("Pid");

            ArrayList<String> data=thelper.tsearchData(pid);

            testResult.setText("Patient ID:"+pid+"\n"+data);
        }
    }

