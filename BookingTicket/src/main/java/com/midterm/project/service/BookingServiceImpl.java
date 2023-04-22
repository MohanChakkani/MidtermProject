package com.midterm.project.service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.midterm.project.dto.BookingDto;
import com.midterm.project.entity.Booking;
import com.midterm.project.entity.Shows;
import com.midterm.project.exception.MovieException;
import com.midterm.project.repo.BookingRepo;
import com.midterm.project.repo.ShowsRepo;
import com.midterm.project.repo.TheaterRepo;


@Service
public class BookingServiceImpl implements IBookingService {
	
	@Autowired
	BookingRepo bookigRepo;

	@Autowired
	ShowsRepo showsRepo;

	@Autowired
	TheaterRepo theatresRepo;

	@Override
	public List<Booking> getAll() {

		return bookigRepo.findAll();
	
	}

	@Override
	public Booking bookTicket(BookingDto bookings) throws MovieException {
		
		
		    Shows show = showsRepo.findById(bookings.getShowId()).orElseThrow(() -> new MovieException("Invalid ShowID"));

		    LocalDateTime showDateTime = show.getShowDate().toLocalDate().atTime(show.getShowTime().toLocalTime());
		    LocalDateTime now = LocalDateTime.now();
		    String paymentMethod = bookings.getPaymentMethod();

		    int theatreId = show.getTheatre().getTheatreId();
		    double ticketPrice = show.getTheatre().getTicketPrice();
		    Long noOfBookedSeats = bookigRepo.getBookedCount(show.getShowId());
		    Long totalCapacity = theatresRepo.getTotalCapacity(theatreId);
		    int availableSeats = (int) (totalCapacity - noOfBookedSeats);

		    if (availableSeats <= 0) {
		        throw new MovieException("House full");
		    }

		    int seatNo = bookings.getSeatNo();
		    if (seatNo > totalCapacity || seatNo <= 0) {
		        throw new MovieException("Invalid Seat Number");
		    }

		    if (bookigRepo.getSeatNo(show.getShowId(), seatNo) != 0) {
		        throw new MovieException("Seat already booked");
		    }

		    if (showDateTime.isBefore(now)) {
		        throw new MovieException("Film already started");
		    }

		    PaymentMethod payment = PaymentMethod.fromString(paymentMethod);
		    if (payment == null) {
		        throw new MovieException("Payment method not supported");
		    }

		    Booking details = new Booking();
		    details.setSeatNo(seatNo);
		    details.setBookingDate(Date.valueOf(now.toLocalDate()));
		    details.setCustomerId(SecurityContextHolder.getContext().getAuthentication().getName());
		    details.setPaymentMethod(paymentMethod);
		    details.setShow(show);
		    details.setTotalAmount(ticketPrice);

		    show.setAvailableSeats(availableSeats - 1);

		    return bookigRepo.save(details);
		}

		enum PaymentMethod {
		    CC("CC"),
		    DC("DC"),
		    UPI("UPI");

		    private final String value;

		    PaymentMethod(String value) {
		        this.value = value;
		    }

		    public static PaymentMethod fromString(String value) {
		        for (PaymentMethod paymentMethod : PaymentMethod.values()) {
		            if (paymentMethod.value.equals(value)) {
		                return paymentMethod;
		            }
		        }
		        return null;
		    }
		

	}
	@Override
	public List<Booking> getAllMyBookings() {

		String customerId = SecurityContextHolder.getContext().getAuthentication().getName();
		return bookigRepo.findByCustomerId(customerId);
	}

	@Transactional
	@Override
	public String cancelMyBooking(int bookingId) throws MovieException {
		String customerId = SecurityContextHolder.getContext().getAuthentication().getName();

		Shows show = bookigRepo.getShow(bookingId, customerId);
		System.out.println(show);
		if (show != null) {
			Date showDate = show.getShowDate();
			Time showTime = show.getShowTime();
			LocalDateTime showDateAndTime = showDate.toLocalDate().atTime(showTime.toLocalTime());
			LocalDateTime now = LocalDateTime.now();
			int availableSeats=show.getAvailableSeats();

			if (showDateAndTime.isAfter(now)) {
				
				
				bookigRepo.deleteByIdAndCustomerId(bookingId, customerId);
				show.setAvailableSeats(availableSeats+1);
				showsRepo.save(show);
				return "Booking is cancelled and you will get the refund in 3 working days";

			} else {
			
				
				System.out.println("You cannot cancel the Show, its Already Started");
				throw(new MovieException("You cannot cancel the Show, its Already Started"));
				//return "You cannot cancel the Show, its Already Started";
			}
		} else {
			System.out.println("Cannot find a show with the booking Id");
			throw(new MovieException("Cannot find a show with the booking Id"));
			//return "Cannot find a show with the booking Id";
		}

	}

}
