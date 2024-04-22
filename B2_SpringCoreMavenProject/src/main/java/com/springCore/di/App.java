package com.springCore.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml"); // com/springCore/di/config.xml
        Student s1 = (Student) context.getBean("student1");
        System.out.println("hello Welcome to java...!!!");
        System.out.println(s1);
        
        
        
    }
}
