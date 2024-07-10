package com.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!!!" );
        
        ApplicationContext context=new ClassPathXmlApplicationContext("com/springcore/config.xml");
        
        Student student11=(Student) context.getBean("student1"); 
        Student student22=(Student) context.getBean("student2");
        
        System.out.println(student11);
        System.out.println(student22);
        
    }
}
