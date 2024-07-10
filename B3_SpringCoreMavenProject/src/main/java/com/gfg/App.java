package com.gfg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        
       ApplicationContext context= new ClassPathXmlApplicationContext("bean-config.xml");
      
       Student std1=context.getBean("student1", Student.class);
       Student std2= (Student) context.getBean("student1");
       System.out.println(std1+" HashCode: "+std1.hashCode());
       System.out.println(std2+" HashCode: "+std2.hashCode());
      
       System.out.println();
       Student std3=context.getBean("student2", Student.class);
       Student std4= (Student) context.getBean("student2");
       System.out.println(std3+" HashCOde: "+std3.hashCode());
       System.out.println(std4+" HashCOde: "+std4.hashCode());
       
    }
}
