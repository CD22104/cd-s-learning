//����������ڵ�һ��
package com.wfpan.extends_override;

public class Animal {
	
	//��Ա��������ֱ������������ֵ
	private String name = "animla"; //�����Ȩ��
	private int age;
	private String sex;
	
	//floatû�з������η���Ĭ��Ϊdefault�����ǲ�Ҫ��д��д�˷�����
	float weight; //ͬ������Ȩ��
	
	protected String skinColor; //�������Ȩ��
	
	public Animal() {
		super();
		System.out.println("wo shi animal");
	}
	
	/**
	 * ���췽���Գ�Ա������ֵ
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
	
	//���һ�����������ڲ��ķ������ã������ط������ᱻ���ã���private
	private String setNameModify(String name) {
		return name + "11";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		//this ��ǰ���ö���
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


