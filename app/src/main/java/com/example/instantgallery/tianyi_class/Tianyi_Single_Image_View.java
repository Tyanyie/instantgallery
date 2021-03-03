package com.example.instantgallery.tianyi_class;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.instantgallery.MainActivity;
import com.example.instantgallery.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class Tianyi_Single_Image_View extends AppCompatActivity
{
    public static final String TAG = "Too";
    Tianyi_ImageView clickedImage;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tianyi_single_photo_view);


        clickedImage = findViewById(R.id.single_image);
        intent = getIntent();
        String imageId = intent.getStringExtra("image");

        Uri uri = Uri.parse(imageId);
        Log.v(TAG, "URI is :" + uri);
        clickedImage.setImageURI(uri);
    }
}