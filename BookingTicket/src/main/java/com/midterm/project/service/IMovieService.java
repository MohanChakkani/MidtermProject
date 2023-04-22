package com.midterm.project.service;

import java.util.List;

import com.midterm.project.entity.Movie;

;

public interface IMovieService {
	public List<Movie> getMovies();
	public List<Movie>searchMoviesByKeyword(String keyword);
	

}
