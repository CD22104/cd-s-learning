package com.wfpan.super_final_demo;

public class Dog extends Animal {
	//super�����࣬����
	private int salary;
	protected String sex = "Ů"; //over write -> overwirte -> ��д������
	
//	wrapper
	public Dog() {
		super();
//		System.out.println(super.sex);
		super.say();
	}

	public Dog(String name, int age) {
		super(name,age,"Ů");
	}
	
	public void say() {
		System.out.println("dog");
	}
	
	public static void main(String[] args) {
		Dog g = new Dog();
	}
}
