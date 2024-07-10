package com.app.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.app.AccountRepository;
import com.app.AccountService;

@Component // this annotation replaces <bean> tag in xml file
public class AccountServiceImpl implements AccountService
{
	@Autowired(required = true)
	@Qualifier(value="credit")
	private AccountRepository accountRepository;
	
	@Override
	public String creditService(double amount)
	{
		return accountRepository.creditRepo(amount);
	}
	
	@PostConstruct
	public void myInit()
	{
		System.out.println("=======Some intialization task========");
	}
	
	@PreDestroy
	public void myDistroy()
	{
		System.out.println("=======Some resource closing task========");
	}
	
}
