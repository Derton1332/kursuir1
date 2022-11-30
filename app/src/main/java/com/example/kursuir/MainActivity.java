package com.example.kursuir;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final int splash = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        new Handler().postDelayed(() -> {
            Intent homeIntent = new Intent(MainActivity.this, Map.class);
            startActivity(homeIntent);
            finish();
        },splash);
    }
}
