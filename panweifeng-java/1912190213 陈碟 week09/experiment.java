package week09;

import java.util.Scanner;

//输入一个100000位的数字，请计算这个数中各位数出现的次数。
//如输入1223，则各位数出现的次数为1：1次；2：2次；3：1次。
public class experiment {
	public static void main(String[] args) {
		String a=new String();
		Scanner input = new Scanner(System.in);
		a=input.nextLine();
		int[] b=new int[10];
		for(int i=0;i<=9;i++)
		{
			b[i]=0;
		}
		for(int i=0;i<a.length();i++)
		{
			b[(int)a.charAt(i)-48]++;
		}
		for(int i=0;i<=9;i++)
		{
			if(b[i]!=0) System.out.println(i+":"+b[i]);
		}
		
	}
}
