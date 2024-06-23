package com.gfg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gfg.entity.CustomUser;
import com.gfg.entity.MyUser;
import com.gfg.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		MyUser myUser= userRepository.findByUsername(username);
		
		if(myUser==null)
			throw new UsernameNotFoundException("user with given username: "+username+" not present in database");
		else
			return new CustomUser(myUser);
	}

}
