package com.gfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gfg.model.User;
import com.gfg.repository.UserRepository;

@SpringBootApplication
public class E0SpringSecurityDurgesh2hr34MinApplication implements CommandLineRunner
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) 
	{
		SpringApplication.run(E0SpringSecurityDurgesh2hr34MinApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		// new User("Balaji", "Balaji@123", "balaji@gmail.com", "ADMIN");
		// new User("Akash", "Akash@123", "akash@gmail.com", "CUSTOMER");
		User user1=new User();
		user1.setUseName("Balaji");
		user1.setEmail("Balaji@123");
		user1.setPassword(this.bCryptPasswordEncoder.encode("Balaji@123"));
		user1.setRole("ADMIN");
		
		User user2=new User();
		user2.setUseName("Akash");
		user2.setEmail("Akash@123");
		user2.setPassword(this.bCryptPasswordEncoder.encode("Akash@123"));
		user2.setRole("CUSTOMER");
	}

}
