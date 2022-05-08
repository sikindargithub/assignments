package com.carapp.service;

import com.carapp.exceptions.CarNotFoundException;
import com.carapp.model.Car;

import java.util.List;
import java.util.Optional;

public interface ICarRentalService {
	
	// crud queries
	void addCar(Car car);
	void updateCar(Car car);
	void deleteCar(int carNumber);



	// derived queries
	List<Car> getAllCars();
	List<Car> getByMileage(int mileage) throws CarNotFoundException;
	List<Car> getByPricePerHour(double pricePerHour) throws CarNotFoundException;

	// custom queries
	List<Car> getByBrandAndSeats(String brand,int noOfSeats) throws CarNotFoundException;
	List<Car> getByBrandAndMileageAndPricePerHour(String brand,int mileage,double pricePerHour) throws CarNotFoundException;
	List<Car> getByMileageAndBrandAndModel(int mileage,String brand,String model) throws CarNotFoundException;
	Car getByCarNumber(int carNumber) throws CarNotFoundException;
}
