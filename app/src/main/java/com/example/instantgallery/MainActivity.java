package com.example.instantgallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private GridView gridView;
    private MyAdapter mAdapter;
    private List<String> photoList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gridview);
        mAdapter = (MyAdapter) new MyAdapter(this, photoList);

        gridView.setAdapter(mAdapter);
    }


    @Override
    public void onClick(View v)
    {

    }
}