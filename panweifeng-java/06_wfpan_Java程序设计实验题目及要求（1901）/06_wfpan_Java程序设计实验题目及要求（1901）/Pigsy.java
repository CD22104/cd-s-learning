/**
 * �������Ķ��塢����Ķ��塢�������Լ�������ʹ��
 *
 *
 * @author wfpan
 */


public class Pigsy {
	//���η� ���� ������;
	private String pigHead = "��ͷ";
	private String humanBody;
	private String Jcbp;
	private char sex;
	
	//���η� ����ֵ���� ������(�β��б�) {}
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
		
		pig.humanBody = "����";
		pig.Jcbp = "�ųݶ���";
		
		pig.say("�Ҳ�˵�˻�");
		pig.fly();
	}
}
