package com.gfg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class MySecuriyConfig 
{
	// add two beans for authentication & authorization
	
	//1. Authentication Bean
	@Bean
	UserDetailsService userDetailsService()
	{
		// create users
		// in-memory authentication only for learning purpose not for production
		
		UserDetails admin=User.withUsername("balaji")
								.password(passwordEncoder().encode("Balaji@123"))
								.roles("ADMIN", "NORMAL")
								.build();
		
		UserDetails normal=User.withUsername("sachin")
								.password(passwordEncoder().encode("Sachin@123"))
								.roles("NORMAL")
								.build();
		
		// returns the object of one of the implementation of UserDetailsService
		return new InMemoryUserDetailsManager(admin, normal);
	}
	
	@Bean
	PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	//2. Authorization Bean
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
	{

		return httpSecurity
					.httpBasic(x->Customizer.withDefaults())
					.csrf(c->c.disable())
					.cors(c->c.disable())
					.authorizeHttpRequests(auths->
								auths.requestMatchers("/api/welcome")
									.permitAll()
									.requestMatchers("/api/all-books").hasAnyRole("ADMIN", "NORMAL")
									.requestMatchers("api/add-book").hasAnyRole("ADMIN")
									
							)
					.formLogin(Customizer.withDefaults())
					.build();
	}
	
}
