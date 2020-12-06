package hello;

import java.util.Scanner;

//定义一个6位数，求各个位置的数字和
public class test3 {
public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	int m=input.nextInt();
	int s=0;
	while(m!=0)
	{
		s+=m%10;
		m/=10;
	}
	System.out.println(s);
}
	
}
