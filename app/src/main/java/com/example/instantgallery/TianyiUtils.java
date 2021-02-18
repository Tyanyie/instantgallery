package com.example.instantgallery;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.provider.MediaStore;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class TianyiUtils extends MainActivity
{

    //Tianyi's            request read file permission
    public void requestPermissions(MainActivity mainActivity)
    {
        if (ContextCompat.checkSelfPermission(mainActivity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {
            Log.i(MainActivity.TAG, "no READ_EXTERNAL_STORAGE" + Manifest.permission.WRITE_EXTERNAL_STORAGE);
            ActivityCompat.requestPermissions(mainActivity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
        if (ContextCompat.checkSelfPermission(mainActivity, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {
            Log.i(MainActivity.TAG, "no Write_EXTERNAL_STORAGE" + Manifest.permission.READ_EXTERNAL_STORAGE);
            ActivityCompat.requestPermissions(mainActivity, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }

    }

    //Tianyi's              get photos from device storage
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void getSystemPhoto(ContextWrapper contextWrapper, MainActivity mainActivity)
    {
        ContentResolver contentResolver = contextWrapper.getContentResolver();
        String[] columns = {MediaStore.Images.Media.DATA, MediaStore.Images.Media._ID};
        Cursor imageCursor = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, columns, null, null);

        if (imageCursor != null)
        {
            if (imageCursor.getCount() > 0)
            {
                while (imageCursor.moveToNext())
                {
                    String path = imageCursor.getString(imageCursor.getColumnIndex(MediaStore.Images.Media.DATA));
                    Log.i(MainActivity.TAG, "Paths: " + path);
                    mainActivity.getPhotoList().add(path);
                }
            }
        }

    }
}
