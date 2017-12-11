package com.example.nazanin.casalomahospitalapp;

/**
 * Created by Nazanin on 12/6/2017.
 */

public class PatientContact {


    int pid, doctorId, room;
    String pfirstname, plastname, pdepartment;

    public void setPid(int pid){
        this.pid=pid;
    }
    public int getPid(){
        return this.pid;
    }

    public void setDoctorId(int doctorId){
        this.doctorId= doctorId;
    }
    public int getDoctorId(){
        return this.doctorId;
    }

    public void setRoom(int room){
        this.room= room;
    }
    public int getRoom(){
        return this.room;
    }

    public void setPfirstname(String pfirstname){
        this.pfirstname= pfirstname;
    }
    public String getPfirstname(){
        return this.pfirstname;
    }

    public void setPlastname(String plastname){
        this.plastname= plastname;
    }
    public String getPlastname(){
        return this.plastname;
    }

    public void setPdepartment(String pdepartment){
        this.pdepartment= pdepartment;
    }
    public String getPdepartment(){
        return this.pdepartment;
    }



}
