package com.gfg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application 
{
	public static void main(String[] args) 
	{
		System.out.println("in main method...!!!");
		ConfigurableApplicationContext cntx=SpringApplication.run(Application.class, args);
		String[] arr=cntx.getBeanDefinitionNames();
		
		for(String s : arr)
			System.out.println("=> "+s);
	}
}
