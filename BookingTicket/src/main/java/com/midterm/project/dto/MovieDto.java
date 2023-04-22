package com.midterm.project.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieDto {
	private int movieId;
	private String movieTitle;
	private String genre;
	private String hero;
	private int duration;

}
