package com.carapp.service;

import com.carapp.model.Car;
import java.util.List;

public interface ICarService {

    void addCar(Car car);
    void updateCar(Car car);
    void deleteCar(int carNumber);
    List<Car> getAll();
    Car getById(int carNumber);

    // derived methods
    List<Car> getByBrandAndModel(String brand,String model);
    List<Car> getByMileage(int mileage);
    List<Car> getByPricePerHourLessThan(double pricePerHour);
    List<Car> getByNoOfSeats(int noOfSeats);
    List<Car> getByColorAndRating(String color,double rating);
    List<Car> getByRatingAndMileage(double rating,int mileage);

    // custom queries
    List<Car> getByDistanceAndFuel(double kmsDriven, String fuelType);
    List<Car> getByTransAndInsurance(String transmission,boolean insuranced);
    List<Car> getBySeatsAndPickup(int noOfSeats,String pickupType);
    List<Car> getByTypeAndPrice(String carType,double pricePerHour);
    List<Car> getByBrandAndPickupAndSeats(String brand,String pickupType,int noOfSeats);
    List<Car> getByMileageAndRatingAndType(int mileage,double rating,String carType);
}
