package com.example.coffe_novin.myapplication;

import java.lang.reflect.Constructor;

public class Contact {
    private  String name;
    private  String phoneNumber;


    public  Contact (String Name , String PhoneNumber ){
       this.name=Name;
        this.phoneNumber=PhoneNumber;

    }

        public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
