package com.gfg;

import org.springframework.stereotype.Component;

@Component
public class AccountServiceImpl implements AccountService 
{
	public AccountServiceImpl() 
	{
		System.out.println("Constructor get called...!!!");
	}

	@Override
	public void credit() 
	{

	}
}

interface AccountService
{
	void credit();
}

