package com.midterm.project.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Theater {
	
	@Id
	 @Column(name="theatre_id")
	 int theatreId;
	 @Column(name="theatre_name")
	 String theatreName;
	 @Column(name="location")
	 String location;
	 @Column(name="seating_capacity")
	 int seatingCapacity;
	 @Column(name="ticket_price")
	 double ticketPrice;

}
