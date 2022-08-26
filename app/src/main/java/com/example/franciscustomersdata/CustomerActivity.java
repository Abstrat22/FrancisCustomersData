package com.example.franciscustomersdata;

import static com.example.franciscustomersdata.Utils.theCustomer;


import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;


public class CustomerActivity extends AppCompatActivity {
    private static TextView txtName, txtTown, txtContact, txtAddress, txtOtherNames, txtPartner, txtFather,
            txtMother;
    public static ImageView imgCustomer;
    //private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        initViews();
        updateDetail();



    }

    // set customer details
    private void updateDetail() {
        //show image with glide library inside the ViewHolder object
        //Log.d("ThePath", theCustomer.getFather()+"");
        Glide.with(this)
                .asBitmap()
                .load(theCustomer.getImageData())
                .into(imgCustomer);

        txtName.setText(theCustomer.getName());
        Log.d("CustomerActivity", txtName.getText().toString());
        txtTown.setText(theCustomer.getTown());
        txtContact.setText(theCustomer.getContact());
        txtAddress.setText(theCustomer.getAddress());
        txtOtherNames.setText(theCustomer.getOtherNames());
        txtPartner.setText(theCustomer.getPartner());
        txtMother.setText(theCustomer.getMother());
        txtFather.setText(theCustomer.getFather());


    }


    // initialize views
    private void initViews() {
        txtName = findViewById(R.id.txtName);
        txtTown = findViewById(R.id.txtTown);
        txtContact = findViewById(R.id.txtContact);
        txtAddress = findViewById(R.id.txtAddress);
        txtOtherNames = findViewById(R.id.txtOtherNames);
        txtPartner = findViewById(R.id.txtPartner);
        txtFather = findViewById(R.id.txtFather);
        txtMother = findViewById(R.id.txtMother);
        imgCustomer = findViewById(R.id.imgCustomer);


    }
}