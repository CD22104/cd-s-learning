package com.wfpan.extends_override;
/**
 * ��̳С�������д��super�ؼ��ʡ���ʾ
 * @author wfpan
 *
 */
public class Cat extends Animal { //���̳С����ܶ�̳�
	String tail;
	
	public Cat() {
		super(); //���ø��๹�췽���������һ��
	}
	
	//������д�����֡������б�����ֵ����һ�£����η���Χ��=��������Ӧ����
	@Override
	public void say() {
		super.say(); //���ø��෽��
		System.out.println("I say miaomiao!");
	}
	
	//������д���������Լ����·���
	public void print() {
		System.out.println(super.skinColor); //���ø�������
		say();
	}

	public static void main(String[] args) {
		Cat c = new Cat();
		c.print();
	}

}
