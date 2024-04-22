package com.springcore.stereotype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test
{
	public static void main(String[] args) 
	{
		ApplicationContext con = new ClassPathXmlApplicationContext("com/springcore/stereotype/stereoconfig.xml");
		Student student = con.getBean("ob", Student.class);
		System.out.println("HashCode of student1: "+student.hashCode());
		
//		System.out.println(student);
//		System.out.println(student.getAddress());
//		System.out.println(student.getAddress().getClass().getName());
		
		Student student2 = con.getBean("ob",Student.class);
		System.out.println("HashCode of student2: "+student2.hashCode());
		
		Teacher teacher1 = con.getBean("teacher", Teacher.class);
		Teacher teacher2 = con.getBean("teacher", Teacher.class);
		System.out.println("HashCode of teacher1: "+teacher1.hashCode());
		System.out.println("HashCode of teacher2: "+teacher2.hashCode());
	}

}
