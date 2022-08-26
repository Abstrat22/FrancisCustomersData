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

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class SelectedTownRecyclerViewAdapter extends RecyclerView.Adapter<SelectedTownRecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "TownRecyclerViewAdapter";

    // list to store towns data to be shown in the recyclerView with the Adapter class
    private ArrayList<Customer> selectedTownCustomers = new ArrayList<>();


    // A context for the Glide library
    private final Context context;



    public SelectedTownRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: called");

        //create and return an instance of the ViewHolder
        View viewTown = LayoutInflater.from(parent.getContext()).inflate(R.layout.customer_name, parent, false);
        return new ViewHolder(viewTown);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");
        holder.txtSelectedTownCustomers.setText(selectedTownCustomers.get(position).getName());
        // show image
        //holder.imageData.setImageDrawable(Drawable.createFromPath(selectedTownCustomers.get(position).getImageData()));
        // show image with glide library inside the ViewHolder object
        Glide.with(context)
                .asBitmap()
                .load(selectedTownCustomers.get(position).getImageData())
                .into(holder.imageData);

    }

    @Override
    public int getItemCount() {
        return selectedTownCustomers.size();
    }

    //Set towns list data to be displayed
    public void setSelectedTownCustomers(ArrayList<Customer> selectedTownCustomers) {
        this.selectedTownCustomers = selectedTownCustomers;
    }

    // ViewHolder class 1
    public class ViewHolder extends RecyclerView.ViewHolder {


        // Fields for the Views
        private final MaterialCardView selectedTownCustomersParent;
        private final TextView txtSelectedTownCustomers;
        private final ImageView imageData;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.d(TAG, "ViewHolder: called");

            // Instantiate the Views to be shown
            selectedTownCustomersParent = itemView.findViewById(R.id.customerParent);
            txtSelectedTownCustomers = itemView.findViewById(R.id.txtCustomerName);
            imageData = itemView.findViewById(R.id.imageData);

            // Display customer detailed data by view click
            txtSelectedTownCustomers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String currentDetail = txtSelectedTownCustomers.getText().toString();
                    Utils.initCustomerDetails(currentDetail, context);
                    Intent intent = new Intent(context, CustomerActivity.class);
                    context.startActivity(intent);

                }
            });
        }
    }

}

