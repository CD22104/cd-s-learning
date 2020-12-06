package experiment;

public class huiwenshu {

	public static void main(String[] args) {
		int i;
		for(i=11;i<=10000;i++)
		{
			int sum=i;
			int dao=0;
			int j;
			while(sum!=0)
			{
				j=sum%10;
				dao=dao*10+j;
				sum=sum/10;
			}
			if(i==dao) System.out.println(dao+" ");
		}
	}
}
