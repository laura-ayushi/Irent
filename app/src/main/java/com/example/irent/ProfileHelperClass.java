package com.example.irent;

public class ProfileHelperClass {
    String fullName,emailAddress;

    public ProfileHelperClass(){

    }

    public ProfileHelperClass(String fullName, String emailAddress) {
        this.fullName = fullName;
        this.emailAddress = emailAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
