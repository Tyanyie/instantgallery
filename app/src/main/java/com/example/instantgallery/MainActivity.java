package com.example.instantgallery;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.instantgallery.tianyi_class.TianyiUtils;
import com.example.instantgallery.tianyi_class.Tianyi_Adapter;
import com.example.instantgallery.tianyi_class.Tianyi_Single_Image_View;


import java.util.ArrayList;
import java.util.List;

import static com.example.instantgallery.R.layout.activity_main;


public class MainActivity extends AppCompatActivity
{
    //Tianyi Zhou's variables
    public static final String TAG = "My Debug";
    public static final int RESULT_CODE = 3;
    private GridView gridView;
    private Tianyi_Adapter myAdapter;
    private TianyiUtils myUtils;

    /*   ---------------------------------------------------------------------------- */
    //Robert's variables
    public boolean nightmode = false;
    private ImageView imageView;

    private final List<String> photoList = new ArrayList<>();
    private final int picCount = 1; // Prevent access to array indexes as pics are deleted

    //Robert's
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    //everyone shared area
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        //Tianyi's
        myUtils = new TianyiUtils();
        myUtils.requestPermissions(this);
        myUtils.getSystemPhoto(this, this);

        gridView = findViewById(R.id.gv_gallery_overview);
        myAdapter = new Tianyi_Adapter(this, photoList);
        gridView.setAdapter(myAdapter);

        //bitmap = gridView.getDrawingCache();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(MainActivity.this, Tianyi_Single_Image_View.class);

                startActivity(intent);
            }
        });

        /*----------------------------------------------------------------------*/

    }

    public int getResId()
    {
        return gridView.getId();
    }

    public List<String> getPhotoList()
    {
        return photoList;
    }
    //Tianyi's area, debugging
 /*
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
*/


    //Robert's
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            /*
             * Todo
             *  Hi Robert, you might need to adjust your code with our approach to
             *  accessing photos on the user's phone rather than read photos from drawables
             * */
            /*
            case R.id.deletePic:
                if (picCount == pictures.length)
                {
                    imageView.setImageResource(0);
                    return true;
                }
                // If deleting last image
                if (currentPosition == pictures.length - picCount)
                {
                    imageView.setImageResource(0);
                    picCount++;
                    return true;
                }
                // If deleting an image (that is not last)
                for (int i = currentPosition; i <= pictures.length - picCount; i++)
                {
                    if (i != pictures.length - picCount)
                    {
                        pictures[i] = pictures[i + 1];
                        imageView.setImageResource(pictures[currentPosition]);
                    }
                }
                picCount++;
                return true;

             */
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

        }
        return true;
    }
}