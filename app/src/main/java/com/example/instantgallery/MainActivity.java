package com.example.instantgallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.example.instantgallery.R.layout.activity_main;


public class MainActivity extends AppCompatActivity
{
    public static final String TAG = "My Debug";
    private float startX, endX;
    private float distance = 100f;

    public boolean nightmode = false;
    private int picCount = 1; // Prevent access to array indexes as pics are deleted

    private ImageView imageView;

    private int currentPosition = 0;
    private int[]pictures =
            {
                    R.drawable.a1,
                    R.drawable.a2,
                    R.drawable.a3,
                    R.drawable.a4,
                    R.drawable.a5,
                    R.drawable.a6,
                    R.drawable.a7,
                    R.drawable.a8,
                    R.drawable.a9,
            };

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        imageView = (ImageView)findViewById(R.id.iv_image);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                startX = event.getRawX();
                Log.i(TAG,"Action Down");
                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:
                endX = event.getRawX();

                if (picCount != pictures.length) { // Added for delete functionality
                if ((endX - startX) >= distance)
                {
                    //last picture
                    currentPosition --;
                    if (currentPosition < 0)
                    {
                        currentPosition = pictures.length-picCount; // picCount replaced 1
                    }
                }
                else if (startX - endX >= distance)
                {
                    currentPosition ++;
                    if (currentPosition > pictures.length-picCount) // picCount replaced 1
                    {
                        //if overflow then reset to 0
                        currentPosition = 0;
                    }
                }
                imageView.setImageResource(pictures[currentPosition]);
                Log.i(TAG,"Action Up");
                }
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.deletePic:
                if (picCount == pictures.length) {
                    imageView.setImageResource(0);
                    return true;
                }
                // If deleting last image
                if (currentPosition == pictures.length-picCount) {
                    imageView.setImageResource(0);
                    picCount++;
                    return true;
                }
                // If deleting an image (that is not last)
                for (int i = currentPosition; i <= pictures.length-picCount; i++)
                {
                    if (i != pictures.length-picCount) {
                        pictures[i] = pictures[i + 1];
                        imageView.setImageResource(pictures[currentPosition]);
                    }
                }
                picCount++;
                return true;
            case R.id.nightMode:
                if (nightmode == false)
                {
                    imageView.setBackgroundColor(Color.argb
                            (255, 55, 55, 55));
                    nightmode = true;
                }
                else {
                    imageView.setBackgroundColor(Color.argb
                            (255, 255, 255, 255));
                    nightmode = false;
                }
                return true;
        }
        return true;
    }
}