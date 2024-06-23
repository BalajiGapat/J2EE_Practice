package com.gfg.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gfg.model.CustomUser;
import com.gfg.model.MyUser;
import com.gfg.repository.MyUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	private MyUserRepository myUserRepository;
	
	// we are not going to call this method from controller 
	// MySecurityConfig class automatically call this method 
	// when user gives username & password to check whether 
	// user is authenticated or not
	@Override 
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
			MyUser myUser= myUserRepository.findByUsername(username)
				.orElseThrow( ()->new UsernameNotFoundException("user with username: "+username+" not present in database"));
				
			// String inUsername=myUser.getUsername();
			// String inPassword=myUser.getPassword();
			
			Set<String> set=myUser.getAuthorities();
			
			Set<GrantedAuthority> authorities=new HashSet<>();
			
			set.forEach(role->{
					GrantedAuthority auth=new SimpleGrantedAuthority(role);
					authorities.add(auth);
			});
			
			return new org.springframework.security.core.userdetails.User(username, myUser.getPassword(), authorities);
			
			// OR 
			// return new CustomUser(myUser);		
	}
	
	// this method is used to save user in database
	public MyUser addUser(MyUser myUser)
	{
		return myUserRepository.save(myUser);
	}
	
}
