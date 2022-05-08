package com.carrentalapp.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Car {
	
	private Integer carNumber;
	private String brand;
	private String model;
	private int mileage;
	private int noOfSeats;
	private double pricePerHour;


}
