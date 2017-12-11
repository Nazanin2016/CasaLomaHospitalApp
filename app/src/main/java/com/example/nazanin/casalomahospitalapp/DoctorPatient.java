package com.example.nazanin.casalomahospitalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DoctorPatient extends AppCompatActivity {

    DatabaseHelper phelper=new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_patient);





                TextView welcome=(TextView)findViewById(R.id.doctorWelcomeTextView);
                String username = (String)getIntent().getStringExtra("Username");
                welcome.setText("Welcome "+ username);

            }


            public void onDoctorPatientActivityClick(View v){
                if(v.getId()==R.id.doctorPatientSearchBtn){

                    EditText a=(EditText)findViewById(R.id.doctorPatientFirstnameEditText);
                    String str=a.getText().toString();

                    EditText b=(EditText)findViewById(R.id.doctorPatientLastnameEditText);
                    String last=b.getText().toString();


                    String lastname=phelper.psearchLast(str);
                    if(last.equals(lastname)){

                        Intent i=new Intent(DoctorPatient.this, PatientSearchResult.class);
                        i.putExtra("Pfirstname",str);
                        i.putExtra("Plastname",last);

                        startActivity(i);


                    }

                    else{
                        Toast temp= Toast.makeText(DoctorPatient.this, "Firstname and lastname don't exist in database. Please Add a new patient now.!", Toast.LENGTH_SHORT);
                        temp.show();
                    }


                }
            }

            public void onAddButtonClick(View view)
            {
                Intent AddActivity = new Intent(DoctorPatient.this,PatientAdd.class);
                startActivity(AddActivity);
            }

        }