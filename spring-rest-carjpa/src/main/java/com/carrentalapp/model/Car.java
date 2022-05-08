package com.carrentalapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Car {

    @Id
    private Integer carNumber;
    @Column(length=30)
    private String brand;
    @Column(length=30)
    private String model;
    private int noOfSeats;
    @Column(length=30)
    private String carType;
    private double pricePerHour;
    private int mileage;
    @Column(length=30)
    private String color;
    @Column(length=30)
    private String transmission;
    private double rating;
    private double kmsDriven;
    @Column(length=30)
    private String pickupType;
    @Column(length=30)
    private String fuelType;
    private boolean insuranced;


}
