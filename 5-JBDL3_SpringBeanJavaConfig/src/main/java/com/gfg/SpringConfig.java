package com.gfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gfg.repository.AccountRepository;
import com.gfg.repository.SavingAccountRepositoryImpl;
import com.gfg.service.AccountService;
import com.gfg.service.AccountServiceImpl;

@Configuration
public class SpringConfig
{
	@Bean("saving")
	public AccountRepository getAccountRepository()
	{
		return new SavingAccountRepositoryImpl(); 
	}
	
	public AccountService getAccountService()
	{
		return new AccountServiceImpl();
	}
}
