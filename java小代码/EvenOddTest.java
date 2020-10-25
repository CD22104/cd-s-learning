/**
 * 测试方法调用
 * 理解：引用传递和值传递都是值传递
 * 请画内存模型
 * @author wfpan
 */ 

public class EvenOddTest {

	public static void pp() {}

	public static void main(String[] args) {
		pp();
		int evenSum = 0;
		int oddSum = 0;
		evenSum = even();
		oddSum = odd();
		System.out.println("100以内的偶数和是：" + evenSum);
		System.out.println("100以内的奇数和是：" + oddSum);

		int[] array = {1,4,7,9,11};
		//引用传递
		even(array);
		//数值传递
		for(int i=0; i<array.length; i++) {
			even(array[i]);
		}



	}
	
	public static int even(){
		int i = 0;
		int evenSum = 0;
		while(i<=100) {
			if(0==i%2) {
				evenSum += i;
			}
			i++;
		}
		
/*		for(i=0;i<=100;i++) {
			if(0==i%2) {
				evenSum += i;
			}
		}
		*/
		return evenSum;
	}
	
	public static int odd() {
		int i = 0;
		int oddSum = 0;
		while(i<=100) {
			if(0!=i%2) {
				oddSum += i;
			}
			i++;
		}
		
/*		for(i=0;i<=100;i++) {
			if(0!=i%2) {
			oddSum += i;
			}
		}
	*/
		
		return oddSum;
	}

	public static void even(int[] arr) {
		for(int i =0; i<arr.length; i++) {
			if(0==arr[i]%2) {
				System.out.println("偶数a["+i+"]="+arr[i]);
			} else {
				System.out.println("奇数a["+i+"]="+arr[i]);
			}
		}
	}

	public static void even(int arr) {	
		if(0==arr%2) {
			System.out.println("偶数"+arr);
		} else {
			System.out.println("奇数"+arr);
		}
		
	}

}

