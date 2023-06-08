package lagh.inf.diagnosticrandom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;


public class testk extends AppCompatActivity {


    TextView ta,ts ;

    int r =0 ;
    int scored = 0;
    int scorea = 0;
    int scores = 0;
    int scorest = 0;
    int j=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testk);

        /*choose one randome qusetion from the test questions to show it at first */

        ArrayList<String> testqst = question.testqst(question.qstdeprissionkid,question.qstshizokid,question.qstautismkid,question.qststutteringkid);
        String value= testqst.get(j);
        String complet=(0+"/"+(12));
        ArrayList<Boolean>  yes= new ArrayList<>();
        //creating a table to save the questions that has been showed in the interface
        ArrayList<String> testqsttable = new ArrayList<>();
        testqsttable.add(value);

        /*interface compenent declaration */
        Button nextb=findViewById(R.id.nextk);
        Button restart=findViewById(R.id.restarttestk);
        RadioGroup radioGroup =findViewById(R.id.radioGroupk);
        Button pvqst=findViewById(R.id.prvqstk);
        ts=(TextView) findViewById(R.id.tsk);
        ta=(TextView ) findViewById(R.id.tak);
        ts.setText(complet);
        ta.setText(value);
        if(j<1){pvqst.setEnabled(false);}



        /*button function */
        nextb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                int selectedRadioButtonId =  radioGroup.getCheckedRadioButtonId();

                if (selectedRadioButtonId == -1) {
                    // No radio button is checked
                    Toast.makeText(getApplicationContext(), "اختر اجابة", Toast.LENGTH_SHORT).show();
                }
                else {
                    /*calculating the score of each illness*/
                    pvqst.setEnabled(true);
                    r++;

                    if (((RadioButton)findViewById(R.id.rk2)).isChecked()){yes.add(true);
                        if (question.qstdeprissionkid.contains(testqst.get(j)))
                        {   scored++;
                            System.out.println("score deprission is"+scored);}
                        if (question.qstshizokid.contains(testqst.get(j)))
                        {   scores++;
                            System.out.println("score  shizo is"+scores);}
                        if (question.qstautismkid.contains(testqst.get(j)))
                        {   scorea++;
                            System.out.println("score  autisme is"+scorea);}
                        if (question.qststutteringkid.contains(testqst.get(j)))
                        {   scorest++;
                            System.out.println("score  stuttering is"+scorest);}}
                    else {yes.add(false);}
                    r++;

                    //get the max score + the result
                    if (r==12){

                        ArrayList<Integer> scoress= new ArrayList<>();
                        scoress.add(scored);
                        scoress.add(scorea);
                        scoress.add(scores);
                        scoress.add(scorest);

                         //get the max score
                        int maxValue =   Collections.max(scoress);
                        if (((scored == scorea )&&( maxValue==scorea))||(( scored == scores)&&( maxValue==scores)) ||(( scored == scorest)&&( maxValue==scores))  ||
                                (( scorea == scores)&&( maxValue==scores))  || ((scorea == scorest)&&( maxValue==scores))  ||
                                ((scores == scorest)&&( maxValue==scores)) )  {
                            // If two or more scores have the same value, and the maximum value is equal to that shared value
                            // Restart the test
                            Toast.makeText(getApplicationContext(), "اعد الاختبار", Toast.LENGTH_SHORT).show();
                            recreate();}


                            else {
                                //else show the result
                                if (maxValue == scored) {
                                    System.out.println("deprission");
                                    Intent resulta = new Intent(getApplicationContext(),result.class);
                                    resulta.putExtra("specialist1","مختص في الأمراض العقلية");
                                    resulta.putExtra("specialist2","مختص نفساني ");
                                    startActivity(resulta);
                                } else
                                {if (maxValue == scorea) {
                                    System.out.println("autism");
                                    Intent resulta = new Intent(getApplicationContext(),result.class);
                                    resulta.putExtra("specialist1","مختص في الأمراض العقلية");
                                    resulta.putExtra("specialist2", "مختص أرطوفوني");
                                    resulta.putExtra("specialist3", "مختص نفساني ");
                                    startActivity(resulta);
                                } else{
                                    if (maxValue == scores) {
                                        System.out.println("shizo");
                                        Intent resulta = new Intent(getApplicationContext(),result.class);
                                        resulta.putExtra("specialist1","مختص في الأمراض العقلية");
                                        resulta.putExtra("specialist2"," مختص نفساني  ");
                                        startActivity(resulta);}
                                    else {
                                        System.out.println("stutring");
                                        Intent resulta = new Intent(getApplicationContext(),result.class);
                                        resulta.putExtra("specialist1","مختص أرطفوني");
                                        startActivity(resulta);}
                                }}}}


                    if(j<11)
                    {
                        j++;
                        testqsttable.add(j,testqst.get(j));
                        ta.setText(testqst.get(j));
                        String complet=((j)+"/"+(12));
                        ts.setText(complet);
                    }



                    radioGroup.clearCheck();
                }



            }});
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recreate();
            }
        });
        pvqst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(j<1){pvqst.setEnabled(false);}
                else
                {  j--;
                    String complet=((j)+"/"+(12));
                    ts.setText(complet);
                    String q =testqsttable.get(j);
                    if (yes.get(j)){
                        if (question.qstdeprissionkid.contains(q))
                        {   scored--;
                            System.out.println("score deprission is"+scored);}
                        if (question.qstshizokid.contains(q))
                        {   scores--;
                            System.out.println("score  shizo is"+scores);}
                        if (question.qstautismkid.contains(q))
                        {   scorea--;
                            System.out.println("score  autisme is"+scorea);}
                        if (question.qststutteringkid.contains(q))
                        {   scorest--;
                            System.out.println("score  stuttering is"+scorest);}}
                    ta.setText(q);
                    radioGroup.clearCheck();
                    if(j==0){pvqst.setEnabled(false);}  }
                r--;}

        });}
    }

