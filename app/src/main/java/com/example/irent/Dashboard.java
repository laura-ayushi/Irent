package com.example.irent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class Dashboard extends AppCompatActivity {
    private CardView cardviewrenthouse;
    private CardView cardviewvirtualassistant;
    private CardView cardviewavailablerentals;
    private CardView cardviewlogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        cardviewrenthouse = (CardView)findViewById(R.id.renthouse);
        cardviewvirtualassistant = (CardView)findViewById(R.id.virtualassistant);
        cardviewlogout =(CardView)findViewById(R.id.logout);
        cardviewavailablerentals =(CardView)findViewById(R.id.selectedrentals);


        cardviewrenthouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openHomepage();
            }
        });

        cardviewvirtualassistant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openHomepage();
            }
        });

        cardviewlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogout();
            }
        });

        cardviewavailablerentals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openavailableRentals();;
            }
        });


    }

    private void openavailableRentals() {
        Intent intent =new Intent(this,AvailableHouses.class);
        startActivity(intent);
    }

    private void openLogout() {
        Intent intent =new Intent(this,Logout.class);
        startActivity(intent);
    }

    private void openHomepage(){
        Intent intent =new Intent(this,HomePage.class);
        startActivity(intent);
    }
}