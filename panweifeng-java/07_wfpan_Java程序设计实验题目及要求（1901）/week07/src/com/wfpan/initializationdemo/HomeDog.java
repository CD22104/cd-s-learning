package com.wfpan.initializationdemo;

public class HomeDog extends Dog {
	private String maoColor;

	public HomeDog() {
		/*this,super*/
		super();
		System.out.println("HomeDog()");
	}

	public HomeDog(String maoColor) {
		this.maoColor = maoColor;
		this.sex = "";
		System.out.println("HomeDog(maoColor)");
	}
	public String getMaoColor(/*this,super*/) {
		return maoColor;
	}

	public void setMaoColor(String maoColor) {
		this.maoColor = maoColor;
	}
	
	public static void main(String[] args) {
		HomeDog hd = new HomeDog("½ðÉ«¾íÃ«");
		
	}
	

}
