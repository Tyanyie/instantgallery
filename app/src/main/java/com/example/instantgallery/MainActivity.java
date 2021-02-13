package com.example.instantgallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity
{
    private final String image_titles[] = {
            "Img1",
            "Img2",
            "Img3",
            "Img4",
            "Img5",
            "Img6",
            "Img7",
//            "Img8",
//            "Img9",
//            "Img10",
//            "Img11",
//            "Img12",
//            "Img13",
    };
    private final Integer image_ids[] = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
//            R.drawable.img8,
//            R.drawable.img9,
//            R.drawable.img10,
//            R.drawable.img11,
//            R.drawable.img12,
//            R.drawable.img13,
    };
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

}