package com.gfg;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gfg.model.MyUser;
import com.gfg.repository.MyUserRepository;

@SpringBootApplication
public class E2SpringSecurityShristiTechAcadamyWithDatabaseApplication implements CommandLineRunner
{
	@Autowired
	private MyUserRepository myUserRepository;
	
	@Bean(name="myBean")
	BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) 
	{
		System.out.println("in main method at starting...!!!");
		SpringApplication.run(E2SpringSecurityShristiTechAcadamyWithDatabaseApplication.class, args);
		System.out.println("in main method at end...!!!");
	}

	@Override
	public void run(String... args) throws Exception 
	{
		System.out.println("in run method...!!!");
		MyUser admin=new MyUser();
		MyUser user=new MyUser();
		
		Set<String> adminRoles=new HashSet<>();
		adminRoles.add("ADMIN");
		adminRoles.add("NORMAL");
		
		Set<String> userRoles=new HashSet<>();
		userRoles.add("NORMAL");
		
		admin.setUsername("balaji");
		admin.setPassword(passwordEncoder().encode("Balaji@123"));
		admin.setAuthorities(adminRoles);
		
		
		user.setUsername("sachin");
		user.setPassword(passwordEncoder().encode("Sachin@123"));
		user.setAuthorities(userRoles);
		
		myUserRepository.save(admin);
		myUserRepository.save(user);	
	}

}
