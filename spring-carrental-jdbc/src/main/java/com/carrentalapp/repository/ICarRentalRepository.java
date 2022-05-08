package com.carrentalapp.repository;

import com.carrentalapp.model.Car;

import java.util.List;


public interface ICarRentalRepository {

	// for adding cars and changing details
	void addCar(Car car);
	void deleteCar(int carNumber);
	void updateCar(int carNumber,double pricePerHour);


	// called by Client
	List<Car> findAllCars();
	Car findByCarNumber(int carNumber);
	List<Car> findByBrandAndSeats(String brand,int noOfSeats);
	List<Car> findByMileage(int mileage);
	List<Car> findByPricePerHour(double pricePerHour);


}
