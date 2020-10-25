/**
 * 测试 变量作用域：局部变量可以屏蔽成员变量；同层局部变量可以屏蔽；嵌套局部变量不能屏蔽
 *
 *
 * @author wfpan
 */

public class Customer {
	private String name;


	public static void main(String[] args) {
		Customer customer = new Customer();
		String name = "John Smith";
		{
			// 下列说明是非法的
			String name = "Tom David";
			String name2 = "";
			customer.name = name;
			System.out.println("The customer's name: " + customer.name);
		}
		{
			String name = "";
			String name2 = "";
		}
	}
}
