package com.example.franciscustomersdata;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class TownsRecyclerViewAdapter extends RecyclerView.Adapter<TownsRecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "TownRecyclerViewAdapter";


    // list to store towns data to be shown in the recyclerView with the Adapter class
    private ArrayList<Town> towns = new ArrayList<>();


    // A context for the Glide library
    private final Context context;


    public TownsRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: called");

        //create and return an instance of the ViewHolder
        View viewTown = LayoutInflater.from(parent.getContext()).inflate(R.layout.town_name, parent, false);
        return new ViewHolder(viewTown);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");
        holder.txtTown.setText(towns.get(position).getTownName());


    }

    @Override
    public int getItemCount() {
        return towns.size();
    }

    //Set towns list data to be displayed
    public void setTowns(ArrayList<Town> towns) {
        this.towns = towns;
    }

    // ViewHolder class 1
    public class ViewHolder extends RecyclerView.ViewHolder {


        // Instantiate the Views to be shown
        private final MaterialCardView townParent;
        private final MaterialCardView customerParent;
        private final ImageView imageData;
        private final TextView txtTown;
        private final TextView txtCustomerName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.d(TAG, "ViewHolder: called");

            townParent = itemView.findViewById(R.id.townParent);
            customerParent = itemView.findViewById(R.id.customerParent);
            imageData = itemView.findViewById(R.id.imageData);
            txtTown = itemView.findViewById(R.id.txtTown);
            txtCustomerName = itemView.findViewById(R.id.txtCustomerName);

            //set onclick a listener for when a town is selected
            // Display customers in the selected town
            txtTown.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //empty data field
                    Utils.emptyList();
                    String currentTown = txtTown.getText().toString();
                    //Initialize town customers data
                    Utils.initTownCustomers(currentTown, context);
                    Intent intent = new Intent(context, SelectedTownActivity.class);
                    context.startActivity(intent);

                }
            });
        }
    }

}

