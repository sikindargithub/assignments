package com.carapp.service;


import com.carapp.exceptions.CarNotFoundException;
import com.carapp.model.Car;
import com.carapp.repository.ICarRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarRentalServiceImpl implements ICarRentalService {

	ICarRentalRepository carRentalRepository;
	@Autowired
	public CarRentalServiceImpl(ICarRentalRepository carRentalRepository) {
		this.carRentalRepository = carRentalRepository;
	}
	@Override
	public void addCar(Car car) {
		carRentalRepository.save(car);
	}
	@Override
	public void updateCar(Car car) {
		carRentalRepository.save(car);
	}

	@Override
	public void deleteCar(int carNumber) {
		carRentalRepository.deleteById(carNumber);
	}

	@Override
	public List<Car> getAllCars() {
		return carRentalRepository.findAll().stream().sorted(Comparator.comparing(Car::getCarNumber)).collect(Collectors.toList());
	}

	@Override
	public Car getByCarNumber(int carNumber) {
		Car car =  carRentalRepository.findByCarNumber(carNumber);
		if(car==null)
			throw new CarNotFoundException("Invalid car number");
		return car;
	}


	@Override
	public List<Car> getByMileage(int mileage) throws CarNotFoundException {
		List<Car> carsByMileage = carRentalRepository.findByMileage(mileage).stream().sorted(Comparator.comparing(Car::getCarNumber)).collect(Collectors.toList());
		if(carsByMileage.isEmpty())
			throw new CarNotFoundException("cars of mileage "+mileage+" are not found ");
		return carsByMileage;
	}

	@Override
	public List<Car> getByPricePerHour(double pricePerHour) throws CarNotFoundException {
		List<Car> carsByPricePerHour =  carRentalRepository.findByPricePerHour(pricePerHour).stream().sorted(Comparator.comparing(Car::getCarNumber)).collect(Collectors.toList());
		if(carsByPricePerHour.isEmpty())
			throw new CarNotFoundException("cars of price "+pricePerHour+" are not found ");
		return carsByPricePerHour;
	}

	@Override
	public List<Car> getByBrandAndSeats(String brand, int noOfSeats) throws CarNotFoundException {
		List<Car> carsByBrandAndSeats =  carRentalRepository.findByBrandAndSeats(brand, noOfSeats).stream().sorted(Comparator.comparing(Car::getCarNumber)).collect(Collectors.toList());
		if(carsByBrandAndSeats.isEmpty())
			throw new CarNotFoundException("cars of brand "+brand+" and no of seats "+noOfSeats+ " are not found ");
		return carsByBrandAndSeats;
	}


	@Override
	public List<Car> getByBrandAndMileageAndPricePerHour(String brand, int mileage, double pricePerHour) throws CarNotFoundException {
		List<Car> carsByBrandMileageAndPrice = carRentalRepository.findByBrandAndMileageAndPricePerHour(brand,mileage,pricePerHour).stream().sorted(Comparator.comparing(Car::getCarNumber)).collect(Collectors.toList());
		if(carsByBrandMileageAndPrice.isEmpty())
			throw new CarNotFoundException("cars of brand "+brand+" , mileage "+mileage+" and price per hour "+pricePerHour+ " are not found ");
		return carsByBrandMileageAndPrice;
	}

	@Override
	public List<Car> getByMileageAndBrandAndModel(int mileage, String brand, String model) throws CarNotFoundException {
		List<Car> carsByMileageBrandModel = carRentalRepository.findByMileageAndBrandAndModel(mileage,brand,model).stream().sorted(Comparator.comparing(Car::getCarNumber)).collect(Collectors.toList());
		if(carsByMileageBrandModel.isEmpty())
			throw new CarNotFoundException("cars of mileage "+mileage+" , brand "+brand+" and model "+model+ " are not found ");
		return carsByMileageBrandModel;
	}
}
