package com.example.franciscustomersdata;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;



public class SelectedTownActivity extends AppCompatActivity {
    private RecyclerView selectedTownRecyclerView;
    private SelectedTownRecyclerViewAdapter selectedTownAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_town);


        //instantiate the recyclerView and it adapter to show list of towns
        selectedTownRecyclerView = findViewById(R.id.selectedTownRecyclerView);
        selectedTownAdapter = new SelectedTownRecyclerViewAdapter(this/*context for the adapter*/);
        selectedTownRecyclerView.setAdapter(selectedTownAdapter);

        //set layout type
        selectedTownRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        //set towns data
        ArrayList<Customer> townCustomers = Utils.getTownCustomers();
        if (null != townCustomers) {
            selectedTownAdapter.setSelectedTownCustomers(townCustomers);// data is set inside the adapter class then is displayed in the recyclerView in a list form

        }

    }
}