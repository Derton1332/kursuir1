package com.example.kursuir;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Suppliers_wool extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suppliers_wool);
    }

    public void cancel(View view) {
        Intent intent = new Intent(this,Categories.class);
        startActivity(intent);
    }
    public void web(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://optsbyt.ru/supplier/anturazh-ltd"));
        startActivity(browserIntent);
    }

    public void web1(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://optsbyt.ru/supplier/optwool"));
        startActivity(browserIntent);
    }

    public void web2(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://optsbyt.ru/supplier/kamteks"));
        startActivity(browserIntent);
    }
}