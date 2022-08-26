package com.example.franciscustomersdata;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CustomerImageCaptureActivity extends AppCompatActivity {
    //static Fields
    private static final int CAMERA_REQUEST_CODE = 101;
    private static final int CAMERA_PERMISSION_REQUEST_CODE = 202;

    private ImageButton imgBtnTakePick;
    private String currentPhotoPath, name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_image_capture);

        // get string data from intent
        Intent intent = getIntent();
        name = intent.getStringExtra("name");



        initViews();
        //set onClickListener for imgBtnTakePick
        imgBtnTakePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                 //Capture image with Intent

                takePictureIntent();


            }
        });

    }

    private void takePictureIntent() {
        Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (pictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.franciscustomersdata",
                        photoFile);
                pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(pictureIntent, CAMERA_REQUEST_CODE);
            }
        }


    }


    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = name; /*+ "_" + timeStamp + "_";*/
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        File image =  new File(storageDir, imageFileName+".jpg");

//        File image = File.createTempFile(
//                imageFileName,  /* prefix */
//                ".jpg",         /* suffix */
//                storageDir      /* directory */
//        );

        return image;
    }


    private void initViews() {
        imgBtnTakePick = findViewById(R.id.imgBtnTakePick);
    }
}