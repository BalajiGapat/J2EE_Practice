package com.springcore.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Example 
{
	private String subject;

	
	public Example() 
	{
		super();
		System.out.println("in Example.class Constructor...");
	}

	@PostConstruct // call this method after constructor
	public void start() 
	{
		System.out.println("in Example.class start method...");
	}

	@PreDestroy // call this method before object destroy
	public void end() 
	{
		System.out.println("in Example.class end method...");
	}
	
	public String getSubject() 
	{
		return subject;
	}
	
	public void setSubject(String subject) 
	{
		this.subject = subject;
	}


	
	@Override
	public String toString() 
	{
		return "Example [ subject = " + subject + " ]";
	}

}
