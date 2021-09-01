package com.example.irent;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.jetbrains.annotations.NotNull;

//public class AvailableHousesAdapter extends RecyclerView.Adapter<AvailableHousesAdapter.AvailableHousesViewHolder> {
  public class AvailableHousesAdapter extends FirebaseRecyclerAdapter<AvailableHousesModel,AvailableHousesAdapter.AvailableHousesViewHolder>{
   // private static  List<AvailableHousesModel> availableHousesDataList;
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public AvailableHousesAdapter(@NotNull FirebaseRecyclerOptions<AvailableHousesModel> options) {
        super(options);
    }


    /**public AvailableHousesAdapter(Context context, List<AvailableHousesModel> availableHousesDataList) {
        this.context = context;
        this.availableHousesDataList = availableHousesDataList;

    }**/



    @NonNull
    @Override
    public AvailableHousesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_availablehomes,parent,false);

        //View view = LayoutInflater.from(context).inflate(R.layout.activity_availablehomes, parent, false);

        // here we create a recyclerview row item layout file
        return new AvailableHousesViewHolder(view);
    }


    /**public void onBindViewHolder(@NonNull AvailableHousesViewHolder holder, int position,AvailableHousesModel model) {
        holder.countryName.setText(availableHousesDataList.get(position).getCountryName());
        holder.placeName.setText(availableHousesDataList.get(position).getPlaceName());
        holder.price.setText(availableHousesDataList.get(position).getPrice());
        holder.placeImage.setImageResource(availableHousesDataList.get(position).getImageUrl());
    }

    @Override
    public int getItemCount() {
        return availableHousesDataList.size();
    }**/

    @Override
    protected void onBindViewHolder(@NonNull @NotNull AvailableHousesViewHolder holder, int position, @NonNull @NotNull AvailableHousesModel model) {
       holder.placeName.setText(model.getPlaceName());
       holder.countryName.setText(model.getCountryName());
       holder.price.setText(model.getPrice());
       Glide.with(holder.placeImage.getContext()).load(model.getImageUrl()).into(holder.placeImage);

    }

    public  final class AvailableHousesViewHolder extends RecyclerView.ViewHolder{


        ImageView placeImage;
        TextView placeName, countryName, price;


        public AvailableHousesViewHolder(@NonNull View itemView) {
            super(itemView);
            int position = 0;
            placeImage = itemView.findViewById(R.id.place_image);
            placeName = itemView.findViewById(R.id.place_name);
            countryName = itemView.findViewById(R.id.country_name);
            price = itemView.findViewById(R.id.price);

            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(),Rentdetails.class);
                    v.getContext().startActivity(intent);

                }
            });


      }
    }

  }




