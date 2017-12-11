package com.example.nazanin.casalomahospitalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class PatientSearchResult extends AppCompatActivity {

    DatabaseHelper phelper=new DatabaseHelper(this);
    String[] pdetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_search_result);




            TextView patientResult=(TextView)findViewById(R.id.patientResultTextView);
            String pfirstname = (String)getIntent().getStringExtra("Pfirstname");
            String plastname = (String)getIntent().getStringExtra("Plastname");

            pdetails = phelper.psearchData(pfirstname,plastname);

            String data = "Patient Id : " + pdetails[0];
            data += "\nDepartment : " + pdetails[1];
            data += "\nDoctor ID: " + pdetails[2];
            data += "\nRoom : " + pdetails[3];



            patientResult.setText("Firstname: "+pfirstname+"\n\n "+"Lastname: "+plastname + "\n" + data);

        }


    public void onPatientTestBtnClick(View view)
    {
        Intent registerActivity = new Intent(PatientSearchResult.this,PatientTest.class);
        registerActivity.putExtra("Pid",pdetails[0]);

        startActivity(registerActivity);
    }


}
