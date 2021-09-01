package com.example.irent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomePage extends AppCompatActivity {

    RecyclerView availableHousesRecycler;
    AvailableHousesAdapter availableHousesAdapter;
    //static List<AvailableHousesModel> availableHousesDataList;
    TextView placeName;
    TextView homesAvailable;
    ImageView feedbackpage;
    ImageView home;
    ImageView profiles;
    private Object AvailableHousesViewHolder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        feedbackpage= (ImageView) findViewById(R.id.feedbackicon);
        home= (ImageView) findViewById(R.id.homeicon);
        profiles= (ImageView) findViewById(R.id.profilepageicon);
        homesAvailable= (TextView)findViewById(R.id.textavailablehomes);
        availableHousesRecycler=(RecyclerView)findViewById(R.id.top_places_recycler);
        availableHousesRecycler.setLayoutManager(new LinearLayoutManager(this));

        DatabaseReference mdbase = FirebaseDatabase.getInstance().getReference().child("houses");

        FirebaseRecyclerOptions<AvailableHousesModel> options =
                new FirebaseRecyclerOptions.Builder<AvailableHousesModel>()
                        .setQuery(mdbase,AvailableHousesModel.class)
                        .build();

        availableHousesAdapter = new AvailableHousesAdapter(options);
        availableHousesRecycler.setAdapter(availableHousesAdapter);



        /**List<AvailableHousesModel> availableHousesDataList = new ArrayList<>();
        availableHousesDataList.add(new AvailableHousesModel("Studio Apartment in Roysambu","Roysambu,Nairobi","Kshs.9,000 per month",R.drawable.studione));
        availableHousesDataList.add(new AvailableHousesModel("1.3 bdrm Bungalow in Kamulu ","Kamulu,Nairobi","Kshs.35,000 per month",R.drawable.kamuluone));
        availableHousesDataList.add(new AvailableHousesModel("1 bdrm Apartment in Utawala ","Utawala,Nairobi","Kshs.10,000 per month",R.drawable.utawalaone));
        availableHousesDataList.add(new AvailableHousesModel("Studio Apartment in Tassia","Embakasi,Nairobi","Kshs.9,000 per month",R.drawable.embakasione));
        availableHousesDataList.add(new AvailableHousesModel("2 bdrm Apartment in South C","South C,Nairobi","Kshs.25,000 per month",R.drawable.southctwojpg));

        setAvailableHousesRecycler(availableHousesDataList);**/


        homesAvailable.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                openAvailableHomes();
            }
        });

        feedbackpage.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                openfeedbackPage();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                openhomePage();
            }
        });

        profiles.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                openprofilePage();
            }
        });



    }






    /**private  void setAvailableHousesRecycler(List<AvailableHousesModel> availableHousesDataList){

        availableHousesRecycler = findViewById(R.id.top_places_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        availableHousesRecycler.setLayoutManager(layoutManager);
        availableHousesAdapter = new AvailableHousesAdapter(this,availableHousesDataList);
        availableHousesRecycler.setAdapter(availableHousesAdapter);

    }**/


   /** @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search,menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                txtSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                txtSearch(query);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
     private void txtSearch(String str){

        DatabaseReference dbasee = FirebaseDatabase.getInstance().getReference().child("houses");

         FirebaseRecyclerOptions<AvailableHousesModel> options =
                 new FirebaseRecyclerOptions.Builder<AvailableHousesModel>()
                         .setQuery(dbasee.orderByChild("countryName").startAt(str).endAt(str+"~"),AvailableHousesModel.class)
                         .build();

         availableHousesAdapter = new AvailableHousesAdapter(options);
         availableHousesAdapter.startListening();
         availableHousesRecycler.setAdapter(availableHousesAdapter);**/


    protected void onStart() {
        super.onStart();
        availableHousesAdapter.startListening();
    }

    protected void onStop() {
        super.onStop();
        availableHousesAdapter.stopListening();
    }

    private void openprofilePage() {
        Intent intent =new Intent(this,Profile.class);
        startActivity(intent);
    }

    private void openhomePage() {
        Intent intent =new Intent(this,HomePage.class);
        startActivity(intent);
    }

    private void openfeedbackPage() {
        Intent intent =new Intent(this,FeedbackForm.class);
        startActivity(intent);
    }

    private void openAvailableHomes() {
        Intent intent = new Intent(this, AvailableHouses.class);
        startActivity(intent);
    }


}




