package com.example.nazanin.casalomahospitalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class CasaLomaHospitalapp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casa_loma_hospitalapp);
        final RadioButton doctor= (RadioButton)findViewById(R.id.rdbDoctor);
        final RadioButton nurse= (RadioButton)findViewById(R.id.rdbNurse);

        final Button enter=(Button)findViewById(R.id.btnEnter);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(doctor.isChecked()){
                    Intent intent=new Intent(CasaLomaHospitalapp.this, signInDoctor.class);
                    startActivity(intent);
                }
                else if(nurse.isChecked()){
                    Intent intents=new Intent(CasaLomaHospitalapp.this, signInNurse.class);
                    startActivity(intents);
                }
            }
        });
    }
}


