package com.wfpan.encapsulation;

import com.wfpan.extends_override.Animal;

/**
 * 封装演示
 * @author wfpan
 *
 */
public class BigBigCat extends Animal{

	public static void main(String[] args) {
		BigBigCat bbc = new BigBigCat();
//		bbc.age //无法访问
		bbc.skinColor = "black"; //子类访问权限

	}

}
