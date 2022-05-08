package com.carrentalapp.repository;

import com.carrentalapp.model.Booking;
import com.carrentalapp.model.Car;
import com.carrentalapp.service.ICarRentalService;
import com.carrentalapp.util.AllQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
@Repository
public class BookingRepositoryImpl implements IBookingRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	ICarRentalService carRentalService;
	@Override
	public void rentCar(Booking bookingCar, int carNumber) {
		Date date1 = Date.valueOf(bookingCar.getDate());
		double totalCost = carRentalService.getByCarNumber(carNumber).getPricePerHour() * bookingCar.getNoOfDays();
		Object[] bookingArray = {bookingCar.getBookingId(),bookingCar.getName(),bookingCar.getGender(),date1,bookingCar.getTime(),
									bookingCar.getPhoneNo(),bookingCar.isPaymentDone(),bookingCar.getNoOfDays(),totalCost,carNumber};
		jdbcTemplate.update(AllQueries.BOOKINGQUERY,bookingArray);

	}

	@Override
	public Booking findById(int bookingId) {
		return jdbcTemplate.queryForObject(AllQueries.IDQUERY,new BookingMapper(),bookingId);
	}

	@Override
	public List<Booking> findByDate(Date date) {
		return jdbcTemplate.query(AllQueries.DATEQUERY,new BookingMapper(),date);
	}

	@Override
	public List<Booking> findByIsPaymentDone(boolean paymentDone) {
		return jdbcTemplate.query(AllQueries.PAYMENTQUERY,new BookingMapper(),paymentDone);
	}

	@Override
	public List<Booking> findByLesserPrice(double totalCost) {
		return jdbcTemplate.query(AllQueries.LESSERPRICEQUERY,new BookingMapper(),totalCost);
	}
}
