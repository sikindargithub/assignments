package com.carapp.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Car {

	@Id
	private Integer carNumber;
	@Column(length = 30)
	private String brand;
	@Column(length = 30)
	private String model;
	private int mileage;
	private int noOfSeats;
	private double pricePerHour;


}
