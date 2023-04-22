package com.midterm.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midterm.project.entity.Theater;
import com.midterm.project.repo.TheaterRepo;


@Service
public class TheaterServiceImpl implements ITheaterService{
	
	@Autowired
	TheaterRepo repo;
	
	@Override
	public List<Theater> getTheatres() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<Theater> searchTheatresByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return repo.searchTheatresByKeyword(keyword.toLowerCase());
	}
	


}
