package com.example.franciscustomersdata;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// Configures data for Persons
public class Utils {

    // theCustomer field to set customer details data
    public static Customer theCustomer;
    private static ArrayList<Town> towns;
    //All customers data
    private static ArrayList<Customer> allCustomers;
    // customers for a particular town data
    private static ArrayList<Customer> townCustomers;

    public static String customerImagePath;



    // Initialize towns data
    public static void initTowns() {

        if (null == towns) {
            towns = new ArrayList<>();
        }

        // get and set list of towns from Towns data file

        File file = new File("/data/data/com.example.franciscustomersdata/files/Towns.txt");// open for reading

        try {

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                String duplicate ="";

                while ((line = br.readLine()) != null) {
                    if (!duplicate.contains(line)){
                        Town town = new Town(line);
                        towns.add(town);
                        duplicate = line;

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Return towns data entries
    public static ArrayList<Town> getTowns() {
        return towns;
    }







    // Initialize customers data
    public static void initAllCustomers(Context context) {
        Context theContext = context;
        customerImagePath = theContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES).toString()+"/";



        if (null == allCustomers) {
            allCustomers = new ArrayList<>();
        } // get and set list of customers from Customers data file

        File file = new File("/data/data/com.example.franciscustomersdata/files/Customers.txt");
        try {

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    Customer customer = new Customer(line, customerImagePath+line+".jpg");
                    allCustomers.add(customer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //loadCustomerImage(customerImagePath, image);

    }

    // Return customers data entries
    public static ArrayList<Customer> getAllCustomers() {
        return allCustomers;
    }


    // Initialize particular town customers data
    public static void initTownCustomers(String town, Context context) {
        Context theContext = context;
        customerImagePath = theContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES).toString()+"/";


        String currentTown = town;

        if (null == townCustomers) {
            townCustomers = new ArrayList<>();
        }
        //get and set list of customers from Customers data file

        File file = new File("/data/data/com.example.franciscustomersdata/files/" + currentTown + ".txt");
        try {

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    Customer customer = new Customer(line,customerImagePath+line+".jpg");
                    townCustomers.add(customer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //loadCustomerImage(customerImagePath, image);

    }

    // Return towns data entries
    public static ArrayList<Customer> getTownCustomers() {

        return townCustomers;
    }


    // Initialize selected customer details
    public static void initCustomerDetails(String details, Context context) {
        Context theContext = context;
        customerImagePath = theContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES).toString()+"/";

        String currentDetail = details;

       theCustomer = new Customer();

        //get and set customer details from customer data file

        File file = new File("/data/data/com.example.franciscustomersdata/files/" + currentDetail + ".txt");
        try {
            theCustomer.setImageData(customerImagePath+currentDetail+".jpg");

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {

                String line;
                while ((line = br.readLine()) != null) {

                    if (line.contains("Name:")) {
                        theCustomer.setName(line);
                        //Log.d("Utils",customer.getName());
                    } else if (line.contains("Town:")) {
                        theCustomer.setTown(line);
                    } else if (line.contains("Contact:")) {
                        theCustomer.setContact(line);
                    } else if (line.contains("Address:")) {
                        theCustomer.setAddress(line);
                    } else if (line.contains("Other Names:")) {
                        theCustomer.setOtherNames(line);
                    } else if (line.contains("Partner:")) {
                        theCustomer.setPartner(line);
                    } else if (line.contains("Mother:")) {
                        theCustomer.setMother(line);
                    } else {
                        if (line.contains("Father:")) {
                            theCustomer.setFather(line);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    // empty ArrayList
    public static void emptyList() {
        towns = null;
        allCustomers = null;
        townCustomers = null;
    }


}
