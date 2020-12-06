package hello;

import java.util.Scanner;

/*
 * 某公司对用户按照路程计算每公里运费。路程越远，每公里运费越低。
路程km 折扣
s<250 无折扣
250<=s<500 2%
500<=s<1000 5%
1000<=s<2000 8%
2000<=s<3000 10%
s>=3000 15%
假设每公里每吨货物的基本运费为p元，货物重量为w吨，距离为s公里。
Input
输入基本运费p（p<10）,距离s(s<4000),货物重量w(w<1000)，均为浮点数。
Output
输出运费，四舍五入到十元。
注意：目前这几个输入值，在程序中写死。
Sample Input
1 24 32
Sample Output
770
 */
public class test1 {
	public static void main(String[] args) {
		  Scanner input=new Scanner(System.in);//创建一个键盘扫描类对象
		  double p=input.nextFloat();
		  double s=input.nextFloat();
		  double w=input.nextFloat();
		  if(p>=10) System.out.println("p过大");
		  if(w>=1000) System.out.println("w过大");
		  double sum=0;
		  while(s>0){
		  if(s<250)
		   {sum=p*w*s;break;}
		  else if(s>=250&&s<500){
		   sum=sum+(s-250)*0.98*p*w;
		   s-=250;continue;
		   }
		  else if(s>=500&&s<1000){
		   sum=(s-999)*0.95*p*w;
		   s-=500;
		  }
		  else if(s>=1000&&s<2000){
		   sum=(s-1000)*0.92*p*w;
		   s-=1000;
		  }
		  else if(s>=2000&&s<3000){
		   sum=(s-2000)*0.9*p*w;
		   s-=2000;
		  }
		  else if(s>=3000&&s<4000){
		   sum=(s-3000)*0.85*p*w;
		   s-=3000;
		  }
		  else
		   {System.out.println("s输入过大");}
		  }
		  int q,j;
		  q=(int)(sum+5);
		  q=q/10;
		  q=q*10;
		   System.out.println(q);
	}
}
