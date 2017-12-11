package com.example.nazanin.casalomahospitalapp;

/**
 * Created by Nazanin on 12/7/2017.
 */

public class TestContact {

    int tid, pid, temperature, bloodpressure, heartbeat ;
    String bpl, bph, mri;

    public void setTid(int tid){
        this.tid=tid;
    }
    public int getTid(){
        return this.tid;
    }

    public void setPid(int pid){
        this.pid= pid;
    }
    public int getPid(){
        return this.pid;
    }

    public void setTemperature(int temperature){
        this.temperature= temperature;
    }
    public int getTemperature(){
        return this.temperature;
    }

    public void setBloodpressure(int bloodpressure){
        this.bloodpressure= bloodpressure;
    }
    public int getBloodpressure(){
        return this.bloodpressure;
    }

    public void setHeartbeat(int heartbeat){
        this.heartbeat= heartbeat;
    }
    public int getHeartbeat(){
        return this.heartbeat;
    }

    public void setBpl(String bpl){
        this.bpl= bpl;
    }
    public String getBpl(){
        return this.bpl;
    }

    public void setBph(String bph){
        this.bph= bph;
    }
    public String getBph(){
        return this.bph;
    }

    public void setMri(String mri){
        this.mri= mri;
    }
    public String getMri(){
        return this.mri;
    }




}

