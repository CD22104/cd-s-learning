package com.wfpan.static_demo;

/**
 * static: ��������������Ƿ��������
 * static �����ε��������������
 * static �����εķ�������ķ���
 * ջ���ѣ���������static��������
 * ��  vs ��������ԡ�����ķ���
 * 
 * �Ķ����� д���
 * @author lenovo
 *
 */
public class Dog extends Animal {
	private int salary;
	protected String sex = "Ů";
	private static int level;
	
	public Dog() {
		super();
		super.say();
	}

	public Dog(String name, int age) {
		super(name,age,"Ů");
	}
	
	public void say() {
		System.out.println("dog");
	}
	
	public static void ss() {
		/*�ࡢ���� => this -> ���� -> ���󡢶��󡢶���*/
		System.out.println();
	}
	
	public static void main(String[] args) {
		Dog.level = 1; //������Ա����еĶ�����
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
