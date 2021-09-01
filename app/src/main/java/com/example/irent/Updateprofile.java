package com.example.irent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class Updateprofile extends AppCompatActivity {
    private Button profilebuttonone;
    public EditText fullname;
    public EditText  emails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateprofile);

        profilebuttonone = (Button)findViewById(R.id.profilebuttonclick);
        fullname = (EditText)findViewById(R.id.full_name);
        emails = (EditText) findViewById(R.id.settings_address);
        profilebuttonone.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                openProfiles();
            }
        });
    }
    private void openProfiles() {

        Intent intent =new Intent(this,Profile.class);
        startActivity(intent);
    }
}

