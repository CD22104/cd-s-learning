package com.wfpan.initializationdemo;

public class Animal {
	private String name = "animal"; 
	private int age =  18;
	protected final String SEX;
	
	public Animal() {
		SEX="nan ";
		System.out.println("Animal()");
	}

	public Animal(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		SEX=sex;
		System.out.println("Animal(name,age,sex)");
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
		return SEX;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + ", sex=" + SEX + "]";
	}
	
	public void say() {
		System.out.println("Animal");
	}

	public static void main(String[] args) {
		Animal an = new Animal("°×Ã¨",5,"Å®");
		System.out.println(an);
		
	}

}
