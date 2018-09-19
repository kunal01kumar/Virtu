package com.virtu.kunal.virtu;

import java.util.Arrays;

public class Employee {
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String user_type;
    private String[] privilages;

    public Employee(String username, String firstname, String lastname, String email, String user_type, String[] privilages) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.user_type = user_type;
        this.privilages = privilages;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getUser_type() {
        return user_type;
    }

    public String[] getPrivilages() {
        return privilages;
    }

    public boolean hasPivilage(String privilage){
        if(Arrays.asList(privilages).contains(privilage)) return true;
        return false;
    }
}
