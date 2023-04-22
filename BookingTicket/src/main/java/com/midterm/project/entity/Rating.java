package com.midterm.project.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Rating {
	@Id
	@Column(name="rating_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int ratingId;
	
	@Column(name="customer_id")
	String customerId;
	
	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie movie;
	
	@Column(name="rating")
	Double rating;
	
	@Column(name="review")
	String review;
    

}
