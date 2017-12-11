package com.example.nazanin.casalomahospitalapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Nazanin on 12/6/2017.
 */


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION= 1;
    private static final String DATABASE_NAME= "contacts.db";

    //tables names
    private static final String TABLE_DOCTOR= "doctors";
    private static final String TABLE_NURSE= "nurses";
    private static final String TABLE_TEST= "tests";
    private static final String TABLE_PATIENT= "patients";

    //doctors table
    private static final String COLUMN_ID= "id";
    private static final String COLUMN_FIRSTNAME= "firstname";
    private static final String COLUMN_LASTNAME= "lastname";
    private static final String COLUMN_DEPARTMENT= "department";
    private static final String COLUMN_USERNAME= "username";
    private static final String COLUMN_PASSWORD= "password";
    private static final String COLUMN_PASSWORD2= "password2";

    //nurses table
    private static final String COLUMN_NID= "nid";
    private static final String COLUMN_NFIRSTNAME= "nfirstname";
    private static final String COLUMN_NLASTNAME= "nlastname";
    private static final String COLUMN_NDEPARTMENT= "ndepartment";
    private static final String COLUMN_NUSERNAME= "nusername";
    private static final String COLUMN_NPASSWORD= "npassword";
    private static final String COLUMN_NPASSWORD2= "npassword2";

    //patient table
    private static final String COLUMN_PID= "pid";
    private static final String COLUMN_PFIRSTNAME= "pfirstname";
    private static final String COLUMN_PLASTNAME= "plastname";
    private static final String COLUMN_PDEPARTMENT= "pdepartment";
    private static final String COLUMN_DOCTORID= "doctorId";
    private static final String COLUMN_ROOM= "room";

    //test table
    private static final String COLUMN_PATIENTID= "pid";
    private static final String COLUMN_TID= "tid";
    private static final String COLUMN_TEMPERATURE= "temperature";
    private static final String COLUMN_BLOODPRESSURE= "bloodPressure";
    private static final String COLUMN_HEARTBEAT= "heartbeat";
    private static final String COLUMN_BPL= "bpl";
    private static final String COLUMN_BPH= "bph";
    private static final String COLUMN_MRI= "mri";

    SQLiteDatabase db;

    //doctor table create statement
    private static final String TABLE_CREATE_DOCTOR= "create table doctors(id integer primary key not null , "+
            "firstname text not null, lastname text not null, department text not null, username text not null, password text not null, password2 text not null)";


    //nurse table create statement
    private static final String TABLE_CREATE_NURSE= "create table nurses(nid integer primary key not null ,"+
            "nfirstname text not null, nlastname text not null, ndepartment text not null, nusername text not null, npassword text not null, npassword2 text not null)";

    //patient table create statement
    private static final String TABLE_CREATE_PATIENT= "create table patients(pid integer primary key not null ,"+
            "pfirstname text not null, plastname text not null, pdepartment text not null, doctorId integer not null, room integer not null)";

    //test table create statement
    private static final String TABLE_CREATE_TEST= "create table tests(tid integer primary key not null ,"+
            "pid integer not null, temperature integer not null, bloodPressure integer not null, heartbeat integer not null, bpl text not null, bph text not null, mri text not null)";




    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLE_CREATE_DOCTOR);
        Log.d("Doctor Table","Created");
        db.execSQL(TABLE_CREATE_NURSE);
        Log.d("Nurse Table","Created");
        db.execSQL(TABLE_CREATE_PATIENT);
        Log.d("Patient Table","Created");
        db.execSQL(TABLE_CREATE_TEST);
        Log.d("Test Table","Created");

        this.db= db;
    }

    //insert doctorcontact to database helper
    public void insertDoctorContact(DoctorContact c){
        db=this.getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMN_FIRSTNAME, c.getFirstname());
        values.put(COLUMN_LASTNAME, c.getLastname());
        values.put(COLUMN_ID, c.getId());
        values.put(COLUMN_DEPARTMENT, c.getDepartment());
        values.put(COLUMN_USERNAME, c.getUsername());
        values.put(COLUMN_PASSWORD, c.getPassword());
        values.put(COLUMN_PASSWORD2, c.getPassword2());

        db. insert(TABLE_DOCTOR, null, values);
        db.close();
    }

    //insert nursecontact to database helper
    public void insertNurseContact(NurseContact c){
        db=this.getReadableDatabase();
        ContentValues nvalues=new ContentValues();
        nvalues.put(COLUMN_NFIRSTNAME, c.getNfirstname());
        nvalues.put(COLUMN_NLASTNAME, c.getNlastname());
        nvalues.put(COLUMN_NID, c.getNid());
        nvalues.put(COLUMN_NDEPARTMENT, c.getNdepartment());
       // Log.d("Nusername",c.getNusername());
        nvalues.put(COLUMN_NUSERNAME, c.getNusername());
        nvalues.put(COLUMN_NPASSWORD, c.getNpassword());
        nvalues.put(COLUMN_NPASSWORD2, c.getNpassword2());

        db. insert(TABLE_NURSE, null, nvalues);
        db.close();
    }


    //insert patientcontact to database helper
    public void insertPatientContact(PatientContact c){
        db=this.getReadableDatabase();
        ContentValues nvalues=new ContentValues();
        nvalues.put(COLUMN_PFIRSTNAME, c.getPfirstname());
        nvalues.put(COLUMN_PLASTNAME, c.getPlastname());
        nvalues.put(COLUMN_PID, c.getPid());
        nvalues.put(COLUMN_PDEPARTMENT, c.getPdepartment());
        nvalues.put(COLUMN_DOCTORID, c.getDoctorId());
        nvalues.put(COLUMN_ROOM, c.getRoom());

        db. insert(TABLE_PATIENT, null, nvalues);
        db.close();
    }

    //insert testcontact to database helper
    public void insertTestContact(TestContact c){
        db=this.getReadableDatabase();
        ContentValues tvalues=new ContentValues();
        tvalues.put(COLUMN_PATIENTID, c.getPid());
        tvalues.put(COLUMN_TID, c.getTid());
        tvalues.put(COLUMN_TEMPERATURE, c.getTemperature());
        tvalues.put(COLUMN_BLOODPRESSURE, c.getBloodpressure());
        tvalues.put(COLUMN_HEARTBEAT, c.getHeartbeat());
        tvalues.put(COLUMN_BPL, c.getBpl());
        tvalues.put(COLUMN_BPH, c.getBph());
        tvalues.put(COLUMN_MRI, c.getMri());

        db. insert(TABLE_TEST, null, tvalues);
        db.close();
    }



    //search pass doctor
    public String searchPass(String username){

        db=this .getReadableDatabase();
        String query="select username, password from "+TABLE_DOCTOR;
        Cursor cursor=db.rawQuery(query, null);
        String a,b;
        b="not found";
        if(cursor.moveToFirst()){
            do{
                a=cursor.getString(0);
                if(a.equals(username)){
                    b=cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;
    }


    //search pass nurse
    public String nsearchPass(String nusername){

        db=this .getReadableDatabase();
        String query1="select nusername, npassword from "+TABLE_NURSE;
        Cursor ncursor=db.rawQuery(query1, null);
        String a,b;
        b="not found";
        if(ncursor.moveToFirst()){
            do{
                a=ncursor.getString(0);
                if(a.equals(nusername)){
                    b=ncursor.getString(1);
                    break;
                }
            }
            while(ncursor.moveToNext());
        }
        return b;
    }


    //search last and first name for patient
    public String psearchLast(String pfirstname){

        db=this .getReadableDatabase();
        String query2="select pfirstname, plastname  from "+TABLE_PATIENT;
        Cursor pcursor=db.rawQuery(query2, null);
        String a,b;
        b="not found";
        if(pcursor.moveToFirst()){
            do{
                a=pcursor.getString(0);
                if(a.equals(pfirstname)){
                    b=pcursor.getString(1);
                    break;
                }
            }
            while(pcursor.moveToNext());
        }
        return b;
    }

    //search details for patient
    public String[] psearchData(String pfirstname, String plastname){

        db=this .getReadableDatabase();
        String query2="select pfirstname, plastname, pid, doctorId, pdepartment, room from "+TABLE_PATIENT;
        Cursor pcursor=db.rawQuery(query2, null);
        String a,b,c;
        String result = "";
        b="not found";
        String[] arreyData= new String[4];
        if(pcursor.moveToFirst()){
            do{
                a=pcursor.getString(0);
                b=pcursor.getString(1);


                if(a.equals(pfirstname) && b.equals(plastname)){

                    arreyData[0] = pcursor.getString(2);
                    arreyData[1] = pcursor.getString(3);
                    arreyData[2] = pcursor.getString(4);
                    arreyData[3] = pcursor.getString(5);
//                    result += "Patient ID : " + pcursor.getString(2);
//                    result += "\nDoctor ID : " + pcursor.getString(3);
//                    result += "\nDepartment : " + pcursor.getString(4);
//                    result += "\nRoom : " + pcursor.getString(5);

                    break;
                }
            }
            while(pcursor.moveToNext());
        }
        return arreyData;
    }

    //search details for test

    public ArrayList<String> tsearchData(String pid){

        db=this.getReadableDatabase();
        String query3="select pid, tid, temperature, bloodPressure, heartbeat, bpl,bph,mri FROM "+TABLE_TEST;
        Cursor tcursor=db.rawQuery(query3, null);


        String a;
        ArrayList<String> result = new ArrayList<>();
        if(tcursor.moveToFirst()){
            do{
                a=tcursor.getString(0);
                if(a.equals(pid)){
                    String data = "";
                    data += "Test ID : " + tcursor.getString(1);
                    data += "\nTemperature : " + tcursor.getString(2);
                    data += "\nHeart Beat : " + tcursor.getString(3);
                    data += "\nBlood presure : " + tcursor.getString(4);
                    data += "\nBPL : " + tcursor.getString(5);
                    data += "\nMRI : " + tcursor.getString(6);
                    data += "\nBPH : " + tcursor.getString(7);

                    result.add(data);
                }
            }
            while(tcursor.moveToNext());
        }
        return result;
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dquery= "DROP TABLE IF EXISTS" + TABLE_DOCTOR;
        String nquery= "DROP TABLE IF EXISTS" + TABLE_NURSE;
        String pquery= "DROP TABLE IF EXISTS" + TABLE_PATIENT;
        String tquery= "DROP TABLE IF EXISTS" + TABLE_TEST;

        db.execSQL(dquery);
        db.execSQL(nquery);
        db.execSQL(pquery);
        db.execSQL(tquery);

        this.onCreate(db);

    }


}


