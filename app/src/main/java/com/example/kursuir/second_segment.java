package com.example.kursuir;

import static com.example.kursuir.R.id.number_edit;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.ibm.icu.text.RuleBasedNumberFormat;

import java.util.Locale;

public class second_segment extends AppCompatActivity {
    Button createPDF3;
    TextView qty8;      //Количество
    TextView qty9;      // Цена
    TextView qty10;     // Единици измерения
    TextView qty11;      // сумма
    Spinner item1spinner3;
    TextView bill3;
    TextView sellerName2;
    TextView buyerName2;
    TextView number2;
    TextView year2;
    TextView from2;
    TextView month2;


    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_second_segment);
        qty8 = findViewById(R.id.qty8);  //Количество
        qty9 = findViewById(R.id.qty9);  // Цена
        qty10 = findViewById(R.id.qty10);  // Единици измерения
        qty11 = findViewById(R.id.qty11);   // сумма
        item1spinner3 = findViewById(R.id.item1spinner3);
        bill3 = findViewById(R.id.bill3);
        sellerName2 = findViewById(R.id.sellerName2);
        number2 = findViewById(R.id.number2);
        year2 = findViewById(R.id.year2);
        from2 = findViewById(R.id.from2);
        buyerName2 = findViewById(R.id.buyerName2);
        month2 = findViewById(R.id.month2);
        createPDF3 = findViewById(R.id.createPDF3);


        moneytrans();
        multiply();
        Dialogkolich();
        Dialogprice();

        sellerName2.setText(getIntent().getStringExtra("sellerName"));
        buyerName2.setText(getIntent().getStringExtra("buyerName"));
        number2.setText(getIntent().getStringExtra("number"));
        year2.setText(getIntent().getStringExtra("year"));
        from2.setText(getIntent().getStringExtra("from"));
        month2.setText(getIntent().getStringExtra("month"));



    }
    private void moneytrans() {
        bill3.setOnClickListener(v -> {
            int mon;
            RuleBasedNumberFormat nf = new RuleBasedNumberFormat(Locale.forLanguageTag("ru"), RuleBasedNumberFormat.SPELLOUT);
            mon = Integer.parseInt(qty11.getText().toString());
            bill3.setText(nf.format(mon));
        });
    }
    @SuppressLint("SetTextI18n")
    private void multiply() {
        qty11.setOnClickListener(v -> {
            int amt = Integer.parseInt(qty8.getText().toString());
            int amt1 = Integer.parseInt(qty9.getText().toString());
            int multiply;
            multiply = amt * amt1;
            qty11.setText("" + multiply);
        });
    }
    private void Dialogkolich() {
        qty8.setOnClickListener(v -> {
            AlertDialog.Builder dialog = new AlertDialog.Builder(second_segment.this);
            dialog.setTitle("Введите количество товара!");
            LayoutInflater inflater = LayoutInflater.from(second_segment.this);
            View editNumber = inflater.inflate(R.layout.edit_text_number, null);
            dialog.setView(editNumber);
            EditText edit = editNumber.findViewById(number_edit);

            dialog.setPositiveButton("OK", (dialog1, which) -> qty8.setText(edit.getText()));
            dialog.show();
        });

    }
    private void Dialogprice() {
        qty9.setOnClickListener(v -> {
            AlertDialog.Builder dialog = new AlertDialog.Builder(second_segment.this);
            dialog.setTitle("Введите цену товара!");
            LayoutInflater inflater = LayoutInflater.from(second_segment.this);
            View editNumber = inflater.inflate(R.layout.edit_text_number, null);
            dialog.setView(editNumber);
            EditText edit = editNumber.findViewById(number_edit);

            dialog.setPositiveButton("OK", (dialog1, which) -> qty9.setText(edit.getText()));
            dialog.show();
        });

    }
    public void back(View view) {
        Intent i=new Intent(this, third_segment.class);
        String sn=this.qty8.getText().toString();
        String bn=this.qty9.getText().toString();
        String num=this.qty10.getText().toString();
        String ye=this.qty11.getText().toString();
        String fr=this.item1spinner3.getSelectedItem().toString();
        String mo=this.bill3.getText().toString();

        String sell=this.sellerName2.getText().toString();
        String buy=this.buyerName2.getText().toString();
        String num1=this.number2.getText().toString();
        String ye1=this.year2.getText().toString();
        String fr1=this.from2.getText().toString();
        String mo1=this.month2.getText().toString();


        i.putExtra("sellerName",sell);
        i.putExtra("buyerName",buy);
        i.putExtra("number",num1);
        i.putExtra("year",ye1);
        i.putExtra("from",fr1);
        i.putExtra("month",mo1);

        i.putExtra("qty8",sn);  //Количество
        i.putExtra("qty9",bn);  // Цена
        i.putExtra("qty10",num);  // Единици измерения
        i.putExtra("qty11",ye);   // сумма
        i.putExtra("item1spinner3",fr);
        i.putExtra("bill3",mo);
        startActivity(i);

    }













}
