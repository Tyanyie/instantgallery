package com.example.instantgallery.tianyi_class;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.instantgallery.MainActivity;
import com.example.instantgallery.R;

import java.io.File;
import java.net.URI;

public class Tianyi_Single_Image_View extends AppCompatActivity
{
    public static final String TAG = "Too";
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
        String imageId = intent.getStringExtra("image");
        /*Todo
        *  1. get photo path  [√]
        *   2. get image resource from photo path
        *
        * */
//        clickedImage.setImageResource(MainActivity.);

        Uri uri = Uri.parse(imageId);
//        Log.v(TAG, "clicked image :" + clickedImage);
        Log.v(TAG, "URI is :" + uri);
        clickedImage.setImageURI(uri);








    }
}