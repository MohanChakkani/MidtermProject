package com.midterm.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.midterm.project.dto.BookingDto;
import com.midterm.project.entity.Booking;
import com.midterm.project.exception.MovieException;
import com.midterm.project.service.IBookingService;

@RestController
@RequestMapping("/movies")
public class BookingController {
	@Autowired
	IBookingService bookingServices;

	@PostMapping("/bookticket")
	public Booking bookTicket(@RequestBody BookingDto booking) throws MovieException {
		return bookingServices.bookTicket(booking);
	}

	@GetMapping("/getmybookinghistory")
	public List<Booking> getAllBookings() {
		return bookingServices.getAllMyBookings();
	}

	@DeleteMapping("/cancelbooking/{bookingId}")
	public String cancelBooking(@PathVariable int bookingId) throws MovieException {
		return bookingServices.cancelMyBooking(bookingId);

	}


}
