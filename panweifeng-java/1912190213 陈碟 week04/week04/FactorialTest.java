/**
 * 理解递归方法
 * @author wfpan
 */ 

 // 2! = 1!*2
 // 3! = 2!*3
 // n! = (n-1)!*n

class FactorialTest {
	public static void main(String[] args) {
		int sum = 0;
		for(int i=1;i<=10;i++) {
			sum += factorial(i);
		}

//		sum = factorial();
		System.out.println(sum);
	}

	//通过递归求阶乘
	public static int factorial(int n) {
		if(1==n) return 1;
		else return factorial(n-1)*n;
	}
	//通过迭代求阶乘
	public static int factorial() {
		int f = 1;
		int sum = 1;
		for(int i = 2; i<=10; i++) {
			f *= i;
			sum += f;
		}
		return sum;
	}
}
