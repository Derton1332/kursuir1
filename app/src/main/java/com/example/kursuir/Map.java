package com.example.kursuir;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Map extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
    }



    public void favorite(View view) {
        Intent intent = new Intent(this,Favorite.class);
        startActivity(intent);
    }

    public void LogOut(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}