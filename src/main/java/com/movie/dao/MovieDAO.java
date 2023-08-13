package com.movie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.bean.Movie;

public interface MovieDAO extends JpaRepository<Movie, Integer> {
	 Movie findByMovieIdIgnoreCase(String id);

	 List<Movie> findByMovieNameContainingIgnoreCase(String name);
	 List<Movie> findByCollectionBetween(Integer from, Integer to);
}
