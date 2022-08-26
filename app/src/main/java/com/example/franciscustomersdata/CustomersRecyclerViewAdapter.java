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

public class CustomersRecyclerViewAdapter extends RecyclerView.Adapter<CustomersRecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "MyRecyclerViewAdapter";

    //public static String customerFile;


    // list to store customers data to be shown in the recyclerView with the Adapter class
    private ArrayList<Customer> customers = new ArrayList<>();

    // A context for the Glide library
    private final Context context;


    public CustomersRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: called");

        //create and return an instance of the ViewHolder
        View viewCustomer = LayoutInflater.from(parent.getContext()).inflate(R.layout.customer_name, parent, false);
        return new ViewHolder(viewCustomer);
    }


    // Data for the views are set here
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");
        holder.txtCustomerName.setText(customers.get(position).getName());
        //holder.imageData.setImageDrawable(Drawable.createFromPath(customers.get(position).getImageData()));
        // show image with glide library inside the ViewHolder object
        Glide.with(context)
                .asBitmap()
                .load(customers.get(position).getImageData())
                .into(holder.imageData);


    }

    @Override
    public int getItemCount() {
        //return personnelEntries.size();
        return customers.size();
    }

    //Set customers list data to be displayed
    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    // ViewHolder class 1
    public class ViewHolder extends RecyclerView.ViewHolder {


        // Instantiate the Views to be shown
        private final MaterialCardView customerParent;
        private final ImageView imageData;
        private final TextView txtCustomerName;
        private final TextView txtTown;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.d(TAG, "ViewHolder: called");

            customerParent = itemView.findViewById(R.id.customerParent);
            imageData = itemView.findViewById(R.id.imageData);
            txtTown = itemView.findViewById(R.id.txtTown);
            txtCustomerName = itemView.findViewById(R.id.txtCustomerName);

            // Display customer detailed data by view click
            txtCustomerName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String currentDetail = txtCustomerName.getText().toString();
                    Utils.initCustomerDetails(currentDetail, context);
                    Intent intent = new Intent(context, CustomerActivity.class);
                    context.startActivity(intent);


                }
            });
        }
    }


}
