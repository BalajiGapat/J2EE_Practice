package com.gfg.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api")
public class HomeController 
{
	@GetMapping("/homepage")
	public String homePage()
	{
		log.info("This is Home Page...!!!");
		return "This is Home Page...!!!";
	}
	
	@GetMapping("/home")
	public ResponseEntity<?> home()
	{
		// return ResponseEntity.ok("this is home...");
		return new ResponseEntity<String>("This is home page...!!!", HttpStatus.OK);
	}
}
