package com.example.kursuir;

import static com.example.kursuir.R.id.number_edit;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class first_segment extends AppCompatActivity {
    Button save;
    TextView sellerName;
    TextView buyerName;
    TextView number;
    TextView year;
    TextView from;
    TextView month;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_segment);

        sellerName = findViewById(R.id.sellerName);
        buyerName = findViewById(R.id.buyerName);

        save = findViewById(R.id.save);
        number = findViewById(R.id.number);
        year = findViewById(R.id.year);
        from = findViewById(R.id.from);
        month = findViewById(R.id.month);

        DialogNumber();
        DialogDay();
        DialogMonth();
        DialogYear();
        DialogFIOsell();
        DialogFIObuy();


    }
    public void save(View view) {
        Intent i=new Intent(this, second_segment.class);
        String sn=this.sellerName.getText().toString();
        String bn=this.buyerName.getText().toString();
        String num=this.number.getText().toString();
        String ye=this.year.getText().toString();
        String fr=this.from.getText().toString();
        String mo=this.month.getText().toString();

        i.putExtra("sellerName",sn);
        i.putExtra("buyerName",bn);
        i.putExtra("number",num);
        i.putExtra("year",ye);
        i.putExtra("from",fr);
        i.putExtra("month",mo);
        startActivity(i);

    }
    private void DialogNumber() {
        number.setOnClickListener(v -> {
            AlertDialog.Builder dialog = new AlertDialog.Builder(first_segment.this);
            dialog.setTitle("Введите номер накладной!");
            LayoutInflater inflater = LayoutInflater.from(first_segment.this);
            View editNumber = inflater.inflate(R.layout.edit_text_number, null);
            dialog.setView(editNumber);
            EditText edit = editNumber.findViewById(number_edit);

            dialog.setPositiveButton("OK", (dialog1, which) -> number.setText(edit.getText()));
            dialog.show();

        });

    }
    private void DialogDay() {
        from.setOnClickListener(v -> {
            AlertDialog.Builder dialog = new AlertDialog.Builder(first_segment.this);
            dialog.setTitle("Введите день!");
            LayoutInflater inflater = LayoutInflater.from(first_segment.this);
            View editNumber = inflater.inflate(R.layout.edit_text_number, null);
            dialog.setView(editNumber);
            EditText edit = editNumber.findViewById(number_edit);

            dialog.setPositiveButton("OK", (dialog1, which) -> from.setText(edit.getText()));
            dialog.show();
        });

    }
    private void DialogMonth() {
        month.setOnClickListener(v -> {
            AlertDialog.Builder dialog = new AlertDialog.Builder(first_segment.this);
            dialog.setTitle("Введите месяц!");
            LayoutInflater inflater = LayoutInflater.from(first_segment.this);
            View editNumber = inflater.inflate(R.layout.edit_text_number, null);
            dialog.setView(editNumber);
            EditText edit = editNumber.findViewById(number_edit);

            dialog.setPositiveButton("OK", (dialog1, which) -> month.setText(edit.getText()));
            dialog.show();
        });

    }
    private void DialogYear() {
        year.setOnClickListener(v -> {
            AlertDialog.Builder dialog = new AlertDialog.Builder(first_segment.this);
            dialog.setTitle("Введите год!");
            LayoutInflater inflater = LayoutInflater.from(first_segment.this);
            View editNumber = inflater.inflate(R.layout.edit_text_number, null);
            dialog.setView(editNumber);
            EditText edit = editNumber.findViewById(number_edit);

            dialog.setPositiveButton("OK", (dialog1, which) -> year.setText(edit.getText()));
            dialog.show();
        });

    }
    private void DialogFIOsell() {
        sellerName.setOnClickListener(v -> {
            AlertDialog.Builder dialog = new AlertDialog.Builder(first_segment.this);
            dialog.setTitle("Введите ФИО продавца!");
            LayoutInflater inflater = LayoutInflater.from(first_segment.this);
            View editNumber = inflater.inflate(R.layout.edit_text_number, null);
            dialog.setView(editNumber);
            EditText edit = editNumber.findViewById(number_edit);

            dialog.setPositiveButton("OK", (dialog1, which) -> sellerName.setText(edit.getText()));
            dialog.show();
        });

    }
    private void DialogFIObuy() {
        buyerName.setOnClickListener(v -> {
            AlertDialog.Builder dialog = new AlertDialog.Builder(first_segment.this);
            dialog.setTitle("Введите ФИО покупателя!");
            LayoutInflater inflater = LayoutInflater.from(first_segment.this);
            View editNumber = inflater.inflate(R.layout.edit_text_number, null);
            dialog.setView(editNumber);
            EditText edit = editNumber.findViewById(number_edit);

            dialog.setPositiveButton("OK", (dialog1, which) -> buyerName.setText(edit.getText()));
            dialog.show();
        });

    }



}
