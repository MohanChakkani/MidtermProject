package com.midterm.project.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TheaterDto {
	private int theatreId;
	private String theatreName;
	private String  location;
	private int seatingCapacity;

}
