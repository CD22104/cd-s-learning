package com.wfpan.studentdemo;

import java.util.Arrays;

public class TestMain {
	public static void main(String[] args) {
		Student[] stus = new Student[3];
		for (int i = 0; i < stus.length; i++) {
			int yw = 12+i;
			int sx = 13+i;
			int yy = 14+i;
			stus[i] = new Student("wfpan"+i,"n",new float[]{yw,sx,yy});
		}
		
		System.out.println(Arrays.toString(stus));
		Arrays.sort(stus);
		System.out.println(Arrays.toString(stus));
		
	}

}
