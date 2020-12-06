package com.wfpan.why_inheritance;

public class Dog extends Animal {
	private float dogHeight;

	public Dog() {
		super();
	}

	public Dog(float dogHeight) {
		super();
		this.dogHeight = dogHeight;
	}

	public float getDogHeight() {
		return dogHeight;
	}

	public void setDogHeight(float dogHeight) {
		this.dogHeight = dogHeight;
	}

	@Override
	public String toString() {
		return "Dog [dogHeight=" + dogHeight + "]";
	}
	
	/*ǰ��Ĳ��������ҵ�Ҫ��������Ҫ��д*/
	@Override
	public void say() {
		System.out.println("Dog says wangwang.");
	}
	@Override
	public void walk() {
		System.out.println("Dog walk.");
	}
	@Override
	public void eat() {
		System.out.println("Dog eats.");
	}
	
	/*����*/
	public void watchDoor() {
		System.out.println("Dog watches door");
	}
	
	
	
	

}
