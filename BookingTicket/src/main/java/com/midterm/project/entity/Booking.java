package com.midterm.project.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Booking {
	@Id
	@Column(name="booking_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int bookingId;
	
	@Column(name="customer_id")
	String customerId;
	
	@ManyToOne
	@JoinColumn(name = "show_id")
	private Shows show;
	
	@Column(name="booking_date")
	Date bookingDate;
	
	
	@Column(name="total_amount")
	Double totalAmount;
	
	@Column(name="payment_method")
	String paymentMethod;
	
	@Column(name="seat_no")
	int seatNo;


}
