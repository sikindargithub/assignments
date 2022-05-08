package com.carapp.service;

import com.carapp.model.Booking;
import com.carapp.exceptions.BookingNotFoundException;
import java.time.LocalDate;
import java.util.List;

public interface IBookingService {

		void rentCar(Booking bookingCar, int carNumber);
		Booking getById(int bookingId) throws BookingNotFoundException;

		// derived queries
		List<Booking> getByDate(LocalDate date) throws BookingNotFoundException;
		List<Booking> getByPaymentDone(boolean paymentDone) throws BookingNotFoundException;

		// custom query
		List<Booking> getByCostLessThan(double totalCost) throws BookingNotFoundException;

		// named query
		List<Booking> getByCarNumberAndDays(int carNumber,int noOfDays) throws BookingNotFoundException;
}
