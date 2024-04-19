package com.gfg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") // Type this url in browser => http://localhost:8080/api/home
public class HomeController 
{
	@GetMapping("/home")
	public String homePage()
	{
		System.out.println("This is home page...!!!");
		return "This is home Page...!!!";
	}
}
