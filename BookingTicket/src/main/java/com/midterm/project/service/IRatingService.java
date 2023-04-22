package com.midterm.project.service;

import java.util.List;

import com.midterm.project.dto.RatingDto;
import com.midterm.project.entity.Rating;
import com.midterm.project.exception.MovieException;


public interface IRatingService {
	public Rating addReview(RatingDto ratingsDTO) throws MovieException;
	public List<Rating> getRatingsBymovieName(String moviename);


}
