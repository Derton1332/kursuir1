package com.example.kursuir;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Categories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
    }

    public void fish_button(View view) {
        Intent intent = new Intent(this,Suppliers_fish.class);
        startActivity(intent);
    }

    public void wool_button(View view) {
        Intent intent = new Intent(this,Suppliers_wool.class);
        startActivity(intent);
    }

    public void milk_button(View view) {
        Intent intent = new Intent(this,Suppliers_milk.class);
        startActivity(intent);
    }

    public void lamp_button(View view) {
        Intent intent = new Intent(this,Suppliers_lamp.class);
        startActivity(intent);
    }
}