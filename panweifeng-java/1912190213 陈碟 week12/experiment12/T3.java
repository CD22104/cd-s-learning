package experiment12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class T3 {
    public String bm;
    public static ArrayList<Student> alist=new ArrayList<>();

    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        T3 banji=new T3();
        for (int i = 0; i < 5; i++) {
            Student s= new Student() {
                @Override
                public int compareTo(Object o) {
                    return 0;
                }
            };
            System.out.println("请输入姓名");
            s.xm=input.nextLine();
            System.out.println("请输入年龄");
            s.age=input.nextInt();
            System.out.println("请输入性别");
            s.xb=input.nextLine();
            banji.alist.add(s);
        }


        Collections.sort(banji.alist);

        for(Student str: banji.alist){
            System.out.println(str.xm);
        }
    }
}
