package com.midterm.project.service;

import java.util.List;

import com.midterm.project.entity.Shows;



public interface IShowsService {
	public List<Shows> getShows();
	public List<Shows> searchShowsByTitle(String movieTitle);

}
