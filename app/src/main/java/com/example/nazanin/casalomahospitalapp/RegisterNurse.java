package com.example.nazanin.casalomahospitalapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterNurse extends AppCompatActivity {
    DatabaseHelper nhelper=new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_nurse);
    }

    public void onNurseRegisterActivityClick(View v){
        if(v.getId()==R.id.nurseBtnLoginRegister){

            EditText nfirstname= (EditText)findViewById(R.id.nurseFirstnameTextEdit);
            EditText nlastname= (EditText)findViewById(R.id.nurseLastnameTextEdit);
            EditText nid= (EditText)findViewById(R.id.nurseIdTextEdit);
            EditText ndepartment= (EditText)findViewById(R.id.nurseDepartmentTextEdit);
            EditText nusername= (EditText)findViewById(R.id.nurseUsernameTextEditRegister);
            EditText npassword= (EditText)findViewById(R.id.nursePasswordTextEditRegister);
            EditText npassword2= (EditText)findViewById(R.id.nurseConfPasswordTextEditRegister);

            String firstnamestr= nfirstname.getText().toString();
            String lastnamestr= nlastname.getText().toString();
            String idstr=nid.getText().toString();
            String departmentstr= ndepartment.getText().toString();
            String usernameestr= nusername.getText().toString();
            String passwordstr= npassword.getText().toString();
            String password2str= npassword2.getText().toString();

            if(! passwordstr.equals(password2str)){
                //popup message
                Toast npass= Toast.makeText(RegisterNurse.this, "Passwords do not match!", Toast.LENGTH_SHORT);
                npass.show();
            }
            else{
                //insert the detailes in database
                NurseContact c=new NurseContact();
                c.setNfirstname(firstnamestr);
                c.setNlastname(lastnamestr);
                c.setNid(Integer.parseInt(idstr));
                c.setNdepartment(departmentstr);
                c.setNusername(usernameestr);
                c.setNpassword(passwordstr);
                c.setNpassword2(password2str);

                nhelper.insertNurseContact(c);
                onBackPressed();
            }

        }

    }






}
