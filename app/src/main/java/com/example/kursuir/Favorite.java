package com.example.kursuir;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Favorite extends AppCompatActivity {
Button create;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        create = findViewById(R.id.createPDF);
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
        createPDF();
    }

    private void createPDF() {
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PdfDocument myPdfDocument = new PdfDocument();
                Paint myPaint = new Paint();
                PdfDocument.PageInfo myPageInfo1 = new PdfDocument.PageInfo.Builder(255,400,1 ).create();
                PdfDocument.Page MyPage1 = myPdfDocument.startPage(myPageInfo1);

                Canvas canvas = MyPage1.getCanvas();

                canvas.drawText("Welcome",40,50,myPaint);
                myPdfDocument.finishPage(MyPage1);
                File file = new File(Environment.getExternalStorageDirectory(),"/First.pdf");
                try {
                    myPdfDocument.writeTo(new FileOutputStream(file));
                } catch (IOException e) {
                    e.printStackTrace();
                }
myPdfDocument.close();
            }
        });
    }
}