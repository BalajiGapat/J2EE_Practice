package com.gfg.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Employee 
{
	private int empId;
	private String empName;
	
	public Employee() 
	{
		super();
	}

	public Employee(int empId, String empName)
	{
		super();
		this.empId = empId;
		this.empName = empName;
	}

	public int getEmpId()
	{
		return empId;
	}

	public void setEmpId(int empId)
	{
		this.empId = empId;
	}

	public String getEmpName()
	{
		return empName;
	}

	public void setEmpName(String empName)
	{
		this.empName = empName;
	}

	public void display()
	{
		log.info("Logger: Eeployee class display method...!!!");
		//System.out.println("Employee class print method...!!!");
	}
	
	
	@Override
	public String toString() 
	{
		return "Employee [empId=" + empId + ", empName=" + empName + "]";
	}
	
}
