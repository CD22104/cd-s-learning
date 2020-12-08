package Hello;

import java.util.Scanner;

public class test7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String t1=input.nextLine();
        String t2=input.nextLine();
        int l1=t1.length();
        int l2=t2.length();
        if(l1>l2)
        {
            String t=new String();
            t=t1;
            t1=t2;
            t2=t;
            l1=t1.length();
            l2=t2.length();
        }
        int k=-1;
        String s1=new String();
        s1="";
        int i,j;
        for (i = l1;i>0; i--) {
            for(j=0;j+i<=l1;j++)
            {
                s1=t1.substring(j,j+i);
                k=t2.indexOf(s1);
                if(k!=-1) break;
                s1="";
            }
            if(k!=-1) break;
        }
        System.out.println("最长公共字符串长度为："+i);
    }
}
