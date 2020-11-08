package experiment;

import java.util.Scanner;

public class test3 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int a=input.nextInt();
		if(a==1)
		{
			chufa1();
		}
		else
		{
			chufa2();
		}
	}
	public static void chufa1()
	{
		Scanner input=new Scanner(System.in);
		int b=input.nextInt();
		int c=input.nextInt();
		if(b%c==0) System.out.println(b/c);
		else 
		{
			float d=(float)b/(float)c;
			System.out.printf("%.6f",d);
		}
		return ;
	}
	public static void chufa2()
	{
		Scanner input=new Scanner(System.in);
		float e=input.nextFloat();
		float f=input.nextFloat();
		System.out.printf("%.6f",e/f);
		return ;
	}
}
