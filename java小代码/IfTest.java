/**
 * 测试 条件语句 if-else 的作用
 *
 * @author wfpan
 */


public class IfTest
{
	public static void main(String[] args)
	{
		int a = 3;
		int b = 2;

		if(a > b)
		{
			System.out.println("a > b");
		}
		else if(a < b)
		{
			System.out.println("a < b");
		}
		else
		{
			System.out.println("a == b");
		}
	}
}
