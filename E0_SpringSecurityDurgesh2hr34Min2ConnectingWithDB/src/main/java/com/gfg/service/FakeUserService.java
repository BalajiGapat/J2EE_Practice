package com.gfg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gfg.model.User;

@Service
public class FakeUserService 
{
	private static  List<User> list=new ArrayList<>();
	
	static
	{
		list.add(new User("Balaji", "Balaji@123", "balaji@gmail.com", "ADMIN"));
		list.add(new User("Abhijit", "abhijit@123", "abhijit@gmail.com", "CUSTOMER"));
		list.add(new User("Akash", "akash@123", "akash@gmail.com", "CUSTOMER"));
		list.add(new User("Saurabh", "saurabh@123", "saurabh@gmail.com", "CUSTOMER"));
	}
	
	
	public ResponseEntity<?> getAllUsers()
	{
		return ResponseEntity.ok().body(list); 
	}
	
	public ResponseEntity<?> getUserByUserName(String usrName)
	{
		List<User> myList=list.stream()
							.filter(user->user.getUseName().equals(usrName))
							.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(myList); 
	}
	
	public ResponseEntity<?> addUser(User user)
	{
		list.add(user);
		return ResponseEntity.ok().body("User added to list : "+user);
	}
	
	
}
