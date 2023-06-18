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
        //get the age
        Intent intent = getIntent();
        int value1 = intent.getIntExtra("age",10);
          /* kid questions */
        String stutteringkid ="هل يواجه الطفل صعوبة في بدء الكلام أو التفوه بالكلمات بشكل سلس؟ هل يحدث تكرار أو تقطيع في الكلام لدى الطفل بشكل مستمر؟ هل تظهر عند الطفل جهود ملحوظة للتحكم في التكرار أو التقطيع في الكلام؟هل يعاني الطفل من التأتأة في أجزاء محددة من الكلام، مثل تكرار مقاطع أو حروف معينة؟ هل يعاني الطفل من توتر أو قلق؟";
        String autismkid="هل يظهر لدى الطفل صعوبة في التواصل اللفظي وغير اللفظي؟ هل يعاني الطفل من صعوبة في التفاعل الاجتماعي وإقامة علاقات مع الآخرين؟ هل يتجاهل الطفل محاولات التواصل الاجتماعي من الآخرين؟ هل يظهر الطفل اهتمامًا غير طبيعي ومحدودًا بألعاب أو أجزاء من الأشياء بدلاً من اللعب الاجتماعي؟ هل يلجأ الطفل إلى الأنشطة المتكررة والروتينية بشكل ملحوظ ويشعر بالقلق من التغييرات في الروتين؟ هل يظهر الطفل اهتمامًا محدودًا بمشاركة الاهتمامات والمشاعر والإنجازات مع الآخرين؟ هل يصاحب الطفل حساسية غير عادية تجاه الأصوات أو الروائح أو الأطعمة أو اللمس؟ هل يتكرر لدى الطفل السلوك الحركي المتكرر، مثل ترتد الجسم أو تلوي اليدين؟ هل يعاني الطفل من تأخر في اكتساب المهارات اللغوية والاجتماعية المناسبة لعمره؟ هل يشعر الطفل بالقلق أو الضغط في مواقف اجتماعية ويظهر استجابات توترية غير عادية؟";
        String schizokid="هل ينحرف الطفل في اهتمامه وتركيزه ويبدو غير متصل في حديثه؟ هل تشاهد سلوكيات غير اعتيادية لدى الطفل، مثل الانعزال أو التوتر الزائد؟ هل يلاحظ تغيرات في المزاج والنوم لدى الطفل؟ هل تلاحظ انخفاضًا في أداء الطفل العام وقدرته على التواصل الاجتماعي؟ هل يبدو الطفل غير مهتم بالأنشطة الاجتماعية المعتادة؟ هل تشعر بالقلق بشأن تغيرات في الشهية والوزن لدى الطفل؟ هل يظهر الطفل عدم الثقة في الآخرين والشك في نواياهم؟";
        String deprissionkid="هل يظهر لدى الطفل انخفاضًا في المزاج المستمر والاكتئاب؟ هل يفتقد الطفل الاهتمام والاستمتاع بالأنشطة السابقة؟ هل يشعر الطفل بالتعب الزائد وفقدان الطاقة؟هل يظهر الطفل قلقًا واستياءًا غير مبرر؟ هل يعاني الطفل من الشعور بالذنب وعدم القدرة على التركيز؟ هل يظهر تغييرات في سلوك الطفل، مثل الانعزال والانسحاب من الأصدقاء والأنشطة الاجتماعية؟ هل يعاني الطفل من آلام جسدية غير مبررة؟ هل يعاني الطفل من أفكار الانتحار أو الرغبة في الموت؟";


        /* fill kid questions in arrays*/
        ArrayList<String> qstdeprissionkid=  question.remplir(deprissionkid);
        ArrayList<String>  qstshizokid=  question.remplir(schizokid);
        ArrayList<String> qstautismkid=  question.remplir(autismkid);
        ArrayList<String> qststutteringkid= question.remplir(stutteringkid);



        /*choose one randome qusetion from the test questions to show it at first */

         ArrayList<String> testqst = question.testqst(qstdeprissionkid,qstshizokid,qstautismkid,qststutteringkid);
        String value= testqst.get(j);
        String complet=(1+"/"+(12));
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

        ArrayList <String>  illness =new ArrayList<>();

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

                    pvqst.setEnabled(true);
                    r++;
                    /*calculating the score of each illness*/
                    if (((RadioButton)findViewById(R.id.rk2)).isChecked()){yes.add(true);
                        if (qstdeprissionkid.contains(testqst.get(j)))
                        {   scored++;
                            System.out.println("score deprission is"+scored);}
                        if (qstshizokid.contains(testqst.get(j)))
                        {   scores++;
                            System.out.println("score  shizo is"+scores);}
                        if ( qstautismkid.contains(testqst.get(j)))
                        {   scorea++;
                            System.out.println("score  autisme is"+scorea);}
                        if (qststutteringkid.contains(testqst.get(j)))
                        {   scorest++;
                            System.out.println("score  stuttering is"+scorest);}}
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
                else{Toast.makeText(getApplicationContext(), "أجب عن سؤال واحد على الأقل", Toast.LENGTH_SHORT).show();}

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
                        if ( qstdeprissionkid.contains(q))
                        {   scored--;
                            System.out.println("score deprission is"+scored);}
                        if ( qstshizokid.contains(q))
                        {   scores--;
                            System.out.println("score  shizo is"+scores);}
                        if (qstautismkid.contains(q))
                        {   scorea--;
                            System.out.println("score  autisme is"+scorea);}
                        if (qststutteringkid.contains(q))
                        {   scorest--;
                            System.out.println("score  stuttering is"+scorest);}}
                    ta.setText(q);
                    radioGroup.clearCheck();
                    if(j==0){pvqst.setEnabled(false);}  }
                r--;}

        });}
    }

