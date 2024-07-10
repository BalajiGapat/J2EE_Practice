package com.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DriverClass 
{
	public static void main(String[] args) 
	{
		ClassPathXmlApplicationContext ctx= new ClassPathXmlApplicationContext("bean-config.xml");
		System.out.println("spring container intialized...!!!");
		AccountService accountService=ctx.getBean("accountServiceImpl", AccountService.class);
		System.out.println(accountService.creditService(5000));
		
		// Close the application context to trigger @PreDestroy methods
		ctx.close();
	}
}
