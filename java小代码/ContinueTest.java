/**
 * 测试 continue 的作用：结束本次循环
 * 问题：请回答continue后执行哪一步？
 *
 *
 * @author wfpan
 */

public class ContinueTest
{
	public static void main(String[] args)
	{
		for(int i = 0; i < 10; i++)
		{
			if(5 == i)
			{
				continue;
			}
					
			System.out.println(i);
		}
	}
}
