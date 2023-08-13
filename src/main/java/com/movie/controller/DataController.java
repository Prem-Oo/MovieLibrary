package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.movie.bean.Movie;
import com.movie.service.MovieService;

@Controller()
public class DataController {

	@Autowired
	MovieService service;
	
	@GetMapping("/movieID")
	public String showMovieByID(@RequestParam String id,Model m) {
		Movie movie = service.getMoviesID(id);
		if(movie==null) 
			return "errorPage";
		m.addAttribute("movies",movie );
		return "movielist";
	}
	
	@GetMapping("/movieName")
	public String showMovieByNames(@RequestParam String name,Model m) {
		List<Movie> movies = service.getMoviesName(name);
		if(movies==null) 
			return "errorPage";
		m.addAttribute("movies",movies );
		return "movielist";
	}
	
	
	@GetMapping("/movieCol")
	public String showMovieByCol(@RequestParam Integer from,@RequestParam Integer to,Model m) {
		List<Movie> movies = service.getMoviesCol(from, to);
		if(movies==null) 
			return "errorPage";
		m.addAttribute("movies",movies );
		return "movielist";
	}
	
	@PostMapping("/adminlogin")
	public String adminLogin(@RequestParam String user,@RequestParam String password) {
		
		return  service.adminLogin(user,password)?"loginSuccess": "loginFail";
	}
	
	@PostMapping("/addmovie")
	public String addMovie(@ModelAttribute Movie movie) {
		Movie m = service.addMovie(movie);
		if(m!=null) {
			return "success";
		}
		return  null;
	}
	
	
}
