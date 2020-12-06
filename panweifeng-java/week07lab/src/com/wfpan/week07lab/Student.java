package com.wfpan.week07lab;

public class Student {
	private String stuName;
	private int stuAge;
	private String sex;
	public Student() {
		super();
	}
	public Student(String stuName, int stuAge, String sex) {
		super();
		this.stuName = stuName;
		this.stuAge = stuAge;
		this.sex = sex;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Student [stuName=" + stuName + ", stuAge=" + stuAge + ", sex=" + sex + "]";
	}
	

}
