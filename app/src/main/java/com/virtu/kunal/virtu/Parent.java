package com.virtu.kunal.virtu;

public class Parent {
    String username;
    String firstname;
    String lastname;
    String email;
    String user_type;
    String[] wards;

    public Parent(String username, String firstname, String lastname, String email, String user_type, String[] wards) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.user_type = user_type;
        this.wards = wards;
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

    public String[] getWards() {
        return wards;
    }
}
