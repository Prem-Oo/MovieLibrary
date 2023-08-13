package com.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovieController {

	@GetMapping
	public String showHome() {
		
		return "index";
	}
	
	@GetMapping("/id")
	public String showMovieID() {
		
		return "searchID";
	}
	
	@GetMapping("/name")
	public String showMovieName() {
		
		return "searchName";
	}
	
	@GetMapping("/collection")
	public String showMovieCol() {
		
		return "searchCol";
	}
	@GetMapping("/login")
	public String loginAdmin() {
		
		return "login";
	}
}
