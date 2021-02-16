package com.example.instantgallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import static com.example.instantgallery.R.layout.activity_main;


public class MainActivity extends AppCompatActivity
{
    public static final String TAG = "My Debug";
    private float startX, endX;
    private float distance = 100f;

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

                if ((endX - startX) >= distance)
                {
                    //last picture
                    currentPosition --;
                    if (currentPosition < 0)
                    {
                        currentPosition = pictures.length-1;
                    }
                }
                else if (startX - endX >= distance)
                {
                    currentPosition ++;
                    if (currentPosition > pictures.length-1)
                    {
                        //if overflow then reset to 0
                        currentPosition = 0;
                    }
                }
                imageView.setImageResource(pictures[currentPosition]);
                Log.i(TAG,"Action Up");
        }
        return super.onTouchEvent(event);
    }


}