package com.example.franciscustomersdata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;




public class MainActivity extends AppCompatActivity {
    private Button btnAddCustomer, btnTowns, btnCustomers;
    private ImageView customerImage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initialize Views data
        initViews();


        btnAddCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewCustomerDataActivity.class);
                startActivity(intent);
            }
        });

        btnTowns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //empty data field
                Utils.emptyList();
                //Initialize towns data
                Utils.initTowns();

                Intent intent = new Intent(MainActivity.this, TownsActivity.class);
                startActivity(intent);
            }
        });

        btnCustomers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //empty data field
                Utils.emptyList();
                //Initialize customers data
                Utils.initAllCustomers(MainActivity.this);
                Intent intent = new Intent(MainActivity.this, CustomersActivity.class);
                startActivity(intent);
            }
        });


    }


    private void initViews() {
        // Initialize Views
        btnAddCustomer = findViewById(R.id.btnAddCustomer);
        btnTowns = findViewById(R.id.btnTowns);
        btnCustomers = findViewById(R.id.btnCustomers);
        customerImage = findViewById(R.id.imageData);

    }
}