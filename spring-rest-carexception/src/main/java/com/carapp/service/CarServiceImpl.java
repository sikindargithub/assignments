package com.carapp.service;

import com.carapp.exceptions.CarNotFoundException;
import com.carapp.model.Car;
import com.carapp.repository.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements ICarService {

    @Autowired
    ICarRepository iCarRepository;
    @Override
    public void addCar(Car car) {
        iCarRepository.save(car);
    }

    @Override
    public void updateCar(Car car) {
        iCarRepository.save(car);
    }

    @Override
    public void deleteCar(int carNumber) {
        iCarRepository.deleteById(carNumber);
    }

    @Override
    public List<Car> getAll() {
        return iCarRepository.findAll();
    }

    @Override
    public List<Car> getByBrandAndModel(String brand, String model) {
        List<Car> carsList = iCarRepository.findByBrandAndModel(brand,model).stream().sorted(Comparator.comparing(Car::getBrand)).collect(Collectors.toList());
        if(carsList.isEmpty())
            throw new CarNotFoundException("cars of "+brand+" and "+model+" are not found");
        return carsList;
    }

    @Override
    public List<Car> getByMileage(int mileage) {
        List<Car> carsList = iCarRepository.findByMileage(mileage).stream().sorted(Comparator.comparing(Car::getBrand)).collect(Collectors.toList());
        if(carsList.isEmpty())
            throw new CarNotFoundException("cars of "+mileage+" are not found");
        return carsList;
    }

    @Override
    public List<Car> getByPricePerHourLessThan(double pricePerHour) {
        List<Car> carsList = iCarRepository.findByPricePerHourLessThan(pricePerHour).stream().sorted(Comparator.comparing(Car::getBrand)).collect(Collectors.toList());
        if(carsList.isEmpty())
            throw new CarNotFoundException("cars of "+pricePerHour+" are not found");
        return carsList;
    }

    @Override
    public List<Car> getByNoOfSeats(int noOfSeats) {
        List<Car> carsList = iCarRepository.findByNoOfSeats(noOfSeats).stream().sorted(Comparator.comparing(Car::getBrand)).collect(Collectors.toList());
        if(carsList.isEmpty())
            throw new CarNotFoundException("cars of "+noOfSeats+" are not found");
        return carsList;
    }

    @Override
    public List<Car> getByColorAndRating(String color, double rating) {
        List<Car> carsList = iCarRepository.findByColorAndRating(color,rating).stream().sorted(Comparator.comparing(Car::getBrand)).collect(Collectors.toList());
        if(carsList.isEmpty())
            throw new CarNotFoundException("cars of "+color+" and "+rating+" are not found");
        return carsList;
    }

    @Override
    public List<Car> getByRatingAndMileage(double rating, int mileage) {
        List<Car> carsList = iCarRepository.findByRatingAndMileage(rating,mileage).stream().sorted(Comparator.comparing(Car::getBrand)).collect(Collectors.toList());
        if(carsList.isEmpty())
            throw new CarNotFoundException("cars of "+rating+" and "+mileage+" are not found");
        return carsList;
    }

    @Override
    public Car getById(int carNumber) {
       return iCarRepository.findById(carNumber).orElseThrow(()-> new CarNotFoundException("car not found"));
    }

    @Override
    public List<Car> getByDistanceAndFuel(double kmsDriven, String fuelType) {
        List<Car> carsList = iCarRepository.findByDistanceAndFuel(kmsDriven,fuelType).stream().sorted(Comparator.comparing(Car::getBrand)).collect(Collectors.toList());
        if(carsList.isEmpty())
            throw new CarNotFoundException("cars of "+kmsDriven+" and "+fuelType+" are not found");
        return carsList;
    }

    @Override
    public List<Car> getByTransAndInsurance(String transmission, boolean insuranced) {
        List<Car> carsList = iCarRepository.findByTransAndInsurance(transmission,insuranced).stream().sorted(Comparator.comparing(Car::getBrand)).collect(Collectors.toList());
        if(carsList.isEmpty())
            throw new CarNotFoundException("cars of "+transmission+" and "+insuranced+" are not found");
        return carsList;
    }

    @Override
    public List<Car> getBySeatsAndPickup(int noOfSeats, String pickupType) {
        List<Car> carsList = iCarRepository.findBySeatsAndPickup(noOfSeats,pickupType).stream().sorted(Comparator.comparing(Car::getBrand)).collect(Collectors.toList());
        if(carsList.isEmpty())
            throw new CarNotFoundException("cars of "+noOfSeats+" and "+pickupType+" are not found");
        return carsList;
    }

    @Override
    public List<Car> getByTypeAndPrice(String carType, double pricePerHour) {
        List<Car> carsList = iCarRepository.findByTypeAndPrice(carType,pricePerHour).stream().sorted(Comparator.comparing(Car::getBrand)).collect(Collectors.toList());
        if(carsList.isEmpty())
            throw new CarNotFoundException("cars of "+carType+" and "+pricePerHour+" are not found");
        return carsList;
    }

    @Override
    public List<Car> getByBrandAndPickupAndSeats(String brand, String pickupType, int noOfSeats) {
        List<Car> carsList = iCarRepository.findByBrandAndPickupAndSeats(brand,pickupType,noOfSeats).stream().sorted(Comparator.comparing(Car::getBrand)).collect(Collectors.toList());
        if(carsList.isEmpty())
            throw new CarNotFoundException("cars of "+brand+" , "+pickupType+" and"+noOfSeats+" are not found");
        return carsList;
    }

    @Override
    public List<Car> getByMileageAndRatingAndType(int mileage, double rating, String carType) {
        List<Car> carsList = iCarRepository.findByMileageAndRatingAndType(mileage,rating,carType).stream().sorted(Comparator.comparing(Car::getBrand)).collect(Collectors.toList());
        if(carsList.isEmpty())
            throw new CarNotFoundException("cars of "+mileage+" , "+rating+" and"+carType+" are not found");
        return carsList;
    }
}
