/**
 * ���Է�������
 * ��⣺���ô��ݺ�ֵ���ݶ���ֵ����
 * �뻭�ڴ�ģ��
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
		System.out.println("100���ڵ�ż�����ǣ�" + evenSum);
		System.out.println("100���ڵ��������ǣ�" + oddSum);

		int[] array = {1,4,7,9,11};
		//���ô���
		even(array);
		//��ֵ����
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
				System.out.println("ż��a["+i+"]="+arr[i]);
			} else {
				System.out.println("����a["+i+"]="+arr[i]);
			}
		}
	}

	public static void even(int arr) {	
		if(0==arr%2) {
			System.out.println("ż��"+arr);
		} else {
			System.out.println("����"+arr);
		}
		
	}

}

