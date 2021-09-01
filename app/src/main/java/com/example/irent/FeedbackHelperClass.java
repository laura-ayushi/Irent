package com.example.irent;

public class FeedbackHelperClass {
    String names,emailaddress,feedback;

    public FeedbackHelperClass(){

    }

    public FeedbackHelperClass(String names, String emailaddress, String feedback) {
        this.names = names;
        this.emailaddress = emailaddress;
        this.feedback = feedback;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
