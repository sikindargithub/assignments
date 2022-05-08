package com.carrentalapp.repository;

import com.carrentalapp.model.Car;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper implements RowMapper<Car> {
    @Override
    public Car mapRow(ResultSet rs, int rowNum) throws SQLException {

        Car car = new Car();
        car.setCarNumber(rs.getInt("carNumber"));
        car.setBrand(rs.getString("brand"));
        car.setModel(rs.getString("model"));
        car.setMileage(rs.getInt("mileage"));
        car.setNoOfSeats(rs.getInt("noOfSeats"));
        car.setPricePerHour(rs.getDouble("pricePerHour"));
        return car;
    }
}
