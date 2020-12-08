package experiment12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class LiFangTi {
    public int chang;
    public int kuan;
    public int gao;
    public int tiji;
    public static void main(String[] args) {
        ArrayList alist = new ArrayList();
        LiFangTi[] kk= new LiFangTi[10];
        int n=0;
        Scanner input =new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            LiFangTi l1 = new LiFangTi();
            System.out.println("输入长宽高：");
            l1.chang=input.nextInt();
            l1.kuan=input.nextInt();
            l1.gao=input.nextInt();
            l1.tiji=l1.chang*l1.kuan*l1.gao;
            kk[n++]=l1;
            alist.add(l1.tiji);
        }
        System.out.println("共有"+alist.size()+"个元素");
        System.out.println("体积降序排序为：");
        alist.sort(Comparator.reverseOrder());
        System.out.println(alist);

    }
}
