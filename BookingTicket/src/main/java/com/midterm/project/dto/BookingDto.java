package com.midterm.project.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDto {
	private int showId;
	private String paymentMethod;
	private int seatNo;

}
