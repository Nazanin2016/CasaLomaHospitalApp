package com.example.nazanin.casalomahospitalapp;

/**
 * Created by Nazanin on 12/6/2017.
 */

public class NurseContact {



    int nid;
    String nfirstname, nlastname, ndepartment, nusername, npassword, npassword2;

    public void setNid(int nid){
        this.nid=nid;
    }
    public int getNid(){
        return this.nid;
    }

    public void setNfirstname(String nfirstname){
        this.nfirstname= nfirstname;
    }
    public String getNfirstname(){
        return this.nfirstname;
    }

    public void setNlastname(String nlastname){
        this.nlastname= nlastname;
    }
    public String getNlastname(){
        return this.nlastname;
    }

    public void setNdepartment(String ndepartment){
        this.ndepartment= ndepartment;
    }
    public String getNdepartment(){
        return this.ndepartment;
    }

    public void setNusername(String nusername){
        this.nusername= nusername;
    }
    public String getNusername(){
        return this.nusername;
    }

    public void setNpassword(String npassword){
        this.npassword= npassword;
    }
    public String getNpassword(){
        return this.npassword;
    }

    public void setNpassword2(String npassword2){
        this.npassword2= npassword2;
    }
    public String getNpassword2(){
        return this.npassword2;
    }

}
