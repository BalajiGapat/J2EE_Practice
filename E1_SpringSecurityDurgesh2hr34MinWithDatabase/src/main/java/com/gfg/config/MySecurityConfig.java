package com.gfg.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.gfg.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class MySecurityConfig 
{
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception 
	{
        return httpSecurity
                .httpBasic(x->Customizer.withDefaults())
                .authorizeHttpRequests(authz ->
                        authz.requestMatchers("/api/**", "/test/home")
                                .permitAll()
                                .requestMatchers("/test/**")
                                .authenticated()
                                 // .requestMatchers("/secure")
                                 // .authenticated()
                                 // .requestMatchers("/secret")
                                 //  .hasAnyAuthority("ADMIN")
                )
                .formLogin((x)->x.disable())
                .csrf(x->x.disable())
                .cors(x->x.disable())
                .build();
    }
	
	
	// my added code	
	@Bean
	DaoAuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(customUserDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
			
		return daoAuthenticationProvider;
	}
	
	
	
	
	
	
	
	
//	@Bean
//    UserDetailsService userDetailsService()
//	{
//        UserDetails user = User.builder()
//                .username("user")
//                .password(passwordEncoder().encode("User@123"))
//                .roles("USER")
//                .build();
//       
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(passwordEncoder().encode("Admin@123"))
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }

    @Bean
    BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
    
}
