package com.gfg.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController
{
	@GetMapping("/index") // http://localhost:8080/home/index  // open
	public ResponseEntity<?> indexPage()
	{
		return ResponseEntity.ok().body("This is index Page...!!!");
		// return "index";
	}
	
	@GetMapping("/about") // http://localhost:8080/home/about // secure
	// @PreAuthorize("hasAnyRole('NORMAL', 'ADMIN')")
	public ResponseEntity<?> aboutPage()
	{
		return ResponseEntity.ok().body("This is about Page...!!!");
		// return "about";
	}
	
	@GetMapping("/profile") // http://localhost:8080/home/profile
	// @PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<?> profilePage()
	{
		return ResponseEntity.ok().body("This is profile Page...!!!");
		// return "profile";
	}
}
