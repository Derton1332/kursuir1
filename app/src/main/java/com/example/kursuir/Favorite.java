package com.example.kursuir;

import static com.example.kursuir.R.id.number_edit;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.ibm.icu.text.RuleBasedNumberFormat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

public class Favorite extends AppCompatActivity {
Button create;
Spinner item1spinner,item2spinner;
    TextView sellerName;
    TextView buyerName;
    TextView qty1;

    TextView number;
    TextView year;
    TextView from;
    TextView month;
    TextView buyerPrint;
    TextView sellerPrint;
    TextView qty;
    TextView bill;

    TextView qty3;
    TextView qty4;
    TextView qty5;
    TextView qty6;
    TextView qty7;
Bitmap bmp,scaledbp;
int pageWight = 1200;
int amt, amt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        create = findViewById(R.id.createPDF);
        item1spinner = findViewById(R.id.item1spinner);
        sellerName = findViewById(R.id.sellerName);
        buyerName = findViewById(R.id.buyerName);
        qty1 = findViewById(R.id.qty1);

        number = findViewById(R.id.number);
        year = findViewById(R.id.year);
        from = findViewById(R.id.from);
        month = findViewById(R.id.month);
        buyerPrint = findViewById(R.id.buyerPrint);
        sellerPrint = findViewById(R.id.sellerPrint);

        qty4 = findViewById(R.id.qty4);

        qty6 = findViewById(R.id.qty6);

        qty = findViewById(R.id.qty);
        bill = findViewById(R.id.bill);
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.object);
        scaledbp = Bitmap.createScaledBitmap(bmp,1177,940,false);
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

        createPDF();
        DialogNumber();
        DialogDay();
        DialogMonth();
        DialogYear();
        DialogFIOsell();
        DialogFIObuy();
        Dialogkolich();

        Dialogprice();

        DialogbuyerPrint();
        DialogsellerPrint();
        multiply();

        moneytrans();

    }

//bill.setText(nf.format(mon));

    private void moneytrans() {
        bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mon;
                RuleBasedNumberFormat nf = new RuleBasedNumberFormat(Locale.forLanguageTag("ru"), RuleBasedNumberFormat.SPELLOUT);
                mon = Integer.parseInt(qty.getText().toString());
                bill.setText(nf.format(mon));
            }
        });
    }



    private void multiply() {
        qty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int amt = Integer.parseInt(qty6.getText().toString());
                int amt1 = Integer.parseInt(qty4.getText().toString());
                int multiply;
                multiply = amt * amt1;
                qty.setText("" + multiply);
            }
        });
    }


    private void DialogNumber() {
        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(Favorite.this);
                dialog.setTitle("Введите номер накладной!");
                LayoutInflater inflater = LayoutInflater.from(Favorite.this);
                View editNumber = inflater.inflate(R.layout.edit_text_number, null);
                dialog.setView(editNumber);
                EditText edit = editNumber.findViewById(number_edit);

                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        number.setText(edit.getText());
                    }
                });
                dialog.show();
            }
        });

    }
    private void DialogDay() {
        from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(Favorite.this);
                dialog.setTitle("Введите день!");
                LayoutInflater inflater = LayoutInflater.from(Favorite.this);
                View editNumber = inflater.inflate(R.layout.edit_text_number, null);
                dialog.setView(editNumber);
                EditText edit = editNumber.findViewById(number_edit);

                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        from.setText(edit.getText());
                    }
                });
                dialog.show();
            }
        });

    }
    private void DialogMonth() {
        month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(Favorite.this);
                dialog.setTitle("Введите месяц!");
                LayoutInflater inflater = LayoutInflater.from(Favorite.this);
                View editNumber = inflater.inflate(R.layout.edit_text_number, null);
                dialog.setView(editNumber);
                EditText edit = editNumber.findViewById(number_edit);

                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        month.setText(edit.getText());
                    }
                });
                dialog.show();
            }
        });

    }
    private void DialogYear() {
        year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(Favorite.this);
                dialog.setTitle("Введите год!");
                LayoutInflater inflater = LayoutInflater.from(Favorite.this);
                View editNumber = inflater.inflate(R.layout.edit_text_number, null);
                dialog.setView(editNumber);
                EditText edit = editNumber.findViewById(number_edit);

                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        year.setText(edit.getText());
                    }
                });
                dialog.show();
            }
        });

    }
    private void DialogFIOsell() {
        sellerName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(Favorite.this);
                dialog.setTitle("Введите ФИО продавца!");
                LayoutInflater inflater = LayoutInflater.from(Favorite.this);
                View editNumber = inflater.inflate(R.layout.edit_text_number, null);
                dialog.setView(editNumber);
                EditText edit = editNumber.findViewById(number_edit);

                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sellerName.setText(edit.getText());
                    }
                });
                dialog.show();
            }
        });

    }
    private void DialogFIObuy() {
        buyerName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(Favorite.this);
                dialog.setTitle("Введите ФИО покупателя!");
                LayoutInflater inflater = LayoutInflater.from(Favorite.this);
                View editNumber = inflater.inflate(R.layout.edit_text_number, null);
                dialog.setView(editNumber);
                EditText edit = editNumber.findViewById(number_edit);

                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        buyerName.setText(edit.getText());
                    }
                });
                dialog.show();
            }
        });

    }
    private void Dialogkolich() {
        qty6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(Favorite.this);
                dialog.setTitle("Введите количество товара!");
                LayoutInflater inflater = LayoutInflater.from(Favorite.this);
                View editNumber = inflater.inflate(R.layout.edit_text_number, null);
                dialog.setView(editNumber);
                EditText edit = editNumber.findViewById(number_edit);

                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        qty6.setText(edit.getText());
                    }
                });
                dialog.show();
            }
        });

    }

    private void Dialogprice() {
        qty4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(Favorite.this);
                dialog.setTitle("Введите цену товара!");
                LayoutInflater inflater = LayoutInflater.from(Favorite.this);
                View editNumber = inflater.inflate(R.layout.edit_text_number, null);
                dialog.setView(editNumber);
                EditText edit = editNumber.findViewById(number_edit);

                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        qty4.setText(edit.getText());
                    }
                });
                dialog.show();
            }
        });

    }

    private void DialogbuyerPrint() {
        buyerPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(Favorite.this);
                dialog.setTitle("Введите  ФИО продавца!");
                LayoutInflater inflater = LayoutInflater.from(Favorite.this);
                View editNumber = inflater.inflate(R.layout.edit_text_number, null);
                dialog.setView(editNumber);
                EditText edit = editNumber.findViewById(number_edit);

                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        buyerPrint.setText(edit.getText());
                    }
                });
                dialog.show();
            }
        });

    }
    private void DialogsellerPrint() {
        sellerPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(Favorite.this);
                dialog.setTitle("Введите ФИО покупателя!");
                LayoutInflater inflater = LayoutInflater.from(Favorite.this);
                View editNumber = inflater.inflate(R.layout.edit_text_number, null);
                dialog.setView(editNumber);
                EditText edit = editNumber.findViewById(number_edit);

                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sellerPrint.setText(edit.getText());
                    }
                });
                dialog.show();
            }
        });

    }

    private void createPDF() {
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sellerName.getText().toString().length()==0||
                buyerName.getText().toString().length()==0||
                qty1.getText().toString().length()==0)


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
                    myPaint.setTextSize(18);
                    myPaint.setColor(Color.BLACK);
                    canvas.drawText(" "+number.getText(),426,54,myPaint);
                    canvas.drawText(" "+from.getText(),510,54,myPaint);
                    canvas.drawText(" "+month.getText(),578,54,myPaint);


                    myPaint.setTextAlign(Paint.Align.CENTER);
                    myPaint.setTextSize(15);
                    myPaint.setColor(Color.BLACK);
                    canvas.drawText(" "+year.getText(),693,54,myPaint);


                    myPaint.setTextAlign(Paint.Align.LEFT);
                    myPaint.setTextSize(23);
                    myPaint.setColor(Color.BLACK);
                    canvas.drawText(" "+sellerName.getText(),229,106,myPaint);
                    canvas.drawText(" "+buyerName.getText(),229,149,myPaint);

                    myPaint.setTextAlign(Paint.Align.CENTER);
                    myPaint.setTextSize(22);
                    myPaint.setColor(Color.BLACK);
                    canvas.drawText(" "+qty1.getText(),667,322,myPaint);


                    canvas.drawText(" "+qty4.getText(),946,322,myPaint);

                    canvas.drawText(" "+qty6.getText(),801,322,myPaint);

                    canvas.drawText(" "+qty.getText(),1094,322,myPaint);

                    myPaint.setTextAlign(Paint.Align.LEFT);
                    myPaint.setTextSize(22);
                    myPaint.setColor(Color.BLACK);

                    canvas.drawText(" "+bill.getText(),251,769,myPaint);
                    canvas.drawText(" "+sellerPrint.getText(),240,819,myPaint);
                    canvas.drawText(" "+buyerPrint.getText(),240,903,myPaint);

                    if(item1spinner.getSelectedItemPosition() != 0){
                        canvas.drawText(item1spinner.getSelectedItem().toString(),340,320,myPaint);
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