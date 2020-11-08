package experiment;

import java.util.Scanner;

public class test4 {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String shu=input.nextLine();
		System.out.println(shu);
		long sum=0;
		for(int i=0;i<shu.length();i++)
		{
			char m=shu.charAt(i);
			String str=String.valueOf(m);
			int j=Integer.parseInt(str);
			sum+=j;
		}
		System.out.println(sum);
	}
}
