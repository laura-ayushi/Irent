package com.example.irent;

public class UserHelperClass {
    String username,yourNames,phoneNumber,emailAddress,password;

    public UserHelperClass(){

    }

    public UserHelperClass(String username, String yourNames, String phoneNumber, String emailAddress, String password) {
        this.username = username;
        this.yourNames = yourNames;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.password = password;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getYourNames() {
        return yourNames;
    }

    public void setYourNames(String yourNames) {
        this.yourNames = yourNames;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    }
