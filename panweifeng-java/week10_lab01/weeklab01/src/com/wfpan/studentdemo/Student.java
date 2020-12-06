package com.wfpan.studentdemo;

import java.util.Arrays;

public class Student implements Comparable<Student> {
	private String name;
	private String sex;
	private float[] scores;
	
	private float totalScore;
	
	public Student() {
		super();
	}
	public Student(String name, String sex, float[] scores) {
		super();
		this.name = name;
		this.sex = sex;
		this.scores = scores;
		setTotalScore();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public float[] getScores() {
		return scores;
	}
	public void setScores(float[] scores) {
		this.scores = scores;
	}
	
	public void setTotalScore() {
		float sum = 0.f;
		for (int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		
		this.totalScore = sum;
	}
	
	public float getTotalScore() {
		return this.totalScore;
	}
	
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", sex=" + sex + ", scores=" + Arrays.toString(scores) + ", totalScore="
				+ totalScore + "]";
	}
	@Override
	public int compareTo(Student o) {
		
		int a = (int)(this.getTotalScore()*1e7);
		int b = (int)(o.getTotalScore()*1e7);
		return a-b>0?-1:(0==a-b?0:1);
	}
	
	
	

}
