/**
 * 请理解类的定义、对象的定义、对象属性及方法的使用
 *
 *
 * @author wfpan
 */


public class Pigsy {
	//修饰符 类型 属性名;
	private String pigHead = "猪头";
	private String humanBody;
	private String Jcbp;
	private char sex;
	
	//修饰符 返回值类型 方法名(形参列表) {}
	public void say(String content) {
		System.out.println("I am a pig. I say " + content);
	}
	public void fly() {
		System.out.println("I can fly");
	}
	public void dating() {
		System.out.println("I have many gf");
	}
	
	public static void main(String[] args) {
//		Pigsy pig = new Pigsy();
		Pigsy pig = null;
		pig = new Pigsy();
		
		pig.humanBody = "人身";
		pig.Jcbp = "九齿钉耙";
		
		pig.say("我不说人话");
		pig.fly();
	}
}
