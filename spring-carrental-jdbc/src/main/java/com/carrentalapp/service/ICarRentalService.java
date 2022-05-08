package com.carrentalapp.service;

import com.carrentalapp.exceptions.CarNotFoundException;
import com.carrentalapp.model.Car;
import java.util.List;

public interface ICarRentalService {
	
	// called by Admin
	void addCar(Car car);
	void deleteCar(int carNumber);
	void updateCar(int carNumber,double pricePerHour);
	
	// called by Client
	List<Car> getAllCars();
	Car getByCarNumber(int carNumber) throws CarNotFoundException;
	List<Car> getByBrandAndSeats(String brand,int noOfSeats) throws CarNotFoundException;
	List<Car> getByMileage(int mileage) throws CarNotFoundException;
	List<Car> getByPricePerHour(double pricePerHour) throws CarNotFoundException;

}
