package com.gfg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class F0DependancyInjectionDesignPatternApplication {

	public static void main(String[] args) 
	{
		ConfigurableApplicationContext context=SpringApplication.run(F0DependancyInjectionDesignPatternApplication.class, args);
		
		// Alien obj1=new Alien();
		
		Alien obj2=context.getBean(Alien.class);
		obj2.display();
		
		Alien obj3=context.getBean(Alien.class);
		
		System.out.println("obj2: "+obj2.hashCode());
		System.out.println("obj3: "+obj3.hashCode());
	}

}
