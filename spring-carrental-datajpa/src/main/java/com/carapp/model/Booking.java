package com.carapp.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@NamedQuery(name = "getByCarNumberAndDays",query = " from Booking b where b.carNumber = ?1 and noOfDays = ?2")
public class Booking {
	@Id
	private Integer bookingId;
	@Column(length = 30)
	private String name;
	@Column(length = 30)
	private String gender;
	private Date date;
	private Time time;
	@Column(length = 30)
	private long phoneNo;
	private boolean paymentDone;
	private int noOfDays;
	private double totalCost;
	private Integer carNumber;

	public Booking(Integer bookingId, String name, String gender, Date date, Time time, long phoneNo, boolean paymentDone, int noOfDays) {
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
