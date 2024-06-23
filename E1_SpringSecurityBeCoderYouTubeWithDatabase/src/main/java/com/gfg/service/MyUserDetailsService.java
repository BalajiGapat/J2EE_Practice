package com.gfg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gfg.config.CustomUser;
import com.gfg.entity.Employee;
import com.gfg.repository.EmpRepository;

@Service
public class MyUserDetailsService implements UserDetailsService 
{
	@Autowired
	private EmpRepository empRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException 
	{
		Employee emp=empRepository.findByEmail(email);
		
		if(emp==null)
		{
			throw new UsernameNotFoundException("user with email: "+email+" is not found...!!!");
		}
		else
		{
			return new CustomUser(emp);
		}
	}

}
