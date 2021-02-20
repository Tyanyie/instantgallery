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

public class CreatePasswordActivity extends AppCompatActivity {

    EditText editText1, editText2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_password);

        editText1 = findViewById(R.id.et_Create_Password);
        editText2 = findViewById(R.id.et_Confirm_Password);
        button = findViewById(R.id.btn_Confirm);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1 = editText1.getText().toString();
                String text2 = editText2.getText().toString();

                //if user leave any input box blank
                if(text1.equals("") || text2.equals(""))
                {
                    Toast.makeText(CreatePasswordActivity.this, "Do not leave any input box blank", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    if(text1.equals(text2))
                    {
                        //save password
                        SharedPreferences settings = getSharedPreferences("PREFS", 0);
                        SharedPreferences.Editor editor = settings. edit();
                        editor.putString("password", text1);
                        editor.apply();

                        //Enter the app
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    //if two password does not match
                    else
                    {
                        Toast.makeText(CreatePasswordActivity.this, "Password does not match", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}