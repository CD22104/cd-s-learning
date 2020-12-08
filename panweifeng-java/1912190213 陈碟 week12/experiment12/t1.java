package experiment12;

import java.util.Scanner;

public class t1 {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        StringBuffer t1=new StringBuffer();
        String t2=new String();
        for (int i = 0; i <10 ; i++) {
           t2=input.nextLine();
           t1.append(t2);
        }
        System.out.println("是否输出字符：1/0");
        int u=input.nextInt();
            if(u==1) {
                for (int i = 0; i < t1.length(); i++) {
                    if ((t1.charAt(i) <= 'z' && t1.charAt(i) >= 'a') || (t1.charAt(i) <= 'Z' && t1.charAt(i) >= 'A')) {
                        System.out.println(t1.charAt(i));
                    }
                }
            }
        System.out.println("是否输出数字：1/0");
        u=input.nextInt();
        if(u==1) {
            for (int i = 0; i < t1.length(); i++) {
                if (t1.charAt(i) <= '9' && t1.charAt(i) >= '0') {
                    System.out.println(t1.charAt(i));
                }
            }
        }
        System.out.println("是否输出倒序：1/0");
        u=input.nextInt();
        if(u==1) {
        t1.reverse();
            System.out.println(t1);
        }
    }
}
