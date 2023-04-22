package com.midterm.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.midterm.project.dto.RatingDto;
import com.midterm.project.entity.Movie;
import com.midterm.project.entity.Rating;
import com.midterm.project.exception.MovieException;
import com.midterm.project.repo.MovieRepo;
import com.midterm.project.repo.RatingRepo;


@Service
public class RatingServiceImpl implements IRatingService{
	
	@Autowired
	RatingRepo ratingRepo;

	@Autowired
	MovieRepo movieRepo;

	@Override
	public Rating addReview(RatingDto ratingsDTO) throws MovieException {
		// TODO Auto-generated method stub
		Movie movie = movieRepo.findById(ratingsDTO.getMovieId()).orElse(null);
		Double userRating = ratingsDTO.getRating();
		if (movie != null) {

			if (userRating >= 1 && userRating <= 10) {

				Rating ratings = new Rating();
				String customerId = SecurityContextHolder.getContext().getAuthentication().getName();
				ratings.setRating(userRating);
				ratings.setReview(ratingsDTO.getReview());
				ratings.setMovie(movie);
				ratings.setCustomerId(customerId);
				ratings = ratingRepo.save(ratings);
				
				Double totalRating=ratingRepo.getTotalRatingByMovie(movie.getMovieTitle());
				movie.setRating(totalRating);
				movieRepo.save(movie);
				
				return ratings;
			}else {
				System.out.println("Rating should be between 1 and 10");
				throw (new MovieException("Rating should be between 1 and 10"));
				
			}

		} else {

			System.out.println("Cannot find the movie");
			throw (new MovieException("Cannot find the movie"));
			// return null;
		}
	}

	@Override
	public List<Rating> getRatingsBymovieName(String moviename) {
		// TODO Auto-generated method stub
		return ratingRepo.findRatingsByMovieTitle(moviename.toLowerCase());
	}
	   

}
