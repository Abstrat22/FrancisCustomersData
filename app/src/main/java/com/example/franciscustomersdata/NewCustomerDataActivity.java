package com.example.franciscustomersdata;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;



public class NewCustomerDataActivity extends AppCompatActivity {

    //fields for views
    private EditText edtTxtTown, edtTxtName, edtTxtContact, edtTxtStreetAddress, edtTxtOtherNames,
            edtTxtPartner, edtTxtMother, edtTxtFather;
    private CheckBox chkBoxMarried, chkBoxSingle;
    private Button btnNext;

    // data fields
    private String name, town, contact, address, otherNames, partner, mother, father, customerData;
    private static String dataFilesPath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_customer_data);
        dataFilesPath = this.getFilesDir().getPath();

        initViews();
        // get path of files
        //filePath = getFilesDir();


        // set OnclickListener for btnSave
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDataFiles();



            }
        });


    }

    // Create customer data files
    private void createDataFiles() {
        // set data for use
        name = edtTxtName.getText().toString();
        town = edtTxtTown.getText().toString();
        contact = edtTxtContact.getText().toString();
        address = edtTxtStreetAddress.getText().toString();
        otherNames = edtTxtOtherNames.getText().toString();
        partner = edtTxtPartner.getText().toString();
        mother = edtTxtMother.getText().toString();
        father = edtTxtFather.getText().toString();

        customerData = "Name: " + name + "\n" + "Town: " + town + "\n" + "Contact: " + contact + "\n" + "Address: " + address + "\n" + "Other Names: " + otherNames + "\n" +
                "Partner: " + partner + "\n" + "Mother: " + mother + "\n" + "Father: " + father;

        //set up data with method calls
        townCustomerNamesFile(name);
        customerDataFile(customerData);
        townsDataFile(town);
        allCustomerNamesFile(name);

        // Capture and save picture with intent
        Intent intent = new Intent(NewCustomerDataActivity.this, CustomerImageCaptureActivity.class);
        // send string data to intent
        intent.putExtra("name", name);
        startActivity(intent);
        emptyViewsFields();

    }

    //Create customerNamesFile to store list of customer names for a particular town
    private void townCustomerNamesFile(String name) {
        this.name = name;
        FileOutputStream townCustomerNamesOutputStream = null;

        try {
            File file = new File(dataFilesPath + town + ".txt");
            if (file.exists()) {
                name = "\n" + name;
                townCustomerNamesOutputStream = openFileOutput(town + ".txt", Context.MODE_APPEND);
            } else {
                townCustomerNamesOutputStream = openFileOutput(town + ".txt", Context.MODE_PRIVATE);

            }
            townCustomerNamesOutputStream.write(name.getBytes());


        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                townCustomerNamesOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



     // Create townsDataFile to store list of towns
    private void townsDataFile(String town) {
        this.town = town;

        FileOutputStream townsOutputStream = null;
        try {
            File file = new File(dataFilesPath+"/Towns.txt");
            if (file.exists()) {
                town = "\n" + town;
                townsOutputStream = openFileOutput("Towns.txt", Context.MODE_APPEND);

            } else {
                townsOutputStream = openFileOutput("Towns.txt", Context.MODE_PRIVATE); //MODE PRIVATE
            }
            townsOutputStream.write(town.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                townsOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



    //  Create customerDataFile to store customer data

    private void customerDataFile(String customerData) {
        this.customerData = customerData;

        FileOutputStream customerDataOutputStream = null;
        File file = new File(dataFilesPath + name + ".txt");
        try {
            if (file.exists()) {
                customerDataOutputStream = openFileOutput(name + ".txt", Context.MODE_APPEND); //MODE APPEND

            } else {
                customerDataOutputStream = openFileOutput(name + ".txt", Context.MODE_PRIVATE); //MODE PRIVATE
            }
            customerDataOutputStream.write(customerData.getBytes());



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                customerDataOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    //Create customerDataFile to store customer data

    private void allCustomerNamesFile(String name) {
        this.name = name;

        FileOutputStream allCustomerNamesOutputStream = null;
        File file = new File(dataFilesPath+"/Customers.txt");
        try {
            if (file.exists()) {
                name = "\n" + name;
                allCustomerNamesOutputStream = openFileOutput("Customers.txt", Context.MODE_APPEND); //MODE APPEND

            } else {
                allCustomerNamesOutputStream = openFileOutput("Customers.txt", Context.MODE_PRIVATE); //MODE PRIVATE
            }
            allCustomerNamesOutputStream.write(name.getBytes());



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                allCustomerNamesOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



     //Empty fields
    private void emptyViewsFields() {
        edtTxtName.setText("");
        edtTxtTown.setText("");
        edtTxtContact.setText("");
        edtTxtOtherNames.setText("");
        edtTxtMother.setText("");
        edtTxtPartner.setText("");
        edtTxtStreetAddress.setText("");
        edtTxtFather.setText("");
    }


     //Initialize Views
    private void initViews() {
        edtTxtName = findViewById(R.id.edtTxtName);
        edtTxtTown = findViewById(R.id.edtTxtTown);
        edtTxtContact = findViewById(R.id.edtTxtContact);
        edtTxtStreetAddress = findViewById(R.id.edtTxtStreetAddress);
        edtTxtOtherNames = findViewById(R.id.edtTxtOtherNames);
        edtTxtPartner = findViewById(R.id.edtTxtPartner);
        edtTxtMother = findViewById(R.id.edtTxtMother);
        edtTxtFather = findViewById(R.id.edtTxtFather);
        chkBoxMarried = findViewById(R.id.chkBoxMarried);
        chkBoxSingle = findViewById(R.id.chkBoxSingle);
        btnNext = findViewById(R.id.btnNext);
    }
}