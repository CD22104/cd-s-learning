package triangle;

import java.util.Scanner;

public class TestMain2 {
	
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入三角形的三条边：");
		double a=input.nextDouble();
		double b=input.nextDouble();
		double c=input.nextDouble();
		
		Triangle t=new Triangle(a,b,c);
		t.setSide1(a);
		t.setSide2(b);
		t.setSide3(c);
		
		System.out.println("请输入三角形的颜色：");
		input.nextLine();
		String xixi = input.nextLine();
		t.setColor(xixi);
		System.out.println("请输入三角形的填充情况：");
		Boolean hehe = input.nextBoolean();
		t.setFull(hehe);
		
		double mianji=t.getArea(t.getSide1(),t.getSide2(),t.getSide3());
		System.out.println("三角形面积为："+mianji);
		System.out.println("三角形周长为："+t.getPerimeter(t.getSide1(), t.getSide2(), t.getSide3()));
		System.out.println(t.toString());
		System.out.println("三角形的颜色："+t.getColor());
		System.out.println("三角形是否填充："+t.getFull());
	}
}
