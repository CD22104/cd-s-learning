package experiment;

import java.util.Scanner;

public class TestRectangle {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		Rectangle r = new Rectangle();
		double a,b,c;
		System.out.println("�����볤��");
		a=input.nextDouble();
		System.out.println("�������");
		b=input.nextDouble();
		r.setChang(a);
		r.setKuan(b);
		System.out.println("�ܳ���"+r.zhouchang(a, b));
		System.out.println("�����"+r.mianji(a, b));
	}

}
