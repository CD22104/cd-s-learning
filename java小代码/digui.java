package experiment;

import java.util.Scanner;

public class digui {
	
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int x=input.nextInt();
		long sumplus=0;
		for(int i=1;i<=x;i++)
		{
			sumplus=sumplus+multi(i);
		}
		System.out.println(sumplus);
	}
	public static long multi(int a)
	{
		if(a==1) return 1;
		else return a*multi(a-1);
	}
}
