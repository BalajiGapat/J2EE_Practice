package com.gfg.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		Set<String> set=myUser.getAuthorities();
		Set<GrantedAuthority> authorities=new HashSet<>();
		
		authorities=set.stream()
				.map(role->new SimpleGrantedAuthority(role))
				.collect(Collectors.toSet());
		return authorities;
	}

	@Override
	public String getPassword() 
	{
		return myUser.getPassword();
	}

	@Override
	public String getUsername() 
	{
		return myUser.getUsername();
	}

}
