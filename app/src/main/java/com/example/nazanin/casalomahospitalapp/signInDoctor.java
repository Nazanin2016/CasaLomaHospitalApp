package com.example.nazanin.casalomahospitalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class signInDoctor extends AppCompatActivity {

        DatabaseHelper helper=new DatabaseHelper(this);


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sign_in_doctor);

        }

        public void onDoctorSignInActivityClick(View v){
            if(v.getId()==R.id.doctorBtnLogIn){

                EditText a=(EditText)findViewById(R.id.doctorUsernameTextEdit);
                String str=a.getText().toString();

                EditText b=(EditText)findViewById(R.id.doctorPasswordTextEdit);
                String pass=b.getText().toString();

                String password=helper.searchPass(str);
                if(pass.equals(password)){

                    Intent i=new Intent(signInDoctor.this, DoctorPatient.class);
                    i.putExtra("Username",str);
                    startActivity(i);
                }

                else{
                    Toast temp= Toast.makeText(signInDoctor.this, "Username and password don't exist. Please register now.!", Toast.LENGTH_SHORT);
                    temp.show();
                }
            }
        }

        public void onRegisterButtonClick(View view)
        {
            Intent registerActivity = new Intent(signInDoctor.this,RegisterDoctor.class);
            startActivity(registerActivity);
        }





    }
