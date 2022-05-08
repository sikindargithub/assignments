package com.carapp.repository;

import com.carapp.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarRepository extends JpaRepository<Car,Integer> {

    // derived methods
    List<Car> findByBrandAndModel(String brand, String model);
    List<Car> findByMileage(int mileage);
    List<Car> findByPricePerHourLessThan(double pricePerHour);
    List<Car> findByNoOfSeats(int noOfSeats);
    List<Car> findByColorAndRating(String color,double rating);
    List<Car> findByRatingAndMileage(double rating,int mileage);


    // custom queries
    @Query("from Car c where c.kmsDriven < ?1 and c.fuelType = ?2")
    List<Car> findByDistanceAndFuel(double kmsDriven,String fuelType);
    @Query("from Car c where c.transmission = ?1 and c.insuranced = ?2")
    List<Car> findByTransAndInsurance(String transmission, boolean insuranced);
    @Query("from Car c where c.noOfSeats = ?1 and c.pickupType = ?2")
    List<Car> findBySeatsAndPickup(int noOfSeats,String pickupType);
    @Query("from Car c where c.carType = ?1 and c.pricePerHour = ?2")
    List<Car> findByTypeAndPrice(String carType,double pricePerHour);
    @Query("from Car c where c.brand = ?1 and c.pickupType = ?2 and c.noOfSeats = ?3")
    List<Car> findByBrandAndPickupAndSeats(String brand,String pickupType,int noOfSeats);
    @Query("from Car c where c.mileage = ?1 and c.rating = ?2 and c.carType = ?3")
    List<Car> findByMileageAndRatingAndType(int mileage,double rating,String carType);
}
