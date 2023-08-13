package com.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.bean.Movie;
import com.movie.dao.MovieDAO;

@Service
public class MovieService {
	
	@Autowired
	MovieDAO repo;
	
	public Movie getMoviesID( String id) {
		System.out.println(id);
		 Movie movie = repo.findByMovieIdIgnoreCase(id);
		 if(movie!=null) {
			 return movie;
		 }
		 return null;
		
	}
	

	public List<Movie> getMoviesName(String name) {
		System.out.println(name);
		List<Movie> movies = repo.findByMovieNameContainingIgnoreCase(name);
		if(movies.size()==0) {
			return null;
		}
		return movies;
	}
	
	public List<Movie> getMoviesCol(Integer from,Integer to) {
		System.out.println(from +" "+to);
		List<Movie> movies = repo.findByCollectionBetween(from, to);
		
		if(movies.size()==0) {
			return null;
		}
		return movies;
	}
	
	public boolean adminLogin(String user,String pass){
		return ("prem@gmail.com".equals(user) && "prem".equals(pass))?true:false;
		
	}
	public Movie addMovie(Movie movie){
		return repo.save(movie);
	}
	
}
