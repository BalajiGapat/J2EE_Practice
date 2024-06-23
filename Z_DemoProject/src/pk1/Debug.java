package pk1;

public class Debug
{
	public static int sum(int n1, int n2)
	{
		return add(n1, n2);
	}

	private static int add(int n1, int n2) 
	{
		return n1+n2;
	}
	
	public static void main(String[] args)
	{
		int ans=sum(12, 14);
		System.out.println("in main method");
		System.out.println("ans :"+ans);
	}
}
