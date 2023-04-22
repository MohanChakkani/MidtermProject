package com.midterm.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.midterm.project.entity.Booking;
import com.midterm.project.entity.Shows;


@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {
	@Modifying
	@Query("DELETE FROM Booking b  WHERE b.bookingId = :bookingId AND b.customerId=:customerId ")
	void deleteByIdAndCustomerId(@Param("bookingId") int bookingId, @Param("customerId") String customerId);
	//@Query("SELECT b FROM Bookings b WHERE b.customerId = :customerId")
	public List<Booking> findByCustomerId(String customerId);
	@Query("SELECT COUNT(b) FROM Booking b WHERE b.show.id = :showId")
	public Long getBookedCount(@Param("showId") int showId);
	@Query("SELECT COUNT(b) FROM Booking b WHERE b.show.id = :showId AND b.seatNo = :seatNo")
	public Long getSeatNo(@Param("showId") int showId, @Param("seatNo") int seatNo);
	@Query("SELECT b.show FROM Booking b WHERE b.bookingId = :bookingId AND b.customerId=:customerId")
	public Shows getShow(@Param("bookingId")int bookingId, @Param("customerId") String customerId);
	

}
