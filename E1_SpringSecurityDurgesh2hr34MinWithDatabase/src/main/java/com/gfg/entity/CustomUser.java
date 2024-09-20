package com.gfg.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUser implements UserDetails 
{

	private MyUser myUser;
	
	public CustomUser(MyUser myUser) 
	{
		super();
		this.myUser = myUser;
	}
	
	@Override
	public String getUsername() 
	{
		return this.myUser.getUsername(); 
	}

	@Override
	public String getPassword() 
	{
		return this.myUser.getPassword();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		Set<SimpleGrantedAuthority> authorities=new HashSet<>();
		authorities.add(new SimpleGrantedAuthority(this.myUser.getRole()));
		
		return authorities;
	}
}
