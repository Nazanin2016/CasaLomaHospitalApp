package com.example.nazanin.casalomahospitalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NursePatient extends AppCompatActivity {

    DatabaseHelper phelper=new DatabaseHelper(this);


            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_nurse_patient);

                //we want to get the username from the nurse activity previous
                //we've passed it with i.putExtra("Username",str);

                // String nusername = (String)getIntent().getExtras().get("Nusername");
                // Toast.makeText(this, nusername, Toast.LENGTH_SHORT).show();

                TextView welcome=(TextView)findViewById(R.id.nurseWelcomeTextView);
                String nusername = (String)getIntent().getStringExtra("Nusername");
                welcome.setText("Welcome "+ nusername);
            }


    public void onNursePatientActivityClick(View v){
        if(v.getId()==R.id.nursePatientSearchBtn){

            EditText a=(EditText)findViewById(R.id.nursePatientFirstnameEditText);
            String str=a.getText().toString();

            EditText b=(EditText)findViewById(R.id.nursePatientLastnameEditText);
            String last=b.getText().toString();


            String lastname=phelper.psearchLast(str);
            if(last.equals(lastname)){

                Intent i=new Intent(NursePatient.this, PatientSearchResult.class);
                i.putExtra("Pfirstname",str);
                i.putExtra("Plastname",last);

                startActivity(i);


            }

            else{
                Toast temp= Toast.makeText(NursePatient.this, "Firstname and lastname don't exist in database. Please Add a new patient now.!", Toast.LENGTH_SHORT);
                temp.show();
            }


        }
    }

    public void onAddButtonClick(View view)
    {
        Intent AddActivity = new Intent(NursePatient.this,PatientAdd.class);
        startActivity(AddActivity);
    }




}
