package com.gfg.repository;

public class SavingAccountRepositoryImpl implements AccountRepository
{
	@Override
	public String creditRepo(double amount)
	{
		return "The amount of "+amount+" credited in your SAVING account...!!!";
	}
}
