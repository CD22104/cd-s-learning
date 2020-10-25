/**
 * 测试 break 的作用：跳出本层循环
 * 问题：请回答break后执行哪一步？
 *
 *
 * @author wfpan
 */

public class BreakTest
{
	public static void main(String[] args)
	{
		for(int j = 0; j < 3; j++) {
			for(int i = 0; i < 10; i++)
			{
				if(5 == i)
				{
					break;
				}

				System.out.println(i);
			}
			System.out.println("world");
		}
 		System.out.println("hello");
	}
}
