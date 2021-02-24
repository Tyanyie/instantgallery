package com.example.instantgallery.tianyi_class;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.instantgallery.MainActivity;
import com.example.instantgallery.R;

import java.io.File;
import java.net.URI;

public class Tianyi_Single_Image_View extends AppCompatActivity
{
    Tianyi_ImageView clickedImage;
    Intent intent;
    Tianyi_Adapter tianyi_adapter;
    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tianyi_single_photo_view);


        clickedImage = (Tianyi_ImageView) findViewById(R.id.single_image);
        intent = getIntent();
        int imageId = intent.getIntExtra("image", 0);
        /*Todo
        *  1. get photo path  [√]
        *   2. get image resource from photo path
        *
        * */
//        clickedImage.setImageResource(MainActivity.);



            clickedImage.setImageURI(tianyi_adapter.uri);








    }
}