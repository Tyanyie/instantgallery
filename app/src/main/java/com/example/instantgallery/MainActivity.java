package com.example.instantgallery;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.instantgallery.Bruce_class.CreatePasswordActivity;
import com.example.instantgallery.Bruce_class.LoadingActivity;
import com.example.instantgallery.tianyi_class.TianyiUtils;
import com.example.instantgallery.tianyi_class.Tianyi_Adapter;
import com.example.instantgallery.tianyi_class.Tianyi_ImageView;
import com.example.instantgallery.tianyi_class.Tianyi_Single_Image_View;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.instantgallery.R.layout.activity_main;


public class MainActivity extends AppCompatActivity
{
    //everyone shared variables
    public static final String TAG = "Tianyi_Debug_Info";
    public static final String TAG_1 = "Robert_Debug_Info";
    public static final String TAG_2 = "Bruce_Debug_Info";
    public static final String TAG_3 = "Ssu_Ting_Debug_Info";
    /*   ---------------------------------------------------------------------------- */
    //Tianyi Zhou's variables
    public static final int RESULT_CODE = 3;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private final List<String> photoList = new ArrayList<>();
    private Tianyi_Adapter myAdapter;
    private TianyiUtils myUtils;
    private float startX, endX;
    private final float distance = 100;
    private int currentPosition = 0;
    private Tianyi_ImageView imageView;
    private Tianyi_Adapter tianyi_adapter;
    /*   ---------------------------------------------------------------------------- */
    //Bruce's variables
    private final boolean login = false;
    /*   ---------------------------------------------------------------------------- */
    //Robert's variables
    public boolean nightmode = false;
    String currentPhotoPath;
    private GridView gridView;


    /*   ---------------------------------------------------------------------------- */
    public void capturePhoto()
    {
        Intent capPhoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (capPhoto.resolveActivity(getPackageManager()) != null)
        {
            File photoFile = null;
            try
            {
                photoFile = createImageFile();
            } catch (IOException ex)
            {

            }

            if (photoFile != null)
            {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
                capPhoto.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(capPhoto, REQUEST_IMAGE_CAPTURE);
            }
        }
    }

    private File createImageFile() throws IOException
    {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageName = "JPEG_" + timeStamp + "_";
        File sDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageName, ".jpg", sDir);

        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

    //Robert's
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch (event.getAction())
        {

            case MotionEvent.ACTION_DOWN:
                startX = event.getRawX();
                Log.i(TAG, "Action Down");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(TAG, "Action Move");
                break;
            case MotionEvent.ACTION_UP:
                endX = event.getRawX();
                if ((endX - startX) >= distance)
                {
                    //last picture
                    currentPosition--;

                    if (currentPosition < 0)
                    {
                        currentPosition = tianyi_adapter.getPhotoLength(photoList) - 1;
                    }
                    // TODO: 2021/3/3
                    imageView.setImageURI();
                }
                else if((startX - endX) >= distance)
                {
                    currentPosition ++;
                    if (currentPosition > tianyi_adapter.getPhotoLength(photoList))
                    {
                        currentPosition = 0;
                    }
                    // TODO: 2021/3/3
                    imageView.setImageResource();
                }
        }
        return super.onTouchEvent(event);
    }

    //everyone shared area
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        //check if user has logged in
        /*
        login = getIntent().getBooleanExtra("login", false);
        if(!login)
        {
            Intent intent = new Intent(getApplicationContext(), LoadingActivity.class);
            startActivity(intent);
            finish();
        }
        */

        /*   ---------------------------------------------------------------------------- */
        //Tianyi's
        myUtils = new TianyiUtils();
        imageView = findViewById(R.id.single_image);
        //asks for storage permission
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {
            Log.i(MainActivity.TAG, "no READ_EXTERNAL_STORAGE" + Manifest.permission.WRITE_EXTERNAL_STORAGE);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
        else
        {
            myUtils.getSystemPhoto(this, this);

            gridView = findViewById(R.id.gv_gallery_overview);
            myAdapter = new Tianyi_Adapter(this, photoList);
            gridView.setAdapter(myAdapter);
        }


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(MainActivity.this, Tianyi_Single_Image_View.class);
                intent.putExtra("image", myAdapter.getPhotoPathById(position));
                startActivity(intent);
                Log.i(TAG, "In MainActivity onItemClick()");
            }
        });

        /*----------------------------------------------------------------------*/
    }


    public List<String> getPhotoList()
    {
        return photoList;
    }

    //Tianyi's area, debugging



    //Robert's
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.takePic:
                capturePhoto();
                break;
            case R.id.nightMode:
                if (!nightmode)
                {
                    gridView.setBackgroundColor(Color.argb
                            (255, 55, 55, 55));
                    nightmode = true;
                }
                else
                {
                    gridView.setBackgroundColor(Color.argb
                            (255, 255, 255, 255));
                    nightmode = false;
                }
                break;
            //return true;
            case R.id.copy:
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                Intent appIntent = new Intent();
                ClipData clip = ClipData.newIntent("Intent", appIntent);

        }
        return true;
    }
    //Ssu-Ting's
}