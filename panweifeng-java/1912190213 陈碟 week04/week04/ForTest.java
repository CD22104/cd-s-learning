/**
 * 测试 for 循环
 *
 *
 * @author wfpan
 */

public class ForTest
{
	public static void main(String[] args)
	{
		int sum = 0; //存储相加后的结果
		
		for(int i = 2; i <= 100; i += 2)
		{
			sum += i;
		}

		System.out.println(sum);

		int sum2 = 0; //存储相加后的结果

		for(int i = 100; i >= 1; i--)
		{
			sum2 += i;
		}

		System.out.println(sum2);


	}
}
