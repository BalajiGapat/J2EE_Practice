package com.gfg.model;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Student 
{
	private int id;
	private String name;
	
	public Student() 
	{
		super();
	}
	
	public Student(int id, String name)
	{
		super();
		this.id = id;
		this.name = name;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
	
	public void print()
	{
		log.info("Logger: student class print method...!!!");
		//System.out.println("student class print method...!!!");
	}

	@Override
	public String toString()
	{
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
}
