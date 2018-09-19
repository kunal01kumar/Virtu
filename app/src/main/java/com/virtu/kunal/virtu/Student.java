package com.virtu.kunal.virtu;

public class Student {
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String user_type;

    private String student_name;
    private String class_roll_no;
    private String admission_date;
    private String batch_name;
    //private String date_of_birth;
    private String gender;
    private String blood_group;
    private String student_category;
    private String address_line1;
    //private String address_line2;
    private String city;
    private String state;
    private String pincode;
    private String country;
    private String phone1;
    private String phone2;
    private String biometric_id;
    //private String photo;

    private Fees fee_due;
    private Attendance attendance;

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

    public String getClass_roll_no() {
        return class_roll_no;
    }

    public String getAdmission_date() {
        return admission_date;
    }


    public String getGender() {
        return gender;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public String getStudent_category() {
        return student_category;
    }

    public String getAddress_line1() {
        return address_line1;
    }


    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPincode() {
        return pincode;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone1() {
        return phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getBiometric_id() {
        return biometric_id;
    }
//
//    public String getAdmission_no() {
//        return admission_no;
//    }
//
//    public String getMiddle_name() {
//        return middle_name;
//    }
//
//    public String getBatch() {
//        return batch;
//    }
//
//    public String getDate_of_birth() {
//        return date_of_birth;
//    }
//
//    public String getAddress_line2() {
//        return address_line2;
//    }


}
