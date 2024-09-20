package com.gfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gfg.entity.MyUser;
import com.gfg.repository.UserRepository;

@SpringBootApplication
public class E1SpringSecurityDurgesh2hr34MinWithDatabaseApplication implements CommandLineRunner
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired // (required=true)
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) 
	{
		SpringApplication.run(E1SpringSecurityDurgesh2hr34MinWithDatabaseApplication.class, args);
		System.out.println("in main method...!!!");
	}

	@Override
	public void run(String... args) throws Exception 
	{
		System.out.println("in run method...!!!");
		
		MyUser user1=new MyUser();
		user1.setUsername("balaji");
		user1.setEmail("balaji@gmail.com");
		user1.setPassword(this.bCryptPasswordEncoder.encode("Balaji@123"));
		user1.setRole("ADMIN");
		
		MyUser user2=new MyUser();
		user2.setUsername("sachin");
		user2.setEmail("sachin@gmail.com");
		user2.setPassword(this.bCryptPasswordEncoder.encode("Sachin@123"));
		user2.setRole("NORMAL");
		
		this.userRepository.save(user1);
		this.userRepository.save(user2);
	}
}
