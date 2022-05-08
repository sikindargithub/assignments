package com.carrentalapp.model;

import lombok.*;

import java.sql.Time;
import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Booking {
	
	private Integer bookingId;
	private String name;
	private String gender;
	private LocalDate date;
	private Time time;
	private long phoneNo;
	private boolean paymentDone;
	private int noOfDays;
	private double totalCost;
	private Integer carNumber;

	public Booking(Integer bookingId, String name, String gender, LocalDate date, Time time, long phoneNo, boolean paymentDone, int noOfDays) {
		this.bookingId = bookingId;
		this.name = name;
		this.gender = gender;
		this.date = date;
		this.time = time;
		this.phoneNo = phoneNo;
		this.paymentDone = paymentDone;
		this.noOfDays = noOfDays;

	}





}
