package week09;

import java.util.Scanner;

//����һ��100000λ�����֣������������и�λ�����ֵĴ�����
//������1223�����λ�����ֵĴ���Ϊ1��1�Σ�2��2�Σ�3��1�Ρ�
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
