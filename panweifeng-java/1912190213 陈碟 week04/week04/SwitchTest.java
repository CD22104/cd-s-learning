/**
 * 测试 switch 的用法，（）中能用 char byte short int。since jdk1.7 String
 * 理解 case 的穿透
 *
 * @author wfpan
 */

public class SwitchTest
{
	public static void main(String[] args)
	{
		int a = 3;

		switch(a)
		{
			case 3:
				System.out.println("a == 3");
				break;
			case 1:
				System.out.println("a == 1");
				break;
			case 2:
				System.out.println("a == 2");
				break;	
			default:
				System.out.println("default");
		}

		if(3 == a)
		{
			System.out.println("a == 3");
		}
		else if(1 == a)
		{
			System.out.println("a == 1");
		}
		else if(2 == a)
		{
			System.out.println("a == 2");
		}
		else
		{
			System.out.println("default");
		}

	}
}
