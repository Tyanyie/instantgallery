package com.example.instantgallery.tianyi_class;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.instantgallery.R;

public class Tianyi_Single_Image_View extends AppCompatActivity
{
    Tianyi_ImageView clickedImage;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tianyi_single_photo_view);

        clickedImage = (Tianyi_ImageView) findViewById(R.id.single_image);
        intent = getIntent();

        clickedImage.setImageResource( intent.getIntExtra("image", 0));



    }
}