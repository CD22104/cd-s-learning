package animals;

public class Animal {
	public String catogory;
	public float weight=1.f;
	public float bodyLen=2.f;
	public void say()
	{
		System.out.println("animal says...");
	}
	public void walk()
	{
		System.out.println("animal walks");
	}
	public Animal()
	{
		;
	}
	public Animal(String category)
	{
		System.out.println(category);
	}
}
