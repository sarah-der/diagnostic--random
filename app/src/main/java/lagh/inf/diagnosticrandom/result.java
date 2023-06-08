package lagh.inf.diagnosticrandom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        String value1 = intent.getStringExtra("specialist1");
        String value2 = intent.getStringExtra("specialist2");
        String value3 = intent.getStringExtra("specialist3");
        TextView sp1= findViewById(R.id.t1);
        TextView sp2= findViewById(R.id.t2);
        TextView sp3= findViewById(R.id.t3);
        LinearLayout l1 = findViewById(R.id.l1);
        LinearLayout l2 = findViewById(R.id.l2);
        LinearLayout l3 = findViewById(R.id.l3);
        if(value1==null){ l1.setVisibility(View.GONE);}
        else{sp1.setText(value1);}
        if(value2==null){ l2.setVisibility(View.GONE);}
        else{sp2.setText(value2);}
        if(value3==null){ l3.setVisibility(View.GONE);}
        else{sp3.setText(value3);}
}}