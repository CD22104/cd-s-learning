package com.wfpan.super_final_demo;

public class Dog extends Animal {
	//super：超类，父类
	private int salary;
	protected String sex = "女"; //over write -> overwirte -> 重写、覆盖
	
//	wrapper
	public Dog() {
		super();
//		System.out.println(super.sex);
		super.say();
	}

	public Dog(String name, int age) {
		super(name,age,"女");
	}
	
	public void say() {
		System.out.println("dog");
	}
	
	public static void main(String[] args) {
		Dog g = new Dog();
	}
}
