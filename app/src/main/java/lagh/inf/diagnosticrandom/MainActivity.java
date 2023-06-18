package lagh.inf.diagnosticrandom;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et= findViewById(R.id.age);
        Button b =findViewById(R.id.b1t);



        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ((et.getText().toString().equals(""))){
                    Toast.makeText(getApplicationContext(), " ادخل قيمة للعمر",Toast.LENGTH_LONG).show();

                }
                else{
                    int a = parseInt(et.getText().toString());
                    if ((a<3)||(a>100))
                    {  Toast.makeText(getApplicationContext(), " ادخل قيمة صالحة للعمر",Toast.LENGTH_LONG).show();}
                    else {

                        if(a>15){
                            Intent i = new Intent(getApplicationContext(), testa.class);
                            i.putExtra("age",a);

                            startActivity(i);

                        }
                        else {Intent i = new Intent(getApplicationContext(), testk.class);
                            i.putExtra("age",a);

                            startActivity(i);}
                    }
                }

            }
        });

    }}