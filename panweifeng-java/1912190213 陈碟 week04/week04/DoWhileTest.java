/**
 * 测试 do-while 的作用：至少一次
 * 问题：while 和 do-while 的差异？
 *
 *
 * @author wfpan
 */

public class DoWhileTest
{
	public static void main(String[] args)
	{
		int a = 2;//循环变量
		int sum = 0; //存储相加后的结果

		do
		{
			sum += a;
			a += 2;
		}
		while(a <= 100);

		System.out.println(sum);

		int b = 2;

		while(b < 1)
		{
			System.out.println("Hello World");
		}

		do
		{
			System.out.println("Welcome");
		}
		while(b < 1);

				
	}
}
