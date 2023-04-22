package com.midterm.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.midterm.project.entity.Theater;
import com.midterm.project.service.ITheaterService;



public class TheaterController {
	@Autowired
	ITheaterService theatreServices;
	
	@GetMapping("/searchTheatres/{keyword}")
	public List<Theater> searchTheatres(@PathVariable String keyword) {
		return theatreServices.searchTheatresByKeyword(keyword);
	}
	

}
