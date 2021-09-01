package com.example.irent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Profile extends AppCompatActivity {
    private Button profilebutton;
    public EditText fullname;
    public EditText  emails;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profilebutton = (Button)findViewById(R.id.profilebuttonclickone);
        fullname = (EditText)findViewById(R.id.full_name);
        emails = (EditText) findViewById(R.id.settings_address);
        profilebutton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                openUpdateprofile();
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("profiles");

                String fullName = fullname.getText().toString();
                String emailAddress = emails.getText().toString();
                ProfileHelperClass profileHelperClass = new ProfileHelperClass(fullName,emailAddress);
                reference.setValue(profileHelperClass);
            }
        });
    }

    private void openUpdateprofile() {
        Intent intent =new Intent(this,Updateprofile.class);
        startActivity(intent);
    }

}
