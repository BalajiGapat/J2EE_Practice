package com.gfg.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController 
{
	
	@GetMapping("/home") // http://localhost:8080/test/home 
    String getHome()
	{
        return "You are in the test-home page";
    }

	
    @GetMapping("/secure") // http://localhost:8080/test/secure
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    String getSecure()
    {
        return "You are in the test-secure page";
    }

    
    @GetMapping("/secret") // http://localhost:8080/test/secret
    @PreAuthorize("hasAnyRole('ADMIN')")
    String getSecret()
    {
        return "You are in the test-secret page";
    }
    
}
