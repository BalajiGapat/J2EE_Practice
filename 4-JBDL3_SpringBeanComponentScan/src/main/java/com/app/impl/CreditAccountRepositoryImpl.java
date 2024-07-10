package com.app.impl;

import org.springframework.stereotype.Component;

import com.app.AccountRepository;

@Component("credit")
public class CreditAccountRepositoryImpl implements AccountRepository 
{
	@Override
	public String creditRepo(double amount) 
	{
		return "The amount of "+amount+" credited in your CREDIT account...!!!";
	}

}
