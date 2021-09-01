package com.example.irent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Rentdetails extends AppCompatActivity {
   ImageView placeImage;
    TextView placeName,countryName,price;

   // DatabaseReference reference;
     Button feedbackbtn;
     Button call;
     ImageView google;
     ImageView feedbackpage;
     ImageView home;
     ImageView profiles;
    // creating object of ViewPager
    //ViewPager mViewPager;

    // images array
    //int[] images = {R.drawable.studiotwo, R.drawable.studiotwo, R.drawable.studiothree};

    // Creating Object of ViewPagerAdapter
    //ViewpagerAdapter mViewPagerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rentdetails);


        // Initializing the ViewPager Object
        //mViewPager = (ViewPager)findViewById(R.id.viewPagerMain);


        feedbackpage= (ImageView) findViewById(R.id.feedbackicon);
        home= (ImageView) findViewById(R.id.homeicon);
        profiles= (ImageView) findViewById(R.id.profilepageicon);
        placeImage = (ImageView) findViewById(R.id.houseimage);
        placeName = (TextView) findViewById(R.id.placename);
        countryName = (TextView) findViewById(R.id.countryname);
        price = (TextView) findViewById(R.id.price);
        call= (Button) findViewById(R.id.callus);
        google =(ImageView)findViewById(R.id.googlemaps);
        feedbackbtn =(Button)findViewById(R.id.feedbackbutton);

        // Initializing the ViewpagerAdapter
        //mViewPagerAdapter = new ViewpagerAdapter(Rentdetails.this, images);


        // Adding the Adapter to the ViewPager
        //mViewPager.setAdapter(mViewPagerAdapter);


        //Intent i = getIntent();
        //String placename = i.getStringExtra("placename");
        //placeName.setText(placename);

        feedbackbtn.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick (View v){

                openfeedbackPage();
            }
        });

        feedbackpage.setOnClickListener(new View.OnClickListener(){


        @Override
        public void onClick (View v){

        openfeedbackPage();
        }
    });

        home.setOnClickListener(new View.OnClickListener()

    {


        @Override
        public void onClick (View v){

        openhomePage();
    }
    });

        profiles.setOnClickListener(new View.OnClickListener()

    {


        @Override
        public void onClick (View v){

        openprofilePage();
    }
    });

}



    private void openfeedbackPage() {
        Intent intent =new Intent(this,FeedbackForm.class);
        startActivity(intent);
    }

    private void openhomePage() {
        Intent intent =new Intent(this,HomePage.class);
        startActivity(intent);
    }

    private void openprofilePage() {
        Intent intent =new Intent(this,Profile.class);
        startActivity(intent);
    }

    public void openLocation(View view) {
         //Get the string indicating a location. Input is not validated; it is
         //passed to the location handler intact.

        //String loc = google.getText().toString();

        //Parse the location and create the intent.
        Uri addressUri = Uri.parse("geo:0,0?q=" );
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        // Find an activity to handle the intent, and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void dialphone(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0720526719"));
        startActivity(intent);

    }


}

