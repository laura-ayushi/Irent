package com.example.irent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Thankyouresponse extends AppCompatActivity {
     Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyouresponse);
        button2 =(Button)findViewById(R.id.next);

        button2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                openfinishpage();
            }
        });
    }

    private void openfinishpage() {
        Intent intent =new Intent(this,Finish.class);
        startActivity(intent);
    }


}