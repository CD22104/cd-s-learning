package triangle;

import java.util.Scanner;

public class TestMain2 {
	
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("�����������ε������ߣ�");
		double a=input.nextDouble();
		double b=input.nextDouble();
		double c=input.nextDouble();
		
		Triangle t=new Triangle(a,b,c);
		t.setSide1(a);
		t.setSide2(b);
		t.setSide3(c);
		
		System.out.println("�����������ε���ɫ��");
		input.nextLine();
		String xixi = input.nextLine();
		t.setColor(xixi);
		System.out.println("�����������ε���������");
		Boolean hehe = input.nextBoolean();
		t.setFull(hehe);
		
		double mianji=t.getArea(t.getSide1(),t.getSide2(),t.getSide3());
		System.out.println("���������Ϊ��"+mianji);
		System.out.println("�������ܳ�Ϊ��"+t.getPerimeter(t.getSide1(), t.getSide2(), t.getSide3()));
		System.out.println(t.toString());
		System.out.println("�����ε���ɫ��"+t.getColor());
		System.out.println("�������Ƿ���䣺"+t.getFull());
	}
}
