package com.wfpan.super_final_demo;

/*public staitc void final*/
/*final = pass way = 后代 子类*/
public /*final*/ class Animal {
	private String name = "animal"; 
	private int age =  18;
	protected final String SEX; /*final不能被从新赋值:只能赋值一次*/
	
	public Animal() {
		super();
		SEX="nan ";
//		SEX = "nv";
		System.out.println("Animal()");
	}

	public Animal(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		SEX=sex;
//		this.sex = sex;
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
	
	public /*final*/ void say() {
		System.out.println("Animal");
	}

	public static void main(String[] args) {
		Animal an = new Animal("白猫",5,"女");
//		com.wfpan.inheritancedemo.Animal@1db9742
		System.out.println(an); //直接打印对象就是调用对象toString方法
		
	}

}
