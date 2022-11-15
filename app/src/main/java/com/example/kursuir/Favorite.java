package com.example.kursuir;

import android.Manifest;
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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Favorite extends AppCompatActivity {
Button create;
Spinner item1spinner,item2spinner;
EditText sellerName, buyerName, qty1,qty2,number,year,from,month,buyerPrint,sellerPrint,qty,bill,cop,qty3,qty4,qty5,qty6,qty7;
Bitmap bmp,scaledbp;
int pageWight = 1200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        create = findViewById(R.id.createPDF);
        item1spinner = findViewById(R.id.item1spinner);
        item2spinner = findViewById(R.id.item2spinner);
        sellerName = findViewById(R.id.sellerName);
        buyerName = findViewById(R.id.buyerName);
        qty1 = findViewById(R.id.qty1);
        qty2 = findViewById(R.id.qty2);
        number = findViewById(R.id.number);
        year = findViewById(R.id.year);
        from = findViewById(R.id.from);
        month = findViewById(R.id.month);
        buyerPrint = findViewById(R.id.buyerPrint);
        sellerPrint = findViewById(R.id.sellerPrint);
        qty3 = findViewById(R.id.qty3);
        qty4 = findViewById(R.id.qty4);
        qty5 = findViewById(R.id.qty5);
        qty6 = findViewById(R.id.qty6);
        qty7 = findViewById(R.id.qty7);
        qty = findViewById(R.id.qty);
        bill = findViewById(R.id.bill);
        cop = findViewById(R.id.cop);



        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.object);
        scaledbp = Bitmap.createScaledBitmap(bmp,1177,940,false);
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
        createPDF();
    }

    private void createPDF() {
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sellerName.getText().toString().length()==0||
                buyerName.getText().toString().length()==0||
                qty1.getText().toString().length()==0||
                        qty2.getText().toString().length()==0)


                {
                    Toast.makeText(Favorite.this,"Введите Данные!",Toast.LENGTH_LONG).show();
                }
                else {
                    PdfDocument myPdfDocument = new PdfDocument();
                    Paint myPaint = new Paint();
                    PdfDocument.PageInfo myPageInfo1 = new PdfDocument.PageInfo.Builder(1200, 2010, 1).create();
                    PdfDocument.Page MyPage1 = myPdfDocument.startPage(myPageInfo1);
                    Canvas canvas = MyPage1.getCanvas();

                    canvas.drawBitmap(scaledbp,0,0,myPaint);

                    myPaint.setTextAlign(Paint.Align.CENTER);
                    myPaint.setTextSize(22);
                    myPaint.setColor(Color.BLACK);
                    canvas.drawText(" "+number.getText(),426,54,myPaint);
                    canvas.drawText(" "+from.getText(),510,54,myPaint);
                    canvas.drawText(" "+month.getText(),578,54,myPaint);
                    canvas.drawText(" "+year.getText(),695,54,myPaint);


                    myPaint.setTextAlign(Paint.Align.LEFT);
                    myPaint.setTextSize(23);
                    myPaint.setColor(Color.BLACK);
                    canvas.drawText(" "+sellerName.getText(),229,106,myPaint);
                    canvas.drawText(" "+buyerName.getText(),229,149,myPaint);

                    myPaint.setTextAlign(Paint.Align.CENTER);
                    myPaint.setTextSize(22);
                    myPaint.setColor(Color.BLACK);
                    canvas.drawText(" "+qty1.getText(),667,322,myPaint);
                    canvas.drawText(" "+qty2.getText(),667,350,myPaint);
                    canvas.drawText(" "+qty3.getText(),801,350,myPaint);
                    canvas.drawText(" "+qty4.getText(),946,322,myPaint);
                    canvas.drawText(" "+qty5.getText(),946,350,myPaint);
                    canvas.drawText(" "+qty6.getText(),801,322,myPaint);
                    canvas.drawText(" "+qty7.getText(),1094,350,myPaint);
                    canvas.drawText(" "+qty.getText(),1094,322,myPaint);

                    myPaint.setTextAlign(Paint.Align.LEFT);
                    myPaint.setTextSize(22);
                    myPaint.setColor(Color.BLACK);

                    canvas.drawText(" "+bill.getText(),251,774,myPaint);
                    canvas.drawText(" "+cop.getText(),1090,774,myPaint);
                    canvas.drawText(" "+sellerPrint.getText(),240,819,myPaint);
                    canvas.drawText(" "+buyerPrint.getText(),240,903,myPaint);

                    if(item1spinner.getSelectedItemPosition() != 0){
                        canvas.drawText(item1spinner.getSelectedItem().toString(),340,320,myPaint);
                    }
                    if(item2spinner.getSelectedItemPosition() != 0){
                        canvas.drawText(item2spinner.getSelectedItem().toString(),340,346,myPaint);
                    }


                    myPdfDocument.finishPage(MyPage1);

                    File file = new File(Environment.getExternalStorageDirectory(), "Download/Накладная.pdf");
                    try {
                        myPdfDocument.writeTo(new FileOutputStream(file));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(Favorite.this,"PDF создан!",Toast.LENGTH_LONG).show();
                    myPdfDocument.close();
                }
            }
        });
    }

}