package pk1;

class MyClass
{
	private String name;
	
	public MyClass() 
	{
		System.out.println("in constructor");
		name="balaji";
	}
	
	
	{
		System.out.println("in instance block");
		name="sachin";
	}
	
	public String getName() {
		return name;
	}
}

public class Demo2 
{
	public static void main(String[] args) throws ClassNotFoundException 
	{
		MyClass obj1=new MyClass();
		System.out.println(obj1.getName());
		MyClass obj2=new MyClass();
		System.out.println(obj2.getName());
				
	}
}
