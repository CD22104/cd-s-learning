package week09;

public class ex2 {
	public static String getaname()
	{
		char c;
		String linkNo = "";
	    // 用字符数组的方式随机
	    String model = "abcdefghijklmnopqrstuvwxyz";
	    char[] m = model.toCharArray();
	    for (int j = 0; j < 10; j++) {
	        c= m[(int) (Math.random() * 26)];
	        linkNo = linkNo + c;
	    }
		return linkNo;
	}
	public static void main(String[] args) {
		PetShop ps=new PetShop();
		String kk="";
		kk=getaname();
		for(int i=0;i<1000;i++)
		{
			ps.pets[i]=new Pet();
			ps.pets[i].name=kk;
			ps.pets[i].age=(int)(Math.random()*100);
			ps.pets[i].weight=(int)(Math.random()*100);
			ps.pets[i].activity=(int)(Math.random()*100);
		}
		for(int i=0;i<1000;i++)
		{
			System.out.println(ps.pets[i].name);
			System.out.println(ps.pets[i].age);
			System.out.println(ps.pets[i].weight);
			System.out.println(ps.pets[i].activity);
		}
	}
}
