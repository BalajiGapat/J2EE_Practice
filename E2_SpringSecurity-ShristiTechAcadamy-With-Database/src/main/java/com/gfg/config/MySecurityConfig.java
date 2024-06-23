package com.gfg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import com.gfg.service.CustomUserDetailsService;

@Component
@EnableWebSecurity
@EnableMethodSecurity
public class MySecurityConfig 
{
	// add two beans for authentication & authorization
	
	//1. Authentication Bean
	@Bean
	UserDetailsService userDetailsService()
	{
		return new CustomUserDetailsService();
	}
	
	// Bean for AuthenticationProvider it is just to inform 
	// which type of Authentication we are going to use
	@Bean AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService());
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	
	@Bean
	PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	
	//2. Authorization Bean
	@Bean SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
	{
		return httpSecurity
					.httpBasic(Customizer.withDefaults())
					.csrf(c->c.disable())
					.cors(c->c.disable())
					.authorizeHttpRequests(auths->
							auths.requestMatchers("/api/add-user", "/api/welcome")
								.permitAll()
								.requestMatchers("/api/user/**")
								// .hasAnyRole("ADMIN", "NORMAL")
								.authenticated()
								.requestMatchers("/api/admin/**")
								// .hasAnyRole("ADMIN")
								.authenticated()
							)
					.formLogin(f->f.disable())
					.build();
		 
	}
	
}
