package Hello;

import java.util.Scanner;

public class test5 {
    public static void main(String[] args) {
        //解析字符串：输入如下字符串“Hello!Hello!I am 01.What is your name?”，
        // 要求统计里面出现的单词数。注：相同的单词不重复计数。
        Scanner input = new Scanner(System.in);
        String t=input.nextLine();
        int i;
        String[] m=new String[20];
        int n=0;
        String linshi="";
        for(i=0;i<t.length();i++)
        {
            if((t.charAt(i)<='z'&&t.charAt(i)>='a')||(t.charAt(i)<='Z'&&t.charAt(i)>='A'))
            {
                linshi=linshi+t.charAt(i);
            }
            if(t.charAt(i)=='?'||t.charAt(i)==' '||t.charAt(i)=='!'||t.charAt(i)=='.')
            {
                if(linshi!="") m[n++]=linshi;
                linshi="";
            }
        }
        int j;
        int u=n;
        for(i=0;i<n;i++)
        {
            for(j=0;j<i;j++)
            {
                if(m[i].equals(m[j]))
                {
                    linshi=m[i];
                    m[i]=m[n-1];
                    m[n-1]=linshi;
                    n--;
                    i--;
                }
            }
        }
        System.out.println(n);
        for(i=0;i<n;i++)
        {
            System.out.println(m[i]);
        }
    }
}
