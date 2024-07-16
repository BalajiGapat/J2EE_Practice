package com.gfg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
public class MovieController
{
	@GetMapping(value = "/all-movies",  produces = "text/html") // http://localhost:8080/api/movies/all-movies
	public String getMovies()
	{
		// return new ResponseEntity<String>("This is move controller...!!!", HttpStatus.OK);
		// return  "<h1>This is movie Controller...!!!</h1>";
		return "This is movie Controller...!!!";
	}
}
