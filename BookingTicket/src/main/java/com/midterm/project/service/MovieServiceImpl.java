package com.midterm.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midterm.project.entity.Movie;
import com.midterm.project.repo.MovieRepo;



@Service
public class MovieServiceImpl implements IMovieService{
	
	@Autowired
	MovieRepo repo;

	@Override
	public List<Movie> getMovies() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<Movie> searchMoviesByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return repo.searchMoviesByKeyword(keyword.toLowerCase());
	}


}
