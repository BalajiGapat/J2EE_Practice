package com.journal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController
{
    @GetMapping("/home")
    public ResponseEntity<String> homePage()
    {
        System.out.println("in home pahe controller...!!!!");
        // return new ResponseEntity<>("This is home page...!!!", HttpStatus.OK);
       return ResponseEntity.ok().body("This is home page...!!!");
    }
}
