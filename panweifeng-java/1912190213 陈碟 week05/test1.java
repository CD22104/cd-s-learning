package hello;

import java.util.Scanner;

/*
 * ĳ��˾���û�����·�̼���ÿ�����˷ѡ�·��ԽԶ��ÿ�����˷�Խ�͡�
·��km �ۿ�
s<250 ���ۿ�
250<=s<500 2%
500<=s<1000 5%
1000<=s<2000 8%
2000<=s<3000 10%
s>=3000 15%
����ÿ����ÿ�ֻ���Ļ����˷�ΪpԪ����������Ϊw�֣�����Ϊs���
Input
��������˷�p��p<10��,����s(s<4000),��������w(w<1000)����Ϊ��������
Output
����˷ѣ��������뵽ʮԪ��
ע�⣺Ŀǰ�⼸������ֵ���ڳ�����д����
Sample Input
1 24 32
Sample Output
770
 */
public class test1 {
	public static void main(String[] args) {
		  Scanner input=new Scanner(System.in);//����һ������ɨ�������
		  double p=input.nextFloat();
		  double s=input.nextFloat();
		  double w=input.nextFloat();
		  if(p>=10) System.out.println("p����");
		  if(w>=1000) System.out.println("w����");
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
		   {System.out.println("s�������");}
		  }
		  int q,j;
		  q=(int)(sum+5);
		  q=q/10;
		  q=q*10;
		   System.out.println(q);
	}
}
