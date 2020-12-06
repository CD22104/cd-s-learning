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
	
	/*前面的不能满足我的要求，所以我要重写*/
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
	
	/*新增*/
	public void watchDoor() {
		System.out.println("Dog watches door");
	}
	
	
	
	

}
