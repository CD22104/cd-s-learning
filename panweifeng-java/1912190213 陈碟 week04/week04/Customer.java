/**
 * ���� ���������򣺾ֲ������������γ�Ա������ͬ��ֲ������������Σ�Ƕ�׾ֲ�������������
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
			// ����˵���ǷǷ���
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
