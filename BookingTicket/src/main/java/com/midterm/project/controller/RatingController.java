package com.midterm.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.midterm.project.dto.RatingDto;
import com.midterm.project.entity.Rating;
import com.midterm.project.exception.MovieException;
import com.midterm.project.service.IRatingService;

@RestController
@RequestMapping("/movies")
public class RatingController {
	
	@Autowired
	IRatingService ratingServices;
	
	
	@PostMapping("/ratemovie")
	public Rating rateMovie(@RequestBody RatingDto ratings) throws MovieException {
		return ratingServices.addReview(ratings);
	}
	
	@GetMapping("/getratingsbymovie/{movieName}")
	public List<Rating> getRatingsByMovie(@PathVariable String movieName){
		return ratingServices.getRatingsBymovieName(movieName);
	}

}
