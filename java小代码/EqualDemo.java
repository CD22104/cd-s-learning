/**
 * 测试 短路 && 和 & 的差异
 * 请在如下程序的基础上，测试各个逻辑运算符 && || ！ & ~ 等，见课本
 * 测试 >> >>> 等
 *
 *
 * @author wfpan
 */

public class EqualDemo
{
    public static void main(String args[])
    {
		int d = 1;
		int c = 2;
		boolean e = false & ++d>1;
		System.out.println(d);
        
    } 
} 
