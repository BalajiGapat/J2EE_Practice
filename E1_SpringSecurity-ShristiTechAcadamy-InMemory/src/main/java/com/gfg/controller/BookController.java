package com.gfg.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class BookController
{
	
	
	@GetMapping("/welcome") // http://localhost:8080/api/welcome => public URL
	public ResponseEntity<?> welcomePage()
	{
		System.out.println("in welcomePage()...!!!");
		return ResponseEntity.ok().body("Welcome to online Book Library");
	}
	
	@GetMapping("/all-books") // http://localhost:8080/api/all-books => accessible only for authenticated users
	public ResponseEntity<?> showAllBooks()
	{
		System.out.println("in showAllBooks()...!!!");
		return ResponseEntity.ok().body("show all books...!!!");
	}
	
	@GetMapping("/add-book") // http://localhost:8080/api/add-book => accessible for only admin user
	public ResponseEntity<?> addBook()
	{
		System.out.println("in addBook()...!!!");
		return ResponseEntity.ok().body("add book to library...!!!");
	}
}
