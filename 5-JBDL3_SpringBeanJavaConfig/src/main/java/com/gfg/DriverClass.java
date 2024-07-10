package com.gfg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gfg.repository.SavingAccountRepositoryImpl;

public class DriverClass 
{
	public static void main(String[] args)
	{
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
		SavingAccountRepositoryImpl sar=ctx.getBean("saving", SavingAccountRepositoryImpl.class);
		System.out.println(sar.creditRepo(5000));
	}
}
