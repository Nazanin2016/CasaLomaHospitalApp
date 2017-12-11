package com.example.nazanin.casalomahospitalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PatientTest extends AppCompatActivity {
    DatabaseHelper thelper = new DatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_test);
    }


        public void onPatientTestFormActivityClick(View v){
            if(v.getId()==R.id.submitBtn){

                EditText tid= (EditText)findViewById(R.id.testIdEditText);
                EditText temperature= (EditText)findViewById(R.id.temperatureEditText);
                EditText bloodpressure= (EditText)findViewById(R.id.bloodpressure);
                EditText heartbeat= (EditText)findViewById(R.id.heartbeetEditText);
                EditText bpl= (EditText)findViewById(R.id.bplEditText);
                EditText bph= (EditText)findViewById(R.id.bphEditText);
                EditText mri= (EditText)findViewById(R.id.mriEditText);

                String pidstr= getIntent().getExtras().getString("Pid");
                String tidstr= tid.getText().toString();
                String temperaturestr= temperature.getText().toString();
                String bloodpressurestr=bloodpressure.getText().toString();
                String heartbeatstr= heartbeat.getText().toString();
                String bplstr= bpl.getText().toString();
                String bphstr= bph.getText().toString();
                String mristr= mri.getText().toString();


                //insert the detailes in database

                TestContact c=new TestContact();
                c.setPid(Integer.parseInt(pidstr));
                c.setTid(Integer.parseInt(tidstr));
                c.setTemperature(Integer.parseInt(temperaturestr));
                c.setBloodpressure(Integer.parseInt(bloodpressurestr));
                c.setHeartbeat(Integer.parseInt(heartbeatstr));;
                c.setBpl(bplstr);
                c.setBph(bphstr);
                c.setMri(mristr);

                thelper.insertTestContact(c);


                Intent i=new Intent(PatientTest.this, TestFinalResult.class);
                i.putExtra("Pid",pidstr);

                startActivity(i);



            }

        }




    }





