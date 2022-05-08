package com.carrentalapp.repository;

import com.carrentalapp.model.Car;
import com.carrentalapp.util.AllQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CarRentalRepositoryImpl implements ICarRentalRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public void addCar(Car car) {

		Object[] carArray = {car.getCarNumber(),car.getBrand(),car.getModel(), car.getMileage(),car.getNoOfSeats(),car.getPricePerHour()};
		jdbcTemplate.update(AllQueries.ADDQUERY,carArray);
	}

	@Override
	public void deleteCar(int carNumber) {
		jdbcTemplate.update(AllQueries.DELETEQUERY,carNumber);
	}

	@Override
	public void updateCar(int carNumber, double pricePerHour) {
		jdbcTemplate.update(AllQueries.UPDATEQUERY,pricePerHour,carNumber);
	}



	@Override
	public List<Car> findAllCars() {
		return jdbcTemplate.query(AllQueries.ALLQUERY,new CarMapper());
	}

	@Override
	public Car findByCarNumber(int carNumber) {
		return jdbcTemplate.queryForObject(AllQueries.SINGLECAR,new CarMapper(),carNumber);
	}


	@Override
	public List<Car> findByBrandAndSeats(String brand, int noOfSeats) {
		return jdbcTemplate.query(AllQueries.BRANDANDSEATSQUERY,new CarMapper(),noOfSeats);
	}

	@Override
	public List<Car> findByMileage(int mileage) {
		return jdbcTemplate.query(AllQueries.MILEAGEQUERY,new CarMapper(),mileage);
	}

	@Override
	public List<Car> findByPricePerHour(double pricePerHour) {
		return jdbcTemplate.query(AllQueries.PRICEQUERY,new CarMapper(),pricePerHour);
	}
}
