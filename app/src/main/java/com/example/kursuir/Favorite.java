package com.example.kursuir;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Favorite extends AppCompatActivity {
    Button create, firstsegment, secondsegment;
    TextView item1spinner;
    TextView qty1;
    TextView buyerPrint;
    TextView sellerPrint;
    TextView qty;
    TextView bill;
    TextView qty4;
    TextView qty6;
    TextView sellerName;
    TextView buyerName;
    TextView number;
    TextView year;
    TextView from;
    TextView month;


    Bitmap bmp, scaledbp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        create = findViewById(R.id.createPDF);
        item1spinner = findViewById(R.id.item1spinner);
        qty1 = findViewById(R.id.qty1);
        buyerPrint = findViewById(R.id.buyerPrint);
        sellerPrint = findViewById(R.id.sellerPrint);
        firstsegment = findViewById(R.id.firstsegment);
        secondsegment = findViewById(R.id.secondsegment);
        qty4 = findViewById(R.id.qty4);
        sellerName = findViewById(R.id.sellerName);
        buyerName = findViewById(R.id.buyerName);
        number = findViewById(R.id.number);
        year = findViewById(R.id.year);
        from = findViewById(R.id.from);
        month = findViewById(R.id.month);
        qty6 = findViewById(R.id.qty6);
        qty = findViewById(R.id.qty);
        bill = findViewById(R.id.bill);
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.object);
        scaledbp = Bitmap.createScaledBitmap(bmp, 1177, 940, false);
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);



        sellerName.setText(getIntent().getStringExtra("sellerName"));
        buyerName.setText(getIntent().getStringExtra("buyerName"));
        number.setText(getIntent().getStringExtra("number"));
        year.setText(getIntent().getStringExtra("year"));
        from.setText(getIntent().getStringExtra("from"));
        month.setText(getIntent().getStringExtra("month"));

        qty1.setText(getIntent().getStringExtra("edizm"));
        qty6.setText(getIntent().getStringExtra("kolich"));
        qty4.setText(getIntent().getStringExtra("cena"));
        qty.setText(getIntent().getStringExtra("summa"));
        item1spinner.setText(getIntent().getStringExtra("spinner"));
        bill.setText(getIntent().getStringExtra("chet"));

        sellerPrint.setText(getIntent().getStringExtra("sellerPrint3"));
        buyerPrint.setText(getIntent().getStringExtra("buyerPrint3"));


        firstsegment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Favorite.this, first_segment.class);
                startActivity(intent);
            }
        });



        createPDF();


    }




    private void createPDF() {
        create.setOnClickListener(v -> {
            if (
                    sellerName.getText().toString().length() == 0 ||
                            buyerName.getText().toString().length() == 0
            ) {
                Toast.makeText(Favorite.this, "Введите Данные!", Toast.LENGTH_LONG).show();
            } else {
                PdfDocument myPdfDocument = new PdfDocument();
                Paint myPaint = new Paint();
                PdfDocument.PageInfo myPageInfo1 = new PdfDocument.PageInfo.Builder(1200, 2010, 1).create();
                PdfDocument.Page MyPage1 = myPdfDocument.startPage(myPageInfo1);
                Canvas canvas = MyPage1.getCanvas();

                canvas.drawBitmap(scaledbp, 0, 0, myPaint);

                myPaint.setTextAlign(Paint.Align.CENTER);
                myPaint.setTextSize(18);
                myPaint.setColor(Color.BLACK);
                canvas.drawText(" " + number.getText(), 426, 54, myPaint);
                canvas.drawText(" " + from.getText(), 510, 54, myPaint);
                canvas.drawText(" " + month.getText(), 578, 54, myPaint);


                myPaint.setTextAlign(Paint.Align.CENTER);
                myPaint.setTextSize(15);
                myPaint.setColor(Color.BLACK);
                canvas.drawText(" " + year.getText(), 693, 54, myPaint);


                myPaint.setTextAlign(Paint.Align.LEFT);
                myPaint.setTextSize(23);
                myPaint.setColor(Color.BLACK);
                canvas.drawText(" " + sellerName.getText(), 229, 106, myPaint);
                canvas.drawText(" " + buyerName.getText(), 229, 149, myPaint);

                myPaint.setTextAlign(Paint.Align.CENTER);
                myPaint.setTextSize(22);
                myPaint.setColor(Color.BLACK);
                canvas.drawText(" " + qty1.getText(), 667, 322, myPaint);


                canvas.drawText(" " + qty4.getText(), 946, 322, myPaint);

                canvas.drawText(" " + qty6.getText(), 801, 322, myPaint);

                canvas.drawText(" " + qty.getText(), 1094, 322, myPaint);

                myPaint.setTextAlign(Paint.Align.LEFT);
                myPaint.setTextSize(22);
                myPaint.setColor(Color.BLACK);

                canvas.drawText(" " + bill.getText(), 251, 769, myPaint);
                canvas.drawText(" " + sellerPrint.getText(), 240, 819, myPaint);
                canvas.drawText(" " + buyerPrint.getText(), 240, 903, myPaint);
                canvas.drawText(" " + item1spinner.getText(), 340, 320, myPaint);


                // if(item1spinner.getSelectedItemPosition() != 0){
                //       canvas.drawText(item1spinner.getSelectedItem().toString(),340,320,myPaint);
                //  }


                myPdfDocument.finishPage(MyPage1);

                File file = new File(Environment.getExternalStorageDirectory(), "Download/Накладная.pdf");
                try {
                    myPdfDocument.writeTo(new FileOutputStream(file));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(Favorite.this, "PDF создан!", Toast.LENGTH_LONG).show();
                myPdfDocument.close();
            }
        });
    }
}

