/**
 * ���Է������صĺ��壺�β����͡�����������˳���뷵��ֵ���ͼ����η��޹�
 * @author wfpan
 */ 
public class OverLoadingDemo {

	public static void main(String[] args) {
		System.out.println(AddOverLoad.add(3.4, 4.2));
		System.out.println(AddOverLoad.add(3.4, 4.2,5.1));
		System.out.println(AddOverLoad.add(3.4f, 1.1f));
	}

}

class AddOverLoad {
	public static int add(int op1,int op2) {
		return op1+op2;
	}

	public static long add(int opp1,int opp2,int opp3) {
		return opp1+opp2;
	}
	

	public static double add(double op1,double op2) {
		return op1+op2;
	}

	public static double add(double op1,double op2, double op3) {
		return op1+op2+op3;
	}

	public static float add(int op1, double op2) {
		return (float)(op1+op2);
	}
	
	public static float add(float op1, float op2) {
		return op1+op2;
	}
}
