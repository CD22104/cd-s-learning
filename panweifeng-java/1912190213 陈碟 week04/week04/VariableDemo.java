/**
 * 测试不同类型变量的定义
 * 不同类型变量间的相互赋值、理解常数的默认值规律
 *
 *
 * @author wfpan
 */

public class VariableDemo
{
	public static void main(String[] args)
	{
		//double a = 1.2;
		//System.out.println(a);

		//char a = 'A';
		//System.out.println(a);

		//boolean a = true;
		//System.out.println(a);

		//float a = (float)1.2; //这行代码编译出错
		//System.out.println(a);
		
		//float a = 1.2f;
		//System.out.println(a);

		//int a = 1;
		//a = 2;
		//System.out.println(a);

/*

		short a = 1;
		int b = a;
		System.out.println(b);
*/		

		int a = 1;
		short b = (short)a;
		System.out.println(b);

	}
}