package com.gfg.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
public class MovieController
{
	@GetMapping("/all-movies") // http://localhost:8080/api/movies/all-movies
	public ResponseEntity<?> getMovies()
	{
		return new ResponseEntity<String>("this is move controller...!!!", HttpStatus.OK);
	}
}
