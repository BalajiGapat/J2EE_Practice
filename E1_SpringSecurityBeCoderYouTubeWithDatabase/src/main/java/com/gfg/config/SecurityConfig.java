package com.gfg.config;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.gfg.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig 
{
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Bean 
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		return http
		        .csrf(csrf -> csrf.disable())
		        // .cors(cors -> cors.disable())
		        .authorizeHttpRequests(authorize -> authorize
			            .requestMatchers("/index")
			            .permitAll()
			            .anyRequest()
			            .authenticated()
		        )
		        .formLogin(Customizer.withDefaults())
		        .build();
		  
	}
	
	@Bean 
	PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	
//	UserDetailsService myUserDetailsService()
//	{
//		return new MyUserDetailsService();
//	}
//	
	@Bean
	DaoAuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(myUserDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		
		return daoAuthenticationProvider;
	}

	
	/*
	 
	@Bean
	UserDetailsService myUserDetailsService()
	{
		return new MyUserDetailsService();
	}
	 
	
	@Bean AuthenticationManager authenticationManager()
	{
		AuthenticationProvider dbAuthenticationProvider=authenticationProvider(myUserDetailsService());
		return new ProviderManager(dbAuthenticationProvider);
	}
	
	
	// Helper method 
	public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService)
	{
		return new AuthenticationProvider()  // this is anonymous class
		{
			@Override
			public boolean supports(Class<?> authentication) 
			{
				return authentication.equals(UsernamePasswordAuthenticationToken.class);
			}
			
			@Override
			public Authentication authenticate(Authentication authentication) throws AuthenticationException 
			{
				if (authentication == null)
                {
                    throw new AuthenticationCredentialsNotFoundException(" no authentication");

                }
                
                UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
                String inUsername = token.getName();
                String inPasssword = token.getCredentials().toString();

                if(inUsername == "")
                {
                    throw new AuthenticationCredentialsNotFoundException(" no authentication");

                }
                
                UserDetails user = userDetailsService.loadUserByUsername(inUsername);

                if(!passwordEncoder().matches(inPasssword, user.getPassword()))
                {
                    throw new AuthenticationCredentialsNotFoundException(" invalid creds");
                }
                
                return new UsernamePasswordAuthenticationToken(inUsername, inPasssword,user.getAuthorities());
			}
		};
	}
	
	*/
	
	
	
}
