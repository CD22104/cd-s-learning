package com.wfpan.why_inheritance;
/*Java Bean - do = data object = to - transfermation object*/
public class Animal {
	protected String name;
	protected int age;
	protected String sex;
	
	public Animal() {
		super();
	}
	public Animal(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public void say() {
		System.out.println("Animal says.");
	}
	public void walk() {
		System.out.println("Animal walk.");
	}
	public void eat() {
		System.out.println("Animal eats.");
	}
	
	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	
}
