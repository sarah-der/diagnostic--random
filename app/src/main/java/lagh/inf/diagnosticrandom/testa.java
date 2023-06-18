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
    String stuttering ="هل تشعر بالتوتر أو القلق قبل الكلام؟ هل تشعر بتوتر عضلي في منطقة الوجه أو الفك أثناء محاولة التحدث؟هل تعاني من تكرار الكلمات أو الأصوات الصوتية؟هل تجد صعوبة في الكلام عندما تكون في حالة من الانفعال أو الحماسة؟هل تشعر بأن الكلام يتوقف أو يعلق في الحلق أثناء المحاولة للتحدث؟هل تشعر بتوتر عضلي في منطقة الوجه أو الفك أثناء محاولة التحدث؟";
    String autism="هل تلاحظ صعوبة في التفاعل الاجتماعي والتواصل العاطفي مع الآخرين؟هل تجد صعوبة في فهم وتفسير العبارات الغير مباشرة؟هل تشعر بالرغبة في الالتفاف على المواعيد المحددة؟هل تشعر بالحساسية الزائدة تجاه الأصوات أو الروائح أو الأضواء أو الأطعمة؟هل لديك اهتمامات غير عادية ومحدودة في مجالات معينة، وتفضل التركيز على هذه الاهتمامات؟ هل تلاحظ صعوبة في فهم واستيعاب مشاعر الآخرين وتفسيرها؟هل تجد صعوبة في إقامة  صداقات وعلاقات الاجتماعية؟هل تظهر لديك حركات متكررة أو إيقاعات غير عادية في الجسم؟هل تعاني من تأخر في اكتساب المهارات اللغوية والاجتماعية المناسبة لعمرك؟";
    String schizo="هل تعاني من سماع أصوات غير موجودة أو رؤية أشخاص أو أشياء غير حاضرة؟هل تعاني من الاعتقادات الغير منطقية   ؟هل تشعر بصعوبة في التركيز أو الانتباه لفترات طويلة؟ هل تظهر لديك تغيرات في المشاعر والعواطف، مثل انخفاض في الشعور بالمتعة أو  شعور زائد بالتوتر أو القلق؟هل تشعر بالشك والاعتقاد بأن الآخرين يؤامرون عليك أو يخططون للضرر بك ؟ هل تعاني من انحراف السلوك أو السلوك الغير منتظم أو العنف غير المبرر؟";
    String deprission="هل تشعر بالحزن الشديد لمعظم أيام الأسبوع؟هل فقدت الاهتمام  في الأنشطة التي كنت تستمتع بها في الماضي؟  هل لديك انخفاض في مستوى الطاقة ؟هل تعاني من صعوبة في النوم، مثل الأرق أو النوم الزائد؟هل لديك تغيرات في الشهية أو الوزن؟ هل تشعر بالقلق أو الاستياء بشكل متكرر؟هل تشعر بالشعور بالذنب بشكل زائد؟هل لديك أفكار متكررة عن الموت أو الانتحار؟هل تشعر بالانعزالية ؟";
    /* adult questions */


    ArrayList<String> qstdeprission=  question.remplir(deprission);
    ArrayList<String>  qstshizo=  question.remplir(schizo);
    ArrayList<String> qstautism=  question.remplir(autism);
    ArrayList<String> qststuttering=  question.remplir(stuttering);
    /* fill kid questions in arrays*/


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
        //get the age
        Intent intent = getIntent();
        int value1 = intent.getIntExtra("age",18);


        /*choose one randome qusetion from the test questions to show it at first */

        ArrayList<String> testqst = question.testqst( qstdeprission, qstshizo,qstautism,qststuttering);
        String value= testqst.get(j);
        ArrayList<Boolean>  yes= new ArrayList<>();
        String complet=(1+"/"+(12));
        //creating a table to save the questions that has been showed in the interface
        ArrayList<String> testqsttable = new ArrayList<>();
        testqsttable.add(value);
        /*interface compenent declaration */
        Button nextb=findViewById(R.id.nextd);
        Button restart=findViewById(R.id.restarttesta);
        Button pvqst=findViewById(R.id.prvqsta);
        RadioGroup radioGroup =findViewById(R.id.radioGroupd);
        ts=(TextView) findViewById(R.id.tsd);
        ta=(TextView ) findViewById(R.id.tad);
        ts.setText(complet);
        ta.setText(value);
        ArrayList <String>  illness =  new ArrayList<>() ;
        /*score of the qst*/
        if(j<1){pvqst.setEnabled(false);}


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

                   pvqst.setEnabled(true);
                    r++;
                    /*calculating the score of each illness*/
                    if (((RadioButton)findViewById(R.id.rd2)).isChecked())
                    {yes.add(true);
                    if ( qstdeprission.contains(testqst.get(j)))
                    {   scored++;
                        System.out.println("score deprission is"+scored);}
                    if ( qstshizo.contains(testqst.get(j)))
                    {   scores++;
                        System.out.println("score  shizo is"+scores);}
                    if ( qstautism.contains(testqst.get(j)))
                    {   scorea++;
                        System.out.println("score  autisme is"+scorea);}
                    if ( qststuttering.contains(testqst.get(j)))
                    {   scorest++;
                        System.out.println("score  stuttering is"+scorest);}
                    }
                    else {yes.add(false);}



                    //get the max score + the result if  all questions are answered
                    if (r==12)
                    {
                        ArrayList<Integer> scoress= new ArrayList<>();
                        scoress.add(scored);
                        scoress.add(scorea);
                        scoress.add(scores);
                        scoress.add(scorest);
                        int maxcount=0;
                        //get the max score
                        int maxValue =   Collections.max(scoress);
                        //count the number of equal scores with the max value
                        for (int score : scoress) {
                            if (score == maxValue) {
                                maxcount++;
                            }
                        }

                        if (maxcount >2)
                        {   // If more than two scores are equal to the max value
                            // Restart the test
                            Toast.makeText(getApplicationContext(), " اعد الاختبار ", Toast.LENGTH_SHORT).show();
                            recreate();
                        }
                        //else show the result
                        else {

                            String value ;
                            Intent resulta = new Intent(getApplicationContext(),result.class);
                            resulta.putExtra("qsttable",testqsttable);
                            resulta.putExtra("answers",yes);
                            if (maxValue == scored) {
                                System.out.println("deprission");
                                illness.add("اكتئاب");
                                resulta.putExtra("specialist1","مختص في الأمراض العقلية");
                                resulta.putExtra("specialist3","مختص نفساني ");

                            }
                            if (maxValue == scorea) {
                                System.out.println("autism");
                                illness.add("توحد");
                                resulta.putExtra("specialist1","مختص في الأمراض العقلية");
                                resulta.putExtra("specialist2", "مختص أرطوفوني");
                                resulta.putExtra("specialist3", "مختص نفساني ");

                            }
                            if (maxValue == scores) {
                                System.out.println("shizo");
                                illness.add("فصام");
                                resulta.putExtra("specialist1","مختص في الأمراض العقلية");
                                resulta.putExtra("specialist3"," مختص نفساني  ");
                                 }
                            if (maxValue == scorest){
                                System.out.println("stutring");
                                illness.add("تأتأة");
                                resulta.putExtra("specialist2","مختص أرطفوني");
                                }
                            resulta.putExtra("age",value1);
                            resulta.putExtra("illness",illness);

                            startActivity(resulta);

                        }
                    }



                    if(j<11)
                    {
                        j++;
                        testqsttable.add(j,testqst.get(j));
                        ta.setText(testqst.get(j));
                        String complet=((j+1)+"/"+(12));
                        ts.setText(complet);
                        }



                    radioGroup.clearCheck();
                 }



    }});
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (j > 0) {

                    recreate(); }
                else{Toast.makeText(getApplicationContext(), "اجب عن سؤال واحد على الأقل", Toast.LENGTH_SHORT).show();}

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
                    if ( qstdeprission.contains(q))
                    {   scored--;
                        System.out.println("score deprission is"+scored);}
                    if ( qstshizo.contains(q))
                    {   scores--;
                        System.out.println("score  shizo is"+scores);}
                    if ( qstautism.contains(q))
                    {   scorea--;
                        System.out.println("score  autisme is"+scorea);}
                    if ( qststuttering.contains(q))
                    {   scorest--;
                        System.out.println("score  stuttering is"+scorest);}}
                    ta.setText(q);
                    radioGroup.clearCheck();
                    if(j==0){pvqst.setEnabled(false);}  }
                r--;}

        });}
}
