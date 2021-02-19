package com.example.instantgallery;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

public class Tianyi_Single_Image_View extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tianyi_single_photo_view);

        Intent intent = getIntent();

        Bitmap bitmap = (Bitmap) intent.getParcelableExtra("BitmapImage");
    }
}