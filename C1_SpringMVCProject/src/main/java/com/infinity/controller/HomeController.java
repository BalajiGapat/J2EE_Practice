package com.infinity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController 
{
	@GetMapping("/home") // incoming request => http://localhost:8080/C1_SpringMVCProject/home
	public String homePage()
	{
		System.out.println("this is home url...!!!");
		return "welcome"; // return only page/view name
	}
}
