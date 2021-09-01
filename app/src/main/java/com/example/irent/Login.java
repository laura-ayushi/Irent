package com.example.irent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {
    private Button button;
    private TextView register;
    private TextView forgotpassword;
    public EditText loginMail;
    public EditText loginPassword;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button = (Button) findViewById(R.id.button);
        register =(TextView) findViewById(R.id.register);
        forgotpassword =(TextView) findViewById(R.id.forgotpassword);
        loginMail = (EditText)findViewById(R.id.mail);
        loginPassword = (EditText)findViewById(R.id.password);

        register.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                openSignup();
            }
        });

        forgotpassword.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                openForgotpassword();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    openDashboard();
                    rootNode = FirebaseDatabase.getInstance();
                    reference = rootNode.getReference("users");

                    String emailAddress= loginMail.getText().toString();
                    String password = loginPassword.getText().toString();
                    String yourNames = null;
                    String phoneNumber= null;
                    String username= null;
                    UserHelperClass helperClass = new UserHelperClass(username,yourNames,phoneNumber,emailAddress,password);
                    reference.setValue(helperClass);
                }
        });
    }

    private void openSignup() {
        Intent intent =new Intent(this,SignupActivity.class);
        startActivity(intent);
    }

    private void openDashboard(){
       Intent intent =new Intent(this,Dashboard.class);
       startActivity(intent);
    }

    private void openForgotpassword() {
        Intent intent =new Intent(this,ForgotPassword.class);
        startActivity(intent);
    }
}
