package com.carrentalapp.service;

import com.carrentalapp.repository.CarRentalRepositoryImpl;
import com.carrentalapp.repository.ICarRentalRepository;
import com.carrentalapp.exceptions.CarNotFoundException;
import com.carrentalapp.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class CarRentalServiceImpl implements ICarRentalService {

	@Autowired
	ICarRentalRepository carRentalRepository;

	@Override
	public void addCar(Car car) {
		carRentalRepository.addCar(car);
	}

	@Override
	public void deleteCar(int carNumber) throws CarNotFoundException {
		carRentalRepository.deleteCar(carNumber);
	}

	@Override
	public void updateCar(int carNumber, double pricePerHour) throws CarNotFoundException {
		carRentalRepository.updateCar(carNumber,pricePerHour);
	}

	@Override
	public List<Car> getAllCars() {
		return carRentalRepository.findAllCars().stream().sorted(Comparator.comparing(Car::getCarNumber)).collect(Collectors.toList());
	}

	@Override
	public Car getByCarNumber(int carNumber) {
		Car car = carRentalRepository.findByCarNumber(carNumber);
		if(car==null)
			throw new CarNotFoundException("Invalid car number");
		return car;
	}


	@Override
	public List<Car> getByBrandAndSeats(String brand, int noOfSeats) throws CarNotFoundException {
		List<Car> carsByBrandSeats =  carRentalRepository.findByBrandAndSeats(brand, noOfSeats).stream().sorted(Comparator.comparing(Car::getCarNumber)).collect(Collectors.toList());
		if(carsByBrandSeats.isEmpty())
			throw new CarNotFoundException("cars of brand "+brand+" and no of seats "+noOfSeats+" are not found");
		return carsByBrandSeats;
	}

	@Override
	public List<Car> getByMileage(int mileage) throws CarNotFoundException {
		List<Car> carsByMileage = carRentalRepository.findByMileage(mileage).stream().sorted(Comparator.comparing(Car::getCarNumber)).collect(Collectors.toList());
		if(carsByMileage.isEmpty())
			throw new CarNotFoundException("cars of mileage "+mileage+" are not found");
		return carsByMileage;
	}

	@Override
	public List<Car> getByPricePerHour(double pricePerHour) throws CarNotFoundException {
		List<Car> carsByPrice = carRentalRepository.findByPricePerHour(pricePerHour).stream().sorted(Comparator.comparing(Car::getCarNumber)).collect(Collectors.toList());
		if(carsByPrice.isEmpty())
			throw new CarNotFoundException("cars of price per hour "+pricePerHour+" are not found");
		return carsByPrice;
	}
}
