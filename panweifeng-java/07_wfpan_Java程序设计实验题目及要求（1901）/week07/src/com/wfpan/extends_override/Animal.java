//打包语句必须在第一行
package com.wfpan.extends_override;

public class Animal {
	
	//成员变量可以直接在声明处赋值
	private String name = "animla"; //类访问权限
	private int age;
	private String sex;
	
	//float没有访问修饰符，默认为default，但是不要用写，写了反而错
	float weight; //同包访问权限
	
	protected String skinColor; //子类访问权限
	
	public Animal() {
		super();
		System.out.println("wo shi animal");
	}
	
	/**
	 * 构造方法对成员变量赋值
	 * @param name
	 * @param age
	 * @param sex
	 */
	public Animal(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
	//如果一个方法仅被内部的方法调用，其它地方都不会被调用，则private
	private String setNameModify(String name) {
		return name + "11";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		//this 当前调用对象
		this.name = setNameModify(name);
//		this.name = name;
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
	
	protected void say() {
		System.out.println("I am an animal");
	}

}


