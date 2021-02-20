package com.example.instantgallery.Bruce_class;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.instantgallery.MainActivity;
import com.example.instantgallery.R;

public class EnterPasswordActivity extends AppCompatActivity {

    EditText editText;
    Button button;

    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_password);


        //Load the password
        SharedPreferences settings = getSharedPreferences("PREFS", 0);
        password = settings.getString("password", "");

        editText = findViewById(R.id.et_Enter_Password);
        button = findViewById(R.id.btn_Enter);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if (text.equals(password))
                {
                    //Enter the app
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("login", true);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(EnterPasswordActivity.this, "Incorrect password", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}