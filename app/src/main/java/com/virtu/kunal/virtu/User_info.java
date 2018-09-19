package com.virtu.kunal.virtu;

public class User_info {
    private String access_token;
    private String type;
    private String email;
    private String username;
    private String fullname;
    private String refresh_token;

    public User_info(String access_token, String type, String email, String username, String fullname, String refresh_token){
        this.access_token =access_token;
        this.email = email;
        this.fullname = fullname;
        this.refresh_token = refresh_token;
        this.type =type;
        this.username = username;

    }

    public String getAccess_token() {
        return access_token;
    }

    public String getType() {
        return type;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getFullname() {
        return fullname;
    }

    public String getRefresh_token() {
        return refresh_token;
    }
}
