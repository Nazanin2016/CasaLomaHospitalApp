package com.example.nazanin.casalomahospitalapp;

/**
 * Created by Nazanin on 12/6/2017.
 */

public class DoctorContact {

    int id;
    String firstname, lastname, department, username, password, password2;

    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }

    public void setFirstname(String firstname){
        this.firstname= firstname;
    }
    public String getFirstname(){
        return this.firstname;
    }

    public void setLastname(String lastname){
        this.lastname= lastname;
    }
    public String getLastname(){
        return this.lastname;
    }

    public void setDepartment(String department){
        this.department= department;
    }
    public String getDepartment(){
        return this.department;
    }

    public void setUsername(String username){
        this.username= username;
    }
    public String getUsername(){
        return this.username;
    }

    public void setPassword(String password){
        this.password= password;
    }
    public String getPassword(){
        return this.password;
    }

    public void setPassword2(String password2){
        this.password2= password2;
    }
    public String getPassword2(){
        return this.password2;
    }

}

