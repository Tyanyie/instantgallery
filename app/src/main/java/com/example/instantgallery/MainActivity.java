package com.example.instantgallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    RecyclerView recyclerView;
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


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.Gallery);
        recyclerView.setHasFixedSize(true);

        final int columns = 5;
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), columns);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<CreateList> createLists = prepareData();
        MyAdapter adaptor = new MyAdapter(getApplicationContext(), createLists);
        recyclerView.setAdapter(adaptor);

    }

    private ArrayList<CreateList> prepareData()
    {
        ArrayList<CreateList> theimage = new ArrayList<>();
        for (int i = 0; i < image_titles.length; i++)
        {
            CreateList createList = new CreateList();
            createList.setImage_title(image_titles[i]);
            createList.setImage_ID(image_ids[i]);
            theimage.add(createList);
        }
        return theimage;
    }
}