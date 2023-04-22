package com.midterm.project.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Movie {
	@Id
	@Column(name="movie_id")
	int movieId;
	@Column(name="movie_title")
	String movieTitle;
	String genre;
	String director;
	int duration;
	double rating;
    

}
