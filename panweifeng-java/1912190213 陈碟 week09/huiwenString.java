package week09;

public class huiwenString {

	public static void main(String[] args) {
		char[] hw= {'a','b','c','d'};
		int i,j;
		for(i=0;i<=3;i++)
		{
			for(j=0;j<=3;j++)
			{
				System.out.printf("%c%c%c%c\n",hw[i],hw[j],hw[j],hw[i]);
			}
		}
	}

}
