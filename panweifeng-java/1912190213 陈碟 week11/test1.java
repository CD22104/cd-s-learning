package Hello;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class test1 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
       String t1=input.nextLine();
       String t2=input.nextLine();
       int n=0,k=0;
       while((k=t2.indexOf(t1,k))!=-1)
       {
           k++;
           n++;
       }
        System.out.println(n);






    }
}