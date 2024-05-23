package com.gfg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.WebApplicationContext;

import com.gfg.model.Employee;
import com.gfg.model.Student;

@SpringBootApplication
public class Application 
{
    @Bean
	/* public */ Employee getEmp()
	{
		return new Employee();
	}
	
	public static void main(String[] args)
	{
		ConfigurableApplicationContext appContext=SpringApplication.run(Application.class, args);
		// WebApplicationContext appContext2= (WebApplicationContext) SpringApplication.run(GeekforgeeksApplication.class, args);
		
		Student s=appContext.getBean(Student.class);
		s.print();
		
		Employee emp=appContext.getBean(Employee.class);
		emp.display();
	}
}
