package com.gfg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class E1SpringSecurityBeCoderYouTubeWithDatabaseApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(E1SpringSecurityBeCoderYouTubeWithDatabaseApplication.class, args);
		System.out.println("Balaji: "+new BCryptPasswordEncoder().encode("Balaji@123"));
		System.out.println("Sachin: "+new BCryptPasswordEncoder().encode("Sachin@123"));
	}
}
