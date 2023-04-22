package com.midterm.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.midterm.project.entity.Rating;


@Repository
public interface RatingRepo extends JpaRepository<Rating, Integer> {
	@Query("SELECT r FROM Rating r WHERE LOWER(r.movie.movieTitle) like %:title%")
	public List<Rating> findRatingsByMovieTitle(@Param("title") String movieName);

	@Query("SELECT AVG(r.rating) FROM Rating r WHERE r.movie.movieTitle like %:title%")
	public Double getTotalRatingByMovie(@Param("title") String movieName);


}
