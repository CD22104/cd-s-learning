package experiment;

import java.util.Scanner;

public class TestRectangle {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		Rectangle r = new Rectangle();
		double a,b,c;
		System.out.println("请输入长：");
		a=input.nextDouble();
		System.out.println("请输入宽：");
		b=input.nextDouble();
		r.setChang(a);
		r.setKuan(b);
		System.out.println("周长："+r.zhouchang(a, b));
		System.out.println("面积："+r.mianji(a, b));
	}

}
