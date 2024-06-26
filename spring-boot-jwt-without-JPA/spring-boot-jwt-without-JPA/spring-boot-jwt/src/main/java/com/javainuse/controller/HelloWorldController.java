package com.javainuse.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
public class HelloWorldController 
{
	@RequestMapping({ "/hello" }) // http://localhost:8080/hello
	public String hello() 
	{
		return "Hello World";
	}
}
