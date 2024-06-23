package com.gfg;

import org.springframework.stereotype.Component;

@Component(value = "lap1") // name of bean
//@Scope(value = "prototype") // scope of bean
public class Laptop 
{
	private int lId;
	private String brand;
	
	public Laptop() {
		super();
	}
	public Laptop(int lId, String brand) {
		super();
		this.lId = lId;
		this.brand = brand;
	}
	
	public void print()
	{
		System.out.println("in Laptop class print method...!!!");
	}
	
	public int getlId() {
		return lId;
	}
	public void setlId(int lId) {
		this.lId = lId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Override
	public String toString() {
		return "Laptop [lId=" + lId + ", brand=" + brand + "]";
	}
	
	
}
