package com.springcore.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration // this annotation tell to the spring IoC  container this class may contains @Bean annotated method and you are responsible for managing the life of that beans
// @ComponentScan(basePackages = "com.springcore.javaconfig")
public class JavaConfig 
{
	@Bean
	public Samosa getSamosa()
	{
		return new Samosa();
	}

	@Bean(name = {"student","temp","con"})
	public Student getStudent() 
	{
		return new Student(getSamosa());
	}
}
