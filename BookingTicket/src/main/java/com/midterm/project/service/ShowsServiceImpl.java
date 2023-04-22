package com.midterm.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midterm.project.entity.Shows;
import com.midterm.project.repo.ShowsRepo;


@Service
public class ShowsServiceImpl implements IShowsService {
	
	@Autowired
	ShowsRepo repo;
	
	@Override
	public List<Shows> getShows() {
		
		// TODO Auto-generated method stub
		return repo.findAll();
		
	}

	@Override
	public List<Shows> searchShowsByTitle(String movieTitle) {
		// TODO Auto-generated method stub
		return repo.searchShowsByTitle(movieTitle.toLowerCase());
	}


}
