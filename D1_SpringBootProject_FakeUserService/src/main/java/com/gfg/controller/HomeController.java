package com.gfg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gfg.model.User;
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
		System.out.println("This is Home Page => start");
		String str="This is Home Page";
		str=str.toUpperCase();
		str=str.toLowerCase();
		
		return ResponseEntity.ok().body(str);
	}
	
	@GetMapping("/all-users") // http://localhost:8080/api/all-users
	public ResponseEntity<?> getAllUsers()
	{
		System.out.println("in getAllUsers() => start");
		return fakeUserService.getAllUsers();
	}
	
	@GetMapping("/user/username/{username}") // http://localhost:8080/api/user/username/Balaji
	public ResponseEntity<?> getUserByUserName(@PathVariable("username") String userName)
	{
		System.out.println("in getUserByUserName() => start");
		return fakeUserService.getUserByUserName(userName);
	}
	
	@PostMapping("/add-user") // http://localhost:8080/api/add-user
	public ResponseEntity<?> addUser(@RequestBody User user)
	{
		System.out.println("in addUser() => start");
		return fakeUserService.addUser(user);
	}
		
}
