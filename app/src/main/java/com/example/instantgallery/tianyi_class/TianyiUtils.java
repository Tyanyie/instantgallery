package com.example.instantgallery.tianyi_class;

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

import com.example.instantgallery.MainActivity;

public class TianyiUtils
{
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
        assert imageCursor != null;
        imageCursor.close();
    }
}
