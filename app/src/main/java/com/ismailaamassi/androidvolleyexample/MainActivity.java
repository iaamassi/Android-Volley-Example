package com.ismailaamassi.androidvolleyexample;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    Button btnExample1, btnExample2, btnExample3, btnExample4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnExample1 = findViewById(R.id.btnExample1);
        btnExample2 = findViewById(R.id.btnExample2);
        btnExample3 = findViewById(R.id.btnExample3);
        btnExample4 = findViewById(R.id.btnExample4);


        btnExample1.setOnClickListener(v -> startActivity(new Intent(this, StringRequestActivity.class)));
        btnExample2.setOnClickListener(v -> startActivity(new Intent(this, JsonObjectRequestActivity.class)));
        btnExample3.setOnClickListener(v -> startActivity(new Intent(this, JsonArrayRequestActivity.class)));
        btnExample4.setOnClickListener(v -> startActivity(new Intent(this, ImageRequestActivity.class)));
    }

}