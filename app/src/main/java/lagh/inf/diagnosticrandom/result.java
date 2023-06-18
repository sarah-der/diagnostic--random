package lagh.inf.diagnosticrandom;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.pdf.PdfDocument;
import android.graphics.pdf.PdfDocument.Page;
import android.graphics.pdf.PdfDocument.PageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class result extends AppCompatActivity {

    private static final int CREATE_FILE_REQUEST_CODE = 2;
    private static final String FILE_NAME = "result.pdf";

    private ArrayList<String> questions;
    private ArrayList<Boolean> answers;
    private ArrayList<String> illness;
    TextView ill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //get extra from intent
        Intent intent = getIntent();
        String value1 = intent.getStringExtra("specialist1");
        String value2 = intent.getStringExtra("specialist2");
        String value3 = intent.getStringExtra("specialist3");

        questions =   intent.getStringArrayListExtra("qsttable");
        answers = (ArrayList<Boolean>) intent.getSerializableExtra("answers");
        illness =  intent.getStringArrayListExtra("illness");
        //view component declaration
        Button qst_answer_pdf;
        ill= findViewById(R.id.ill);
        TextView sp1= findViewById(R.id.t1);
        TextView sp2= findViewById(R.id.t2);
        TextView sp3= findViewById(R.id.t3);
        LinearLayout l1 = findViewById(R.id.l1);
        LinearLayout l2 = findViewById(R.id.l2);
        LinearLayout l3 = findViewById(R.id.l3);
         //
        String intro ="";
        if (illness!=null){
          intro="حسب احاباتك السايقة قد تعاني من  "+illness.get(0);
        for (int i=1;i<illness.size();)
        {  intro=intro+" أو "+illness.get(i);
            i++;}}
        ill.setText(intro);


        if(value1==null) {l1.setVisibility(View.GONE);}
        else{sp1.setText(value1);}
        if(value2==null){ l2.setVisibility(View.GONE);}
        else{sp2.setText(value2);}
        if(value3==null){ l3.setVisibility(View.GONE);}
        else{sp3.setText(value3);}
        qst_answer_pdf = findViewById(R.id.qst_answer_pdf);



        qst_answer_pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPdfDocument();
            }
        });
    }

    private void createPdfDocument() {
        Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent.setType("application/pdf");
        intent.putExtra(Intent.EXTRA_TITLE, FILE_NAME);
        startActivityForResult(intent, CREATE_FILE_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CREATE_FILE_REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null && data.getData() != null) {
                Uri uri = data.getData();
                try {
                    ParcelFileDescriptor pfd = getContentResolver().openFileDescriptor(uri, "w");
                    if (pfd != null) {
                        //get the short explanation + the age
                        Intent intent = getIntent();
                        int age = intent.getIntExtra("age",10);
                        ill= findViewById(R.id.ill);
                        //creating the pdf
                        FileOutputStream fileOutputStream = new FileOutputStream(pfd.getFileDescriptor());
                        PdfDocument pdf = new PdfDocument();
                        PageInfo pageInfo = new PageInfo.Builder(595, 842, 1).create();
                        Page page = pdf.startPage(pageInfo);
                        Canvas canvas = page.getCanvas();

                        Paint paint = new Paint();

                        float startX = 0; // Starting X-coordinate position
                        float startY = 0; // Starting Y-coordinate position
                        float cellHeight = 25; // Height of each table cell
                        // Load or create the Bitmap image
                        Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.irshade);

                          // Define the destination rectangle for the image
                        float imageX = 0; // X-coordinate position of the image
                        float imageY =0; // Y-coordinate position of the image
                        float imageWidth = 595; // Width of the image
                        float imageHeight = 100; // Height of the image
                        Rect destRect = new Rect((int) imageX, (int) imageY, (int) (imageX + imageWidth), (int) (imageY + imageHeight));

                        // Draw the image within the destination rectangle

                        canvas.drawBitmap(imageBitmap, null, destRect, paint);

                        // Adjust the starting position after drawing the image
                        startY +=  imageY + imageHeight +100;
                        //drawing the initial diagnosis + the age
                        Paint paint2 = new Paint();
                        paint2.setColor(Color.BLACK);
                        paint2.setTextSize(24f);
                        paint2.setTextAlign(Paint.Align.RIGHT);
                        startX=590;
                        canvas.drawText("التشخيص الأولي "+":", startX, startY, paint2);
                        startY+=25;
                        paint2.setTextSize(20f);
                        paint2.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText("العمر"+":"+age, startX, startY, paint2);
                        startY+=25;
                        paint2.setTextSize(20f);
                        paint2.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText("النتيجة"+":"+(String) ill.getText(), startX, startY, paint2);
                        startY+=70;
                        startX=70;

                        float x = startX;
                        float y = startY ;
                        paint2.setTextAlign(Paint.Align.RIGHT);
                        String answer = "الأجوبة"+":";
                        canvas.drawText(answer, x, y, paint2);
                        // Draw the answer in the second column
                        x +=  510f;
                        paint2.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText( "الأسئلة"+":", x, y,paint2);
                        startX=30;
                        paint2.setTextSize(16f);
                        for (int i = 0; i < questions.size(); i++) {
                             x = startX;
                             y = startY + (i+1) * cellHeight;

                            // Draw the question in the first column
                            paint2.setTextAlign(Paint.Align.RIGHT);
                            answer = answers.get(i) ? "نعم" : "لا";
                            canvas.drawText(answer, x, y, paint2);
                            // Draw the answer in the second column
                            x +=  550f;
                            paint2.setTextAlign(Paint.Align.RIGHT);
                            canvas.drawText(questions.get(i), x, y,paint2);

                        }
                      /*  startY=y+25;
                        paint2.setTextSize(20f);
                        paint2.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText("شرح حالة المريض"+":", 590, startY, paint2);
                        startY+=25;
                        paint2.setTextSize(16);
                        paint2.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(ex, 590, startY, paint2);*/

                        pdf.finishPage(page);
                        pdf.writeTo(fileOutputStream);
                        pdf.close();

                        Toast.makeText(getApplicationContext(), "PDF document created successfully", Toast.LENGTH_SHORT).show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Failed to create PDF document", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
