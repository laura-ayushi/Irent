package com.example.irent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FeedbackForm extends AppCompatActivity {

    private Button button;
    private EditText namess;
    public EditText email;
    public EditText feedbackpart;
    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_form);

        button = (Button)findViewById(R.id.btn);
        namess = (EditText)findViewById(R.id.yournames);
        email = (EditText) findViewById(R.id.email_address);
        feedbackpart = (EditText) findViewById(R.id.feedback);

        button.setOnClickListener(new View.OnClickListener() {


        @Override
        public void onClick(View v) {
            openThankyouResponse();
            rootNode = FirebaseDatabase.getInstance();
            reference = rootNode.getReference("feedback");

            String names= namess.getText().toString();
            String emailaddress = email.getText().toString();
            String feedback = feedbackpart.getText().toString();
            FeedbackHelperClass feedbackHelperClass = new FeedbackHelperClass(names,emailaddress,feedback);
            reference.setValue(feedbackHelperClass);
        }
       });
    }

    private void openThankyouResponse() {

    Intent intent =new Intent(this,Thankyouresponse.class);
    startActivity(intent);
    }
}


