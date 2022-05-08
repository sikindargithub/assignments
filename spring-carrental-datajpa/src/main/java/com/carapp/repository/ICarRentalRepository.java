package com.carapp.repository;

import com.carapp.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICarRentalRepository extends JpaRepository<Car,Integer> {

	// derived queries
	List<Car> findAll();
	List<Car> findByMileage(int mileage);
	List<Car> findByPricePerHour(double pricePerHour);


	// custom queries
	@Query("from Car c where c.brand = ?1 and c.noOfSeats = ?2")
	List<Car> findByBrandAndSeats(String brand,int noOfSeats);
	@Query("from Car c where c.brand = ?1 and c.mileage = ?2 and c.pricePerHour = ?3")
	List<Car> findByBrandAndMileageAndPricePerHour(String brand,int mileage,double pricePerHour);
	@Query("from Car c where c.mileage = ?1 and c.brand = ?2 and c.model = ?3")
	List<Car> findByMileageAndBrandAndModel(int mileage,String brand,String model);
	@Query("from Car c where c.carNumber = ?1")
	Car findByCarNumber(int carNumber);

}
