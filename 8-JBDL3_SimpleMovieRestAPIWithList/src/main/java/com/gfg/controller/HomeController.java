package com.gfg.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
public class HomeController 
{
	@GetMapping("/home-page") // http://localhost:8080/api/home/home-page
	public ResponseEntity<?> homePage()
	{
		return new ResponseEntity<String>("this is home page...!!!", HttpStatus.OK);
	}
}

