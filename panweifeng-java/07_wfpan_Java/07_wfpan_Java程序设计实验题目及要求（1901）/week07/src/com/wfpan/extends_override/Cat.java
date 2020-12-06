package com.wfpan.extends_override;
/**
 * 类继承、方法重写、super关键词、演示
 * @author wfpan
 *
 */
public class Cat extends Animal { //单继承、不能多继承
	String tail;
	
	public Cat() {
		super(); //调用父类构造方法：必须第一行
	}
	
	//方法重写：名字、参数列表、返回值都得一致，修饰符范围》=父类中相应方法
	@Override
	public void say() {
		super.say(); //调用父类方法
		System.out.println("I say miaomiao!");
	}
	
	//除了重写可以扩充自己的新方法
	public void print() {
		System.out.println(super.skinColor); //调用父类属性
		say();
	}

	public static void main(String[] args) {
		Cat c = new Cat();
		c.print();
	}

}
