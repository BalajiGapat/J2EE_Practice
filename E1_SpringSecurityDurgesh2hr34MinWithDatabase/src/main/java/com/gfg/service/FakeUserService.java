package com.gfg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gfg.entity.MyUser;

@Service
public class FakeUserService 
{
	private static  List<MyUser> list=new ArrayList<>();
	
	static
	{
		list.add(new MyUser("Balaji", "Balaji@123", "balaji@gmail.com", "ADMIN"));
		list.add(new MyUser("Abhijit", "abhijit@123", "abhijit@gmail.com", "CUSTOMER"));
		list.add(new MyUser("Akash", "akash@123", "akash@gmail.com", "CUSTOMER"));
		list.add(new MyUser("Saurabh", "saurabh@123", "saurabh@gmail.com", "CUSTOMER"));
	}
	
	
	public ResponseEntity<?> getAllUsers()
	{
		return ResponseEntity.ok().body(list); 
	}
	
	public ResponseEntity<?> getUserByUserName(String usrName)
	{
		List<MyUser> myList=list.stream()
							.filter(user->user.getUsername().equals(usrName))
							.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(myList); 
	}
	
	public ResponseEntity<?> addUser(MyUser user)
	{
		list.add(user);
		return ResponseEntity.ok().body("User added to list : "+user);
	}
	
	
}
