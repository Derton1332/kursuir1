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

public class third_segment extends AppCompatActivity {
    Button next3;
    TextView qty13; // Единици измерения
    TextView qty14; //Количество
    TextView qty12; // Цена
    TextView qty15; // сумма
    TextView item1spinner4;
    TextView bill4;
    TextView sellerName4;
    TextView buyerName4;
    TextView number4;
    TextView year4;
    TextView from4;
    TextView month4;
    TextView buyerPrint3;
    TextView sellerPrint3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_segment);
        qty13 = findViewById(R.id.qty13);  // Единици измерения
        qty14 = findViewById(R.id.qty14); //Количество
        qty12 = findViewById(R.id.qty12); // Цена
        qty15 = findViewById(R.id.qty15); // сумма
        item1spinner4 = findViewById(R.id.item1spinner4);
        bill4 = findViewById(R.id.bill4);
        sellerName4 = findViewById(R.id.sellerName4);
        number4 = findViewById(R.id.number4);
        year4 = findViewById(R.id.year4);
        from4 = findViewById(R.id.from4);
        buyerName4 = findViewById(R.id.buyerName4);
        month4 = findViewById(R.id.month4);
        next3 = findViewById(R.id.next3);
        buyerPrint3 = findViewById(R.id.buyerPrint3);
        sellerPrint3 = findViewById(R.id.sellerPrint3);

        sellerName4.setText(getIntent().getStringExtra("sellerName"));
        buyerName4.setText(getIntent().getStringExtra("buyerName"));
        number4.setText(getIntent().getStringExtra("number"));
        year4.setText(getIntent().getStringExtra("year"));
        from4.setText(getIntent().getStringExtra("from"));
        month4.setText(getIntent().getStringExtra("month"));

        item1spinner4.setText(getIntent().getStringExtra("item1spinner3"));
        qty13.setText(getIntent().getStringExtra("qty10")); // Единици измерения
        qty14.setText(getIntent().getStringExtra("qty8")); //Количество
        qty12.setText(getIntent().getStringExtra("qty9")); // Цена
        qty15.setText(getIntent().getStringExtra("qty11")); // сумма
        bill4.setText(getIntent().getStringExtra("bill3"));
        DialogbuyerPrint();
        DialogsellerPrint();
    }

    private void DialogbuyerPrint() {
        buyerPrint3.setOnClickListener(v -> {
            AlertDialog.Builder dialog = new AlertDialog.Builder(third_segment.this);
            dialog.setTitle("Введите  ФИО продавца!");
            LayoutInflater inflater = LayoutInflater.from(third_segment.this);
            View editNumber = inflater.inflate(R.layout.edit_text_number, null);
            dialog.setView(editNumber);
            EditText edit = editNumber.findViewById(number_edit);

            dialog.setPositiveButton("OK", (dialog1, which) -> buyerPrint3.setText(edit.getText()));
            dialog.show();
        });

    }
    private void DialogsellerPrint() {
        sellerPrint3.setOnClickListener(v -> {
            AlertDialog.Builder dialog = new AlertDialog.Builder(third_segment.this);
            dialog.setTitle("Введите ФИО покупателя!");
            LayoutInflater inflater = LayoutInflater.from(third_segment.this);
            View editNumber = inflater.inflate(R.layout.edit_text_number, null);
            dialog.setView(editNumber);
            EditText edit = editNumber.findViewById(number_edit);

            dialog.setPositiveButton("OK", (dialog1, which) -> sellerPrint3.setText(edit.getText()));
            dialog.show();
        });

    }
    public void next (View view){
        Intent i=new Intent(this, Favorite.class);
        String sn=this.qty14.getText().toString();
        String bn=this.qty12.getText().toString();
        String num=this.qty13.getText().toString();
        String ye=this.qty15.getText().toString();
        String fr=this.item1spinner4.getText().toString();
        String mo=this.bill4.getText().toString();

        String sell=this.sellerName4.getText().toString();
        String buy=this.buyerName4.getText().toString();
        String num1=this.number4.getText().toString();
        String ye1=this.year4.getText().toString();
        String fr1=this.from4.getText().toString();
        String mo1=this.month4.getText().toString();

        String bp=this.buyerPrint3.getText().toString();
        String sl=this.sellerPrint3.getText().toString();


        i.putExtra("sellerName",sell);
        i.putExtra("buyerName",buy);
        i.putExtra("number",num1);
        i.putExtra("year",ye1);
        i.putExtra("from",fr1);
        i.putExtra("month",mo1);

        i.putExtra("kolich",sn);
        i.putExtra("cena",bn);
        i.putExtra("edizm",num);
        i.putExtra("summa",ye);
        i.putExtra("spinner",fr);
        i.putExtra("chet",mo);

        i.putExtra("buyerPrint3",bp);
        i.putExtra("sellerPrint3",sl);


        startActivity(i);
    }
}