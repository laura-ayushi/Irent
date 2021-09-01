package com.example.irent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Logout extends AppCompatActivity {
    private Button logoutbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        logoutbutton = (Button) findViewById(R.id.cancel);

        logoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlogin();
            }
        });
    }

    private void openlogin() {
        Intent intent =new Intent(this,Login.class);
        startActivity(intent);
    }
}