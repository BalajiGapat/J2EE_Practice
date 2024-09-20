package com.gfg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gfg.model.MyUser;
import com.gfg.service.CustomUserDetailsService;

@RestController
@RequestMapping("/api")
public class UserController 
{
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/welcome") // http://localhost:8080/api/welcome => public URL
	public String welcomePage()
	{
		return "this is welcome page...!!!";
	}
	
	
	@PostMapping("/add-user") // http://localhost:8080/api/add-user => public URL
	public MyUser saveMyUser(@RequestBody MyUser myUser)
	{
		String password=myUser.getPassword();
		String encodedPassword=passwordEncoder.encode(password);
		MyUser user=new MyUser(null, myUser.getUsername(), encodedPassword, myUser.getAuthorities());
		
		return customUserDetailsService.addUser(user);	
	}
	
	@GetMapping("/user/secure") // http://localhost:8080/api/user/secure
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_NORMAL')")
	public String secure()
	{
		return "this is secure api...!!!";
	}
	
	@GetMapping("/admin/secret") // http://localhost:8080/api/admin/secret
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String secret()
	{
		return "this is secret api...!!!";
	}
}
