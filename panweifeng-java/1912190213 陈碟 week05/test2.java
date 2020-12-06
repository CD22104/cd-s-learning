package hello;

import java.util.Scanner;

public class test2 {
//输入两个浮点数交换排序
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		float m=input.nextFloat();
		float n=input.nextFloat();
		
		System.out.printf("m=%f n=%f\n",m,n);
		swap(m,n);
		
	}
	public static void swap(float a,float b)
	{
		float p=0.1f;
		p=a;
		a=b;
		b=p;
		System.out.printf("m=%f n=%f",a,b);
	}
}
