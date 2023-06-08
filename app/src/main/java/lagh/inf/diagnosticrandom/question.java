package lagh.inf.diagnosticrandom;



import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;


public class question {
/* adult questions */
    static String stuttering ="هل تشعر بالتوتر أو القلق قبل الكلام؟ هل تشعر بتوتر عضلي في منطقة الوجه أو الفك أثناء محاولة التحدث؟هل تعاني من تكرار الكلمات أو الأصوات الصوتية؟هل تجد صعوبة في الكلام عندما تكون في حالة من الانفعال أو الحماسة؟هل تشعر بأن الكلام يتوقف أو يعلق في الحلق أثناء المحاولة للتحدث؟هل تشعر بتوتر عضلي في منطقة الوجه أو الفك أثناء محاولة التحدث؟";
    static String autism="هل تلاحظ صعوبة في التفاعل الاجتماعي والتواصل العاطفي مع الآخرين؟هل تجد صعوبة في فهم وتفسير العبارات الغير مباشرة؟هل تشعر بالرغبة في الالتفاف على المواعيد المحددة؟هل تشعر بالحساسية الزائدة تجاه الأصوات أو الروائح أو الأضواء أو الأطعمة؟هل لديك اهتمامات غير عادية ومحدودة في مجالات معينة، وتفضل التركيز على هذه الاهتمامات؟ هل تلاحظ صعوبة في فهم واستيعاب مشاعر الآخرين وتفسيرها؟هل تجد صعوبة في إقامة  صداقات وعلاقات الاجتماعية؟هل تظهر لديك حركات متكررة أو إيقاعات غير عادية في الجسم؟هل تعاني من تأخر في اكتساب المهارات اللغوية والاجتماعية المناسبة لعمرك؟";
    static String schizo="هل تعاني من سماع أصوات غير موجودة أو رؤية أشخاص أو أشياء غير حاضرة؟هل تعاني من الاعتقادات الغير منطقية   ؟هل تشعر بصعوبة في التركيز أو الانتباه لفترات طويلة؟ هل تظهر لديك تغيرات في المشاعر والعواطف، مثل انخفاض في الشعور بالمتعة أو  شعور زائد بالتوتر أو القلق؟هل تشعر بالشك والاعتقاد بأن الآخرين يؤامرون عليك أو يخططون للضرر بك ؟ هل تعاني من انحراف السلوك أو السلوك الغير منتظم أو العنف غير المبرر؟";
    static String deprission="هل تشعر بالحزن الشديد لمعظم أيام الأسبوع؟هل فقدت الاهتمام  في الأنشطة التي كنت تستمتع بها في الماضي؟  هل لديك انخفاض في مستوى الطاقة ؟هل تعاني من صعوبة في النوم، مثل الأرق أو النوم الزائد؟هل لديك تغيرات في الشهية أو الوزن؟ هل تشعر بالقلق أو الاستياء بشكل متكرر؟هل تشعر بالشعور بالذنب بشكل زائد؟هل لديك أفكار متكررة عن الموت أو الانتحار؟هل تشعر بالانعزالية ؟";
    /* kid questions */
    static String stutteringkid ="هل يواجه الطفل صعوبة في بدء الكلام أو التفوه بالكلمات بشكل سلس؟ هل يحدث تكرار أو تقطيع في الكلام لدى الطفل بشكل مستمر؟ هل تظهر عند الطفل جهود ملحوظة للتحكم في التكرار أو التقطيع في الكلام؟هل يعاني الطفل من التأتأة في أجزاء محددة من الكلام، مثل تكرار مقاطع أو حروف معينة؟ هل يعاني الطفل من توتر أو قلق؟";
    static String autismkid="هل يظهر لدى الطفل صعوبة في التواصل اللفظي وغير اللفظي؟ هل يعاني الطفل من صعوبة في التفاعل الاجتماعي وإقامة علاقات مع الآخرين؟ هل يتجاهل الطفل محاولات التواصل الاجتماعي من الآخرين؟ هل يظهر الطفل اهتمامًا غير طبيعي ومحدودًا بألعاب أو أجزاء من الأشياء بدلاً من اللعب الاجتماعي؟ هل يلجأ الطفل إلى الأنشطة المتكررة والروتينية بشكل ملحوظ ويشعر بالقلق من التغييرات في الروتين؟ هل يظهر الطفل اهتمامًا محدودًا بمشاركة الاهتمامات والمشاعر والإنجازات مع الآخرين؟ هل يصاحب الطفل حساسية غير عادية تجاه الأصوات أو الروائح أو الأطعمة أو اللمس؟ هل يتكرر لدى الطفل السلوك الحركي المتكرر، مثل ترتد الجسم أو تلوي اليدين؟ هل يعاني الطفل من تأخر في اكتساب المهارات اللغوية والاجتماعية المناسبة لعمره؟ هل يشعر الطفل بالقلق أو الضغط في مواقف اجتماعية ويظهر استجابات توترية غير عادية؟";
    static String schizokid="هل ينحرف الطفل في اهتمامه وتركيزه ويبدو غير متصل في حديثه؟ هل تشاهد سلوكيات غير اعتيادية لدى الطفل، مثل الانعزال أو التوتر الزائد؟ هل يلاحظ تغيرات في المزاج والنوم لدى الطفل؟ هل تلاحظ انخفاضًا في أداء الطفل العام وقدرته على التواصل الاجتماعي؟ هل يبدو الطفل غير مهتم بالأنشطة الاجتماعية المعتادة؟ هل تشعر بالقلق بشأن تغيرات في الشهية والوزن لدى الطفل؟ هل يظهر الطفل عدم الثقة في الآخرين والشك في نواياهم؟";
    static String deprissionkid="هل يظهر لدى الطفل انخفاضًا في المزاج المستمر والاكتئاب؟ هل يفتقد الطفل الاهتمام والاستمتاع بالأنشطة السابقة؟ هل يشعر الطفل بالتعب الزائد وفقدان الطاقة؟هل يظهر الطفل قلقًا واستياءًا غير مبرر؟ هل يعاني الطفل من الشعور بالذنب وعدم القدرة على التركيز؟ هل يظهر تغييرات في سلوك الطفل، مثل الانعزال والانسحاب من الأصدقاء والأنشطة الاجتماعية؟ هل يعاني الطفل من آلام جسدية غير مبررة؟ هل يعاني الطفل من أفكار الانتحار أو الرغبة في الموت؟";


