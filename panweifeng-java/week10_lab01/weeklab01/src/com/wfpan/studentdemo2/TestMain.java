package com.wfpan.studentdemo2;

import java.util.Arrays;
import java.util.Comparator;

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
		
		Arrays.sort(stus, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				int a = (int) (o1.getTotalScore() * 1e7);
				int b = (int) (o2.getTotalScore() * 1e7);
				return a - b > 0 ? -1 : (0 == a - b ? 0 : 1);
			}
		});
		
		System.out.println("Totalscore" + Arrays.toString(stus));
		
		Arrays.sort(stus, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				
				int a = (int) (o1.getScores()[0] * 1e7);
				int b = (int) (o2.getScores()[0] * 1e7);
				return a - b > 0 ? -1 : (0 == a - b ? 0 : 1);
			}
		});
		
		System.out.println("score[0]" + Arrays.toString(stus));
		
	}

}
