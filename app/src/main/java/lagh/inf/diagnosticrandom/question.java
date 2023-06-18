package lagh.inf.diagnosticrandom;



import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;


public class question {
/* adult questions */

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
        Collections.shuffle(q1);
        while (i<3)
        {
            if (!(f1.contains(q1.get(i)))){
                String y =q1.get(i);
            f1.add(y);
            i++;}

        }
        Collections.shuffle(f1);
        i=0;
        Collections.shuffle(q2);
        while (i<3)
        {
            if (!(f1.contains(q2.get(i)))){
                String s =q2.get(i);
            f1.add(s);
            i++;}

        }
        Collections.shuffle(f1);
        i=0;
        /* fill the array with 4 questions randomly from th 2 secondry mental illness */
        Collections.shuffle(q3);
        while (i<3)
        {
            if (!(f1.contains(q3.get(i)))){
                String y =q3.get(i);
                f1.add(y);
                i++;}

        }
        i=0;

        Collections.shuffle(q4);
        while (i<3)
        {
            if (!(f1.contains(q4.get(i)))){
                String s =q4.get(i);
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


