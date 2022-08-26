package com.example.franciscustomersdata;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomersActivity extends AppCompatActivity {
    private RecyclerView customersRecyclerView;
    private CustomersRecyclerViewAdapter customersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers);

        //instantiate the recyclerView and it adapter to show list of towns
        customersRecyclerView = findViewById(R.id.customersRecyclerView);
        customersAdapter = new CustomersRecyclerViewAdapter(this/*context for the adapter*/);
        customersRecyclerView.setAdapter(customersAdapter);

        //set layout type
        customersRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        //customersRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //set towns data
        ArrayList<Customer> customers = Utils.getAllCustomers();
        if (null != customers) {
            customersAdapter.setCustomers(customers);// data is set inside the adapter class then is displayed in the recyclerView in a list form

        }


    }
}