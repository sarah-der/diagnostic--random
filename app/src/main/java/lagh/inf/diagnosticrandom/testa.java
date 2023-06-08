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


public class testa extends AppCompatActivity {


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
        setContentView(R.layout.activity_testa);

        /*choose one randome qusetion from the test questions to show it at first */

        ArrayList<String> testqst = question.testqst(question.qstdeprission,question.qstshizo,question.qstautism,question.qststuttering);
        String value= testqst.get(j);
        String complet=(0+"/"+(12));

        /*interface compenent declaration */
        Button nextb=findViewById(R.id.nextd);
        Button restart=findViewById(R.id.restarttesta);
        RadioGroup radioGroup =findViewById(R.id.radioGroupd);
        ts=(TextView) findViewById(R.id.tsd);
        ta=(TextView ) findViewById(R.id.tad);
        ts.setText(complet);
        ta.setText(value);
        /*score of the qst*/



        /*button function :calculating the score of each illness*/
        nextb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                int selectedRadioButtonId =  radioGroup.getCheckedRadioButtonId();

                if (selectedRadioButtonId == -1) {
                    // No radio button is checked
                    Toast.makeText(getApplicationContext(), "اختر اجابة", Toast.LENGTH_SHORT).show();
                }
                else {
                    if ((((RadioButton)findViewById(R.id.rd2)).isChecked())&&(question.qstdeprission.contains(testqst.get(j))))
                    {   scored++;
                        System.out.println("score deprission is"+scored);}
                    if ((((RadioButton)findViewById(R.id.rd2)).isChecked())&&(question.qstshizo.contains(testqst.get(j))))
                    {   scores++;
                        System.out.println("score  shizo is"+scores);}
                    if ((((RadioButton)findViewById(R.id.rd2)).isChecked())&&(question.qstautism.contains(testqst.get(j))))
                    {   scorea++;
                        System.out.println("score  autisme is"+scorea);}
                    if ((((RadioButton)findViewById(R.id.rd2)).isChecked())&&(question.qststuttering.contains(testqst.get(j))))
                    {   scorest++;
                        System.out.println("score  stuttering is"+scorest);}
                    r++;

                    /*calculating the score of each illness*/
                    if (r==12){

                        ArrayList<Integer> scoress= new ArrayList<>();
                        scoress.add(scored);
                        scoress.add(scorea);
                        scoress.add(scores);
                        scoress.add(scorest);
                        //get the max score
                        int maxValue =  Collections.max(scoress);
                        if (((scored == scorea )&&( maxValue==scorea))||(( scored == scores)&&( maxValue==scores)) ||(( scored == scorest)&&( maxValue==scores))  ||
                                (( scorea == scores)&&( maxValue==scores))  || ((scorea == scorest)&&( maxValue==scores))  ||
                                ((scores == scorest)&&( maxValue==scores)) )  {
                            // If two or more scores have the same value, and the maximum value is equal to that shared value
                            // Restart the test
                             Toast.makeText(getApplicationContext(), "اعد الاختبار", Toast.LENGTH_SHORT).show();
                                 recreate();}


                    else {
                            // Show the result based on the max value
                                 if (maxValue == scored) {
                                     // Handle "depression" case
                                     // Start the result activity with appropriate extras
                                     System.out.println("deprission");
                                     Intent resulta = new Intent(getApplicationContext(),result.class);
                                     resulta.putExtra("specialist1","مختص في الأمراض العقلية");
                                     resulta.putExtra("specialist2","مختص نفساني ");
                                     startActivity(resulta);
                                 } else
                                 {if (maxValue == scorea) {
                                     // Handle "autism" case
                                     // Start the result activity with appropriate extras
                                     System.out.println("autism");
                                     Intent resulta = new Intent(getApplicationContext(),result.class);
                                     resulta.putExtra("specialist1","مختص في الأمراض العقلية");
                                     resulta.putExtra("specialist2", "مختص أرطوفوني");
                                     resulta.putExtra("specialist3", "مختص نفساني ");
                                     startActivity(resulta);
                                 } else{
                                     if (maxValue == scores) {
                                         // Handle "shizo" case
                                         // Start the result activity with appropriate extras
                                         System.out.println("shizo");
                                         Intent resulta = new Intent(getApplicationContext(),result.class);
                                         resulta.putExtra("specialist1","مختص في الأمراض العقلية");
                                         resulta.putExtra("specialist2"," مختص نفساني  ");
                                         startActivity(resulta);}
                                     else {
                                         // Handle "stutring" case
                                         // Start the result activity with appropriate extras
                                         System.out.println("stutring");
                                         Intent resulta = new Intent(getApplicationContext(),result.class);
                                         resulta.putExtra("specialist1","مختص أرطفوني");
                                         startActivity(resulta);}
                                 }}}}


                    if(j<11)
                    {
                        j++;
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
}
    }