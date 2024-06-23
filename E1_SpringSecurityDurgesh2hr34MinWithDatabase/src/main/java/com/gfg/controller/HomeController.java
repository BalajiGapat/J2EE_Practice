package com.gfg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gfg.entity.MyUser;
import com.gfg.service.CustomUserDetailsService;
import com.gfg.service.FakeUserService;

@RestController
@RequestMapping("/api")
public class HomeController 
{
	@Autowired
	private FakeUserService fakeUserService;
	
	
	@GetMapping("/home-page") // http://localhost:8080/api/home-page
	public ResponseEntity<?> homePage()
	{
		return ResponseEntity.ok().body("This is Home Page");
	}
	
	@GetMapping("/all-users") // http://localhost:8080/api/all-users
	public ResponseEntity<?> getAllUsers()
	{
		return fakeUserService.getAllUsers();
	}
	
	@GetMapping("/user/username/{username}") // http://localhost:8080/api/user/username/Balaji
	public ResponseEntity<?> getUserByUserName(@PathVariable("username") String userName)
	{
		return fakeUserService.getUserByUserName(userName);
	}
	
	@PostMapping("/add-user") // http://localhost:8080/api/add-user
	public ResponseEntity<?> addUser(@RequestBody MyUser user)
	{
		return fakeUserService.addUser(user);
	}
		
}
