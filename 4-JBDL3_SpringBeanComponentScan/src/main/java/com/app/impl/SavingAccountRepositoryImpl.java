package com.app.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.app.AccountRepository;

@Component(value="saving")
@Primary
public class SavingAccountRepositoryImpl implements AccountRepository 
{
	@Override
	public String creditRepo(double amount) 
	{
		return "The amount of "+amount+" credited in your SAVING account...!!!";
	}

}
