package com.gfg.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gfg.entity.Employee;

// map customerUser with spring supplied User
public class CustomUser implements UserDetails 
{
	
	public Employee emp;
	
	
	
	
	public CustomUser(Employee emp) 
	{
		super();
		this.emp = emp;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		SimpleGrantedAuthority authority=new SimpleGrantedAuthority(emp.getRole());
		return Arrays.asList(authority);
	}

	@Override
	public String getPassword() 
	{
		return emp.getPassword();
	}

	@Override
	public String getUsername() 
	{
		return emp.getEmail(); // email of user is acts as username
	}

}
