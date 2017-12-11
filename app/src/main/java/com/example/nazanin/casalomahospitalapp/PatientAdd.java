package com.example.nazanin.casalomahospitalapp;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class PatientAdd extends AppCompatActivity {
    DatabaseHelper phelper=new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_add);
    }




        public void onPatientAddActivityClick(View v){

            if(v.getId()==R.id.patientBtnAddIt){


                EditText pfirstname= (EditText)findViewById(R.id.patientFirstnameEditText);
                EditText plastname= (EditText)findViewById(R.id.patientLastnameEditText);
                EditText pid= (EditText)findViewById(R.id.patientIdEditText);
                EditText pdepartment= (EditText)findViewById(R.id.patientDepartmentEditText);
                EditText doctorId= (EditText)findViewById(R.id.patientdoctoridEditText);
                EditText room= (EditText)findViewById(R.id.patientRoomEditText);


                String firstnamestr= pfirstname.getText().toString();
                String lastnamestr= plastname.getText().toString();
                String idstr=pid.getText().toString();
                String departmentstr= pdepartment.getText().toString();
                String doctoridstr= doctorId.getText().toString();
                String roomstr= room.getText().toString();




                if(lastnamestr.isEmpty()){
                    //popup message
                    Toast plast= Toast.makeText(PatientAdd.this, "Lastname is empty", Toast.LENGTH_SHORT);
                    plast.show();
                }
                else{
                    //insert the detailes in database
                    PatientContact c=new PatientContact();
                    c.setPfirstname(firstnamestr);
                    c.setPlastname(lastnamestr);
                    c.setPid(Integer.parseInt(idstr));
                    c.setPdepartment(departmentstr);
                    c.setDoctorId(Integer.parseInt(doctoridstr));
                    c.setRoom(Integer.parseInt(roomstr));

                    phelper.insertPatientContact(c);
                    onBackPressed();
                }



            }

        }



    }
