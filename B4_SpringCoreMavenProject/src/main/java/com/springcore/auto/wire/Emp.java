package com.springcore.auto.wire;

public class Emp 
{
	private Address address;
	
	public Emp() 
	{
		super();	
	}

	public Emp(Address address) 
	{
		super();
		this.address = address;
		System.out.println("In Emp.class constructor...");
	}

	public Address getAddress() 
	{
		return address;
	}

	public void setAddress(Address address) 
	{
		System.out.println("Setting value through setter i.e setAddress()...");
		this.address = address;
	}

	@Override
	public String toString() 
	{
		return "Emp [address=" + address + "]";
	}
	
}
