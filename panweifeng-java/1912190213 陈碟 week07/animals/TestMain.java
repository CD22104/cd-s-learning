package animals;

public class TestMain {
	public static void main(String[] args) {
	Cat c=new Cat(3);
	System.out.println(c.bodyLen);
	System.out.println(c.weight);
	c.say();
	Dog d=new Dog();
	System.out.println(d.bodyLen);
	c.name="small";
	c.catchMouse();
	} 
}
