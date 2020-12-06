package com.wfpan.week07lab;

public class TestMain {
	
	public static final int AGE_RAGE = 150;
	public static final int NAMECNT = 5;
	public static final int ARRAYLEN = 10;
	
	public static void main(String[] args) {
		Student[] stus = new Student[TestMain.ARRAYLEN];
//		ClassBj cbj = new ClassBj();
		ClassBj cbj = new ClassBj("rj1901", stus);
//		Student[] stus = cbj.getStus();
		
		for (int i = 0; i <10; i++) {
//			System.out.println(generateNames());
			stus[i] = new Student(generateNames(), generateAge(), generateSex());
//			stus[i].setSex("");
		}
		System.out.println(cbj);
	}
	
	
	public static String generateNames() {
		//A z
		char ncB = 'A';
		int range= 'z'-'A'; //29
		String name = "";
		char nc;
		int inc = 0;
		for (int i = 0; i < TestMain.NAMECNT; i++) {
			//[0,1)*29
			inc = (int)(Math.random()*29); //[0,29)
			nc = (char) ('A'+inc);
			name += nc;
		}
		return name;
	}
	
	public static int generateAge() {
		int age = (int)(Math.random()*TestMain.AGE_RAGE); //[0,150)
		return age;
	}
	
	public static String generateSex() {
		String[] sex = {"nan","nv"};
		int index = (int)(Math.random()*2); //[0,150)
		return sex[index];
	}

}
