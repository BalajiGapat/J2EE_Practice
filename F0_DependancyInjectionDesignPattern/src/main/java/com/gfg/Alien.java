package com.gfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
// @Scope(value = "prototype")
public class Alien 
{
	private int aId;
	private String aName;
	private String tech;
	
	@Autowired // by default @Autowired searches by type
	@Qualifier("lap1") // telling to spring container search by name
	private Laptop laptop;
	
	
	public Alien() 
	{
		System.out.println("in Alien parameterless constructor...!!!");
	}

	public Alien(int aId, String aName, String tech) 
	{
		super();
		this.aId = aId;
		this.aName = aName;
		this.tech = tech;
	}
	
	
	public void display()
	{
		System.out.println("Alien class display method...");
		laptop.print();
	}

	public int getaId() 
	{
		return aId;
	}

	public void setaId(int aId) 
	{
		this.aId = aId;
	}

	public String getaName() 
	{
		return aName;
	}

	public void setaName(String aName)
	{
		this.aName = aName;
	}

	public String getTech() 
	{
		return tech;
	}

	public void setTech(String tech) 
	{
		this.tech = tech;
	}

	@Override
	public String toString() 
	{
		return "Alien [aId=" + aId + ", aName=" + aName + ", tech=" + tech + "]";
	}
	
}
