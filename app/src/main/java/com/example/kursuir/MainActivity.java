package com.example.kursuir;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kursuir.models.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

public class MainActivity extends AppCompatActivity {
    private static int splash = 3000;
Button reg,log;
FirebaseAuth auth;
FirebaseDatabase db;
DatabaseReference users;
RelativeLayout root;


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
        setContentView(R.layout.activity_main);
        reg = findViewById(R.id.Bt_reg);
        log = findViewById(R.id.Bt_log);
        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("users");

        reg.setOnClickListener(v -> showRegisterWindow());
        log.setOnClickListener(v -> showSingInWindow());
    }
    private void showSingInWindow(){
        root = findViewById(R.id.root);
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Register");
        dialog.setMessage("Put all data");
        LayoutInflater inflater = LayoutInflater.from(this);
        View sing_inWindow = inflater.inflate(R.layout.sing_in_winow, null);
        dialog.setView(sing_inWindow);

        MaterialEditText login = sing_inWindow.findViewById(R.id.LoginText);
        MaterialEditText pass = sing_inWindow.findViewById(R.id.PassText);

        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        dialog.setPositiveButton("Register", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(TextUtils.isEmpty(login.getText().toString())) {
                    Snackbar.make(root,"Enter your login", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if(pass.getText().toString().length() < 8) {
                    Snackbar.make(root, "Enter your Password", Snackbar.LENGTH_SHORT).show();
                    return;
                }

            }
        });
        auth.signInWithEmailAndPassword(login.getText().toString(),pass.getText().toString())
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        startActivity(new Intent(MainActivity.this, Map.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Snackbar.make(root,"Incorrect data!" + e.getMessage(),Snackbar.LENGTH_SHORT).show();
                    }
                });
        dialog.show();
    }



    private void showRegisterWindow() {
        root = findViewById(R.id.root);
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle("Register");
                dialog.setMessage("Put all data");
        LayoutInflater inflater = LayoutInflater.from(this);
        View register_window = inflater.inflate(R.layout.sing_up_window, null);
        dialog.setView(register_window);

        MaterialEditText login = register_window.findViewById(R.id.LoginText);
        MaterialEditText pass = register_window.findViewById(R.id.PassText);
        MaterialEditText passconf = register_window.findViewById(R.id.ConfPassText);

        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        dialog.setPositiveButton("Register", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(TextUtils.isEmpty(login.getText().toString())) {
                    Snackbar.make(root,"Enter your login", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if(pass.getText().toString().length() < 8) {
                    Snackbar.make(root, "Enter your Password", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(passconf.getText().toString())) {
                    Snackbar.make(root, "Enter your Password again", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                //регистраци
                auth.createUserWithEmailAndPassword(login.getText().toString(), pass.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                User user = new User();
                                user.setLogin(login.getText().toString());
                                user.setLogin(pass.getText().toString());

                                users.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(user)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Snackbar.make(root,"Register sucsesful",Snackbar.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        });
            }
        });
        dialog.show();
    }
}