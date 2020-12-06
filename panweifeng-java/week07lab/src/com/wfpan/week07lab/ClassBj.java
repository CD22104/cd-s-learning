package com.wfpan.week07lab;

import java.util.Arrays;

public class ClassBj {
	private String className;
	private Student[] stus/* = new Student[10] */;
	public ClassBj() {
		super();
	}
	public ClassBj(String className, Student[] stus) {
		super();
		this.className = className;
		this.stus = stus;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Student[] getStus() {
		return stus;
	}
	public void setStus(Student[] stus) {
		this.stus = stus;
	}
	@Override
	public String toString() {
		return "ClassBj [className=" + className + ", stus=" + Arrays.toString(stus) + "]";
	}
	

}
