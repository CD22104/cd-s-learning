package Hello;

import java.util.Scanner;

public class test6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i;
        int[] shu = new int[100];
        int[] pin = new int[100];
        pin[0] = 1;
        pin[1] = 0;
        System.out.println("请输入一组整数（输入0表示结束）");
        int in = input.nextInt();
        int n = 0;
        while (in != 0) {
            shu[n] = in;
            int j;
            for (j = 0; j < n; j++) {
                if (in == shu[j]) {
                    pin[j]++;
                    break;
                }
            }
            if (j == n) {
                pin[n] = 1;
                n++;
            }
            in = input.nextInt();
        }
        int max=0;
        for (i = 0; i < n; i++) {
            if(pin[max]<pin[i]) i=max;
        }
        System.out.println("最高频次出现的数字为："+shu[max] + ":出现次数为：" + pin[max]);
    }
}
