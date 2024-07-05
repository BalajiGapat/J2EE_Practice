package pk1;

public class Demo 
{
	public static void main(String[] args) throws ClassNotFoundException 
	{
		System.err.println(Class.forName("java.lang.String"));
		System.err.println(Class.forName("java.lang.String").getName());
	}
}
