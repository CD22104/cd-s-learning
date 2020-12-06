package week09;

import java.util.Scanner;

public class choose1 {

	static void swap(String[] people,int x,int n) {
		String t;
		t=people[x];
		people[x]=people[1000-n];
		people[1000-n]=t;
	}
	public static String getaname()
	{
		char c;
		String linkNo = "";
	    // 用字符数组的方式随机
	    String model = "abcdefghijklmnopqrstuvwxyz";
	    char[] m = model.toCharArray();
	    for (int j = 0; j < 10; j++) {
	        c= m[(int) (Math.random() * 26)];
	        linkNo = linkNo + c;
	    }
		return linkNo;
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String[] jiangpin=new String[1000];
		 int i;
		 for(i=0;i<500;i++)
		 {
			 String jkjk="";
			 jkjk=getaname();
			 jiangpin[i]=jkjk;
			 jiangpin[i+500]=jkjk;
		 }
		 int n=0;
		 int x=0;
		while(n<1000) {
			System.out.println("请问您要继续抽取号码吗？");
			int c;
			c=in.nextInt();
			if(c>0) {
				x=(int)(Math.random()*(1000-n));
				n++;
				System.out.println(jiangpin[x]);
				swap(jiangpin,x,n);
			}
			else
				break;
		}
	}

}
