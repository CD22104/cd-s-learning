package com.wfpan.super_final_demo;

/*public staitc void final*/
/*final = pass way = ��� ����*/
public /*final*/ class Animal {
	private String name = "animal"; 
	private int age =  18;
	protected final String SEX; /*final���ܱ����¸�ֵ:ֻ�ܸ�ֵһ��*/
	
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
		Animal an = new Animal("��è",5,"Ů");
//		com.wfpan.inheritancedemo.Animal@1db9742
		System.out.println(an); //ֱ�Ӵ�ӡ������ǵ��ö���toString����
		
	}

}
