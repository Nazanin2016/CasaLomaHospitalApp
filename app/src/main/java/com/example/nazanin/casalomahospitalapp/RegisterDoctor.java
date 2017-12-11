package com.example.nazanin.casalomahospitalapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterDoctor extends AppCompatActivity {
    DatabaseHelper helper=new DatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_doctor);
    }



        public void onDoctorRegisterActivityClick(View v){
            if(v.getId()==R.id.doctorBtnLoginRegister){

                EditText firstname= (EditText)findViewById(R.id.doctorFirstnameTextEdit);
                EditText lastname= (EditText)findViewById(R.id.doctorLastnameTextEdit);
                EditText id= (EditText)findViewById(R.id.doctorIdTextEdit);
                EditText department= (EditText)findViewById(R.id.doctorDepartmentTextEdit);
                EditText username= (EditText)findViewById(R.id.doctorUsernameTextEditRegister);
                EditText password= (EditText)findViewById(R.id.doctorPasswordTextEditRegister);
                EditText password2= (EditText)findViewById(R.id.doctorConfPasswordTextEditRegister);

                String firstnamestr= firstname.getText().toString();
                String lastnamestr= lastname.getText().toString();
                String idstr=id.getText().toString();
                String departmentstr= department.getText().toString();
                String usernameestr= username.getText().toString();
                String passwordstr= password.getText().toString();
                String password2str= password2.getText().toString();

                if(! passwordstr.equals(password2str)){
                    //popup message
                    Toast pass= Toast.makeText(RegisterDoctor.this, "Passwords do not match!", Toast.LENGTH_SHORT);
                    pass.show();
                }
                else{
                    //insert the detailes in database
                    DoctorContact c=new DoctorContact();
                    c.setFirstname(firstnamestr);
                    c.setLastname(lastnamestr);
                    c.setId(Integer.parseInt(idstr));
                    c.setDepartment(departmentstr);
                    c.setUsername(usernameestr);
                    c.setPassword(passwordstr);
                    c.setPassword2(password2str);

                    helper.insertDoctorContact(c);
                    onBackPressed();
                }

            }

        }





    }
