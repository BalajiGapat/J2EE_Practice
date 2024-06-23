package pk1;

public class Debug2
{
	public static int getSum(int[] arr)
	{
		int sum=0;
		for(int i=0;i<arr.length;i++)
			sum+=arr[i];
		return sum+5;
	}
	
	
	public static void main(String[] args)
	{
		System.out.println("going to debug our simple java application");
		int[] arr= {1,2,3,4,5,6};
		System.out.println("Sum="+getSum(arr));
	}
	
}
