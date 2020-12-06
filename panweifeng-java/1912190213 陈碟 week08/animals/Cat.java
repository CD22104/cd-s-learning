package animals;

public class Cat extends Animal{
//	public String catogory;
//	public float weight;
//	public float bodyLen;
	public String name;
	public void say()
	{
		System.out.println("cat says...");
		super.say();
	}
//	public void walk()
//	{
//		System.out.println("cat walks");
//	}
	public void catchMouse() {
		System.out.println(this.name+"cat catches mouse...");
	}
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString();
		}
	public Cat()
	{
		System.out.println("cat");
	}
	public Cat(float bodyLen)
	{
		this.bodyLen=bodyLen;
	}
	
	
}
