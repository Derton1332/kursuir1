package com.example.kursuir;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private static int splash = 3000;
Button reg,log,next,fav,canc;
FirebaseAuth auth;
FirebaseDatabase db;
DatabaseReference users;
RelativeLayout root;

//Потом сделать
    /*setContentView(R.layout.activity_welcome);
        new Handler().postDelayed(new Runnable(){
        @Override
        public void run(){
            Intent homeIntent = new Intent(MainActivity.this, Welcome.class);
            startActivity(homeIntent);
            finish();
        }
    },splash);
        */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent homeIntent = new Intent(MainActivity.this, Map.class);
                startActivity(homeIntent);
                finish();
            }
        },splash);
    }
}
