package com.springcore.javaconfig;

// @Component
public class Student 
{	
	private Samosa samosa;
	
	public Student(Samosa samosa) 
	{
		super();
		this.samosa = samosa;
	}

	public Samosa getSamosa()
	{
		return samosa;
	}

	public void setSamosa(Samosa samosa) 
	{
		this.samosa = samosa;
	}

	public void study() 
	{
		this.samosa.display();
		System.out.println("student is reading book");
	}

	@Override
	public String toString() {
		return "Student [samosa=" + samosa + "]";
	}
	
	
}
