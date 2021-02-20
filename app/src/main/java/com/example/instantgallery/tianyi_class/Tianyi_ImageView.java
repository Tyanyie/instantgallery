package com.example.instantgallery.tianyi_class;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.example.instantgallery.R;

import java.util.logging.Logger;

public class Tianyi_ImageView extends androidx.appcompat.widget.AppCompatImageView
{

    public static final String TAG = "My";

    public Tianyi_ImageView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

}
