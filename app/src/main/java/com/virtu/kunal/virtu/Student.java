package com.virtu.kunal.virtu;

public class Student {
    String username;
    String firstname;
    String lastname;
    String email;
    String user_type;

    public Student(String username, String firstname, String lastname, String email, String user_type) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.user_type = user_type;
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
}
