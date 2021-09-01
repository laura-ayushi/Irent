package com.example.irent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {
    private Button button1;
    public EditText signupUsername;
    public EditText signupPassword;
    public EditText signupyourNames;
    public EditText signupphoneNumber;
    public EditText signupemailAddress;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        button1 = (Button) findViewById(R.id.button1);
        signupUsername = (EditText)findViewById(R.id.username);
        signupPassword = (EditText)findViewById(R.id.pass);
        signupyourNames= (EditText)findViewById(R.id.yournames);
        signupphoneNumber= (EditText)findViewById(R.id.phonenumber);
        signupemailAddress = (EditText)findViewById(R.id.emailaddress);

        button1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                openDashboard();
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");

                String username= signupUsername.getText().toString();
                String password = signupPassword.getText().toString();
                String yourNames= signupyourNames.getText().toString();
                String phoneNumber = signupphoneNumber.getText().toString();
                String emailAddress= signupemailAddress.getText().toString();

                UserHelperClass helperClass = new UserHelperClass(username,yourNames,phoneNumber,emailAddress,password);
                reference.child(phoneNumber).setValue(helperClass);
            }
        });
    }

    private void openDashboard(){
        Intent intent =new Intent(this,Dashboard.class);
        startActivity(intent);
    }
}