package com.midterm.project.service;

import java.util.List;

import com.midterm.project.entity.Theater;



public interface ITheaterService {
	public List<Theater> getTheatres();	
	public List<Theater>searchTheatresByKeyword(String keyword);


}
