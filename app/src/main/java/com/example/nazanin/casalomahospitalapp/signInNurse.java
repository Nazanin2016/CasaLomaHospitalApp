package com.example.nazanin.casalomahospitalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class signInNurse extends AppCompatActivity {

    DatabaseHelper nhelper=new DatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_nurse
        );

    }


        public void onNurseSignInActivityClick(View v){
            if(v.getId()==R.id.nurseBtnLogIn){

                EditText a=(EditText)findViewById(R.id.nurseUsernameTextEdit);
                String str=a.getText().toString();

                EditText b=(EditText)findViewById(R.id.nursePasswordTextEdit);
                String pass=b.getText().toString();


                String password=nhelper.nsearchPass(str);
                if(pass.equals(password)){

                    Intent i=new Intent(signInNurse.this, NursePatient.class);
                    i.putExtra("Nusername",str);

                    startActivity(i);
                }

                else{
                    Toast temp= Toast.makeText(signInNurse.this, "Username and password don't exist. Please register now.!", Toast.LENGTH_SHORT);
                    temp.show();
                }
            }
        }

        public void onRegisterButtonClick(View view)
        {
            Intent registerActivity = new Intent(signInNurse.this,RegisterNurse.class);
            startActivity(registerActivity);
        }

    }
