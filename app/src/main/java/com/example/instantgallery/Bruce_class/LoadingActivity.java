package com.example.instantgallery.Bruce_class;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.instantgallery.R;

public class LoadingActivity extends AppCompatActivity {

    String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        //Load the password
        SharedPreferences settings = getSharedPreferences("PREFS", 0);
        password = settings.getString("password", "");

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //user has not yet created a password
                if(password.equals(""))
                {
                    Intent intent = new Intent(getApplicationContext(), CreatePasswordActivity.class);
                    startActivity(intent);
                    finish();
                }
                //use has created a password
                else
                {
                    Intent intent = new Intent(getApplicationContext(), EnterPasswordActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 1500);
    }
}