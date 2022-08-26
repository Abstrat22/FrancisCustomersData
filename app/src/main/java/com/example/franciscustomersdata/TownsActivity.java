package com.example.franciscustomersdata;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TownsActivity extends AppCompatActivity {
    public static RecyclerView townsRecyclerView;
    private TownsRecyclerViewAdapter townsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_towns);
        //readTownsData();
        //Toast.makeText(this, readTownsData(), Toast.LENGTH_LONG).show();


        //instantiate the recyclerView and it adapter to show list of towns
        townsRecyclerView = findViewById(R.id.townsRecyclerView);
        townsAdapter = new TownsRecyclerViewAdapter(this/*context for the adapter*/);
        townsRecyclerView.setAdapter(townsAdapter);

        //set layout type
        townsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //set towns data
        ArrayList<Town> towns = Utils.getTowns();
        if (null != towns) {
            townsAdapter.setTowns(towns);// data is set inside the adapter class then is displayed in the recyclerView in a list form

        }
    }
}


