package com.wfpan.test;

import java.util.Arrays;

/*
 * awards[] = {}
 * 
 * bolt[] = {1,2,3,4,5,6,7,8,9}
 * Math.random()*bolt.length [0-8]
 * 
 * 5
 * {1,2,3,4,9,6,7,8,5}
 * bolt.length-1
 * 
 * excel
 * 
 * */

public class TestMain {

	/*
	 * public static void swap(int[] arr, int src, int dest) { int a = 0; a =
	 * arr[src]; arr[src] = arr[dest]; arr[dest] = a; }
	 * 
	 * public static void swap(String[] arr, int src, int dest) { String a = ""; a =
	 * arr[src]; arr[src] = arr[dest]; arr[dest] = a; }
	 */
	
	public static void swap(Object[] arr, int src, int dest) {
		Object a = "";
		a = arr[src];
		arr[src] = arr[dest];
		arr[dest] = a;
	}

	public static void main(String[] args) {
		Integer[] bolts = { 1, 2, 3, 4, 5 };
		String[] awards = { "jp1", "jp2", "jp3", "jp4" };

		int i = 0;// count for the have-been selected bolt.

		// ѡ��
		while (i <= bolts.length - 1) {
			i++;
			System.out.println("original" + Arrays.toString(bolts));
			int boltIndex = (int) (Math.random() * (bolts.length - (i - 1))); // 0 5,0 4, 0 3,0,2,0 1
			System.out.println("��" + i + "�γ齱���±�:" + boltIndex + "-" + bolts[boltIndex] + "-�����齱");
			// boltIndex <-> (awards.length-i)
			swap(bolts, boltIndex, bolts.length - i);
//			System.out.println("after" + Arrays.toString(bolts));
			

			System.out.println("original" + Arrays.toString(awards));
			int awardIndex = (int) (Math.random() * (awards.length - (i - 1)));
			System.out.println(bolts[boltIndex] + "������" + "-" + awards[awardIndex]);
			System.out.println(awardIndex+"vs"+(awards.length - i));
			swap(awards, awardIndex, awards.length - i);
			System.out.println("after" + Arrays.toString(awards));
			
			if(i>=awards.length) {
				System.out.println("��Ʒ�����ˣ��齱����");
				return;
			}

		}

//		int awardIndex = (int)(Math.random()*awards.length);

	}

}