    /* fill questions in array function*/
    static ArrayList<String>  remplir(String s)
    {int i=0 ;
        ArrayList<String> q = new ArrayList<>();
        String a="";
        if (s!= null) {
            int l = s.length();
            System.out.println("The length of the string is: " + l);
            while (i<l){
                a=a+s.charAt(i);
                String t = String.valueOf(s.charAt(i));
                if (t.equals("؟")){
                    q.add(a);
                    System.out.println(a);
                    a="";
                }
                i++;}
        } else {
            System.out.println("The string is null.");
        }
        System.out.println("The string is null."+s+q.size());
        return q;}
    /* fill adult questions in arrays*/
    static ArrayList<String> qstdeprission=  remplir(deprission);
    static ArrayList<String>  qstshizo=  remplir(schizo);
    static ArrayList<String> qstautism=  remplir(autism);
    static ArrayList<String> qststuttering=  remplir(stuttering);
    /* fill kid questions in arrays*/
    static ArrayList<String> qstdeprissionkid=  remplir(deprissionkid);
    static ArrayList<String>  qstshizokid=  remplir(schizokid);
    static ArrayList<String> qstautismkid=  remplir(autismkid);
    static ArrayList<String> qststutteringkid=  remplir(stutteringkid);
    /* fill questions randomly in one array + mix the order in each time*/
    static public ArrayList<String> testqst (ArrayList<String> q1,ArrayList<String> q2,ArrayList<String> q3,ArrayList<String> q4)
    {
        ArrayList<String> f1 =  new ArrayList<>();
        int l1=q1.size();
        int l2=q2.size();
        int l3=q3.size();
        int l4=q4.size();
        int i=0 ;
        int r1,r2;
         /* fill the array with 8 questions randomly from th 2 principle mental illness */
        while (i<3)
        {   r2 = ThreadLocalRandom.current().nextInt(0,l2);
            if (!(f1.contains(q2.get(r2)))) {
            String y =q2.get(r2);
            f1.add(y);
            i++;}

        }
        Collections.shuffle(f1);
        i=0;
        while (i<3)
        {    r1 = ThreadLocalRandom.current().nextInt(0,l1);
            if (!(f1.contains(q1.get(r1)))){
                String s =q1.get(r1);
            f1.add(s);
            i++;}

        }
        Collections.shuffle(f1);
        i=0;
        /* fill the array with 4 questions randomly from th 2 secondry mental illness */
        while (i<3)
        {   r2 = ThreadLocalRandom.current().nextInt(0,l3);
            if (!(f1.contains(q3.get(r2)))) {
                String y =q3.get(r2);
                f1.add(y);
                i++;}

        }
        i=0;
        Collections.shuffle(f1);
        while (i<3)
        {    r1 = ThreadLocalRandom.current().nextInt(0,l4);
            if (!(f1.contains(q4.get(r1)))){
                String s =q4.get(r1);
                f1.add(s);
                Collections.shuffle(f1);
                i++;}

        }
        System.out.println(f1);
        System.out.println(f1.size());
       /* mix the order of the array */


        Collections.shuffle(f1);
        return f1;}

}


