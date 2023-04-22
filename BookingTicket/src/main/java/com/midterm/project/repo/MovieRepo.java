package com.midterm.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.midterm.project.entity.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer> {
	
	@Query("SELECT m FROM Movie m WHERE LOWER(m.genre) like %:key% OR LOWER(m.movieTitle) like %:key%")
	public List<Movie> searchMoviesByKeyword(@Param("key") String keyword);

}
