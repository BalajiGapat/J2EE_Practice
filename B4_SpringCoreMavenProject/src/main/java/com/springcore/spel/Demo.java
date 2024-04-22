package com.springcore.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("demoObj")
public class Demo 
{
	
	@Value("#{ 22+11 }")
	private int x;
	
	@Value("#{40*2+10}")
	private int y;
	
	// invoking static method => T(class).method(parameter)
	@Value("#{ T(java.lang.Math).sqrt(144) }")
	private double z;
	
	// invoking static variable => T(class).variable
	@Value("#{ T(java.lang.Math).PI }")
	private double e;
	
	// object creation in SpEL
	@Value("#{new java.lang.String('Durgesh Tiwari')}")
	private String name;
	
	@Value("#{ 8-6>3 }")
	private boolean isActive;
	
	public int getX() 
	{
		return x;
	}
	
	public void setX(int x) 
	{
		this.x = x;
	}
	
	public int getY() 
	{
		return y;
	}
	
	public void setY(int y) 
	{
		this.y = y;
	}
	
	
	
	public double getZ() 
	{
		return z;
	}
	
	public void setZ(double z) 
	{
		this.z = z;
	}
	
	
	public double getE()
	{
		return e;
	}
	
	public void setE(double e) 
	{
		this.e = e;
	}
	
	@Override
	public String toString() 
	{
		return "Demo [x=" + x + ", y=" + y + ", z=" + z + ", e=" + e + ", name=" + name + ", isActive=" + isActive
				+ "]";
	}
	
}
