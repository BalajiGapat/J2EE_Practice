package com.springcore.lifecycle;

public class Samosa 
{
	private double price;
	
	public Samosa() 
	{
		super();
	}
	
	public void hey()  // configured as initialization method
	{
		System.out.println("Inside init method: hey how are you?");
	}

	public void bye() // configured as destroy method
	{
		System.out.println("Inside destroy method: bye bye i am going to die");
	}


	public double getPrice() 
	{
		return price;
	}

	public void setPrice(double price) 
	{
		System.out.println("Setting price");
		this.price = price;
	}
		

	@Override
	public String toString() 
	{
		return "Samosa [price=" + price + "]";
	}

}
