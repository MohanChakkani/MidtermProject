package com.midterm.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.midterm.project.entity.Movie;
import com.midterm.project.service.IMovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
	@Autowired
	IMovieService movieServices;
	
	@GetMapping("/searchmovies/{keyword}")
	public List<Movie> searchMovies(@PathVariable String keyword) {
		System.out.println("Hello");
		return movieServices.searchMoviesByKeyword(keyword);
		
	}
	@GetMapping("/getMovies")
		public List<Movie> getMovies(){
			return movieServices.getMovies();
		}
	}


