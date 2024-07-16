package com.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DriverClass 
{
	public static void main(String[] args) 
	{
		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean-config.xml");
		Address add1=ctx.getBean("address1", Address.class);
		Address add2=ctx.getBean("address1", Address.class);
		System.out.println("add1 hashCode: "+add1.hashCode());
		System.out.println("add2 hashCode: "+add2.hashCode());
		
		System.out.println();
		
		Student stud1= ctx.getBean("student1", Student.class);
		Student stud2= ctx.getBean("student1", Student.class);
		System.out.println("stud1 hashCode: "+stud1.hashCode());
		System.out.println("stud2 hashCode: "+stud2.hashCode());	
	}
}
