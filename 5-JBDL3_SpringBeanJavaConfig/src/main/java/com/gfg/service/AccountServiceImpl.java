package com.gfg.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.gfg.repository.AccountRepository;

public class AccountServiceImpl implements AccountService 
{
	@Autowired
	public AccountRepository  accountRepository;
	
	@Override
	public String creditService(double amount) 
	{
		return accountRepository.creditRepo(amount);
	}
}
