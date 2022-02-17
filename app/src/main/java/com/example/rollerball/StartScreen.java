package com.example.rollerball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class StartScreen extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);


        button = findViewById(R.id.button);
        Intent myIntent = new Intent(StartScreen.this, MainActivity.class);

        button.setOnClickListener(v -> {
            startActivity(myIntent);
        });





    }
}