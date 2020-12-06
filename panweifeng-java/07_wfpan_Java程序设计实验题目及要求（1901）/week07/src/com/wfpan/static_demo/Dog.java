package com.wfpan.static_demo;

/**
 * static: 这个方法、属性是否属于类的
 * static 的修饰的属性是类的属性
 * static 的修饰的方法是类的方法
 * 栈、堆（方法区【static变量】）
 * 类  vs 对象的属性、对象的方法
 * 
 * 阅读程序 写结果
 * @author lenovo
 *
 */
public class Dog extends Animal {
	private int salary;
	protected String sex = "女";
	private static int level;
	
	public Dog() {
		super();
		super.say();
	}

	public Dog(String name, int age) {
		super(name,age,"女");
	}
	
	public void say() {
		System.out.println("dog");
	}
	
	public static void ss() {
		/*类、对象 => this -> 概念 -> 对象、对象、对象*/
		System.out.println();
	}
	
	public static void main(String[] args) {
		Dog.level = 1; //类的属性被所有的对象共享
		Dog g2 = new Dog();
		Dog g3 = new Dog();
		System.out.println(g2.level);
		g2.level = 3;
		System.out.println(g3.level);
//		salary = 1;
/*		Dog g = new Dog();
		g.level = 2;
		g.salary = 100;*/
	}
}
