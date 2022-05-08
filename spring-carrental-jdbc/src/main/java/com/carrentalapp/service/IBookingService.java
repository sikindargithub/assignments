package com.carrentalapp.service;

import com.carrentalapp.exceptions.BookingNotFoundException;
import com.carrentalapp.model.Booking;

import java.time.LocalDate;
import java.util.List;

public interface IBookingService {

	//called by Admin
		void rentCar(Booking bookingCar,int carNumber);
		Booking getById(int bookingId) throws BookingNotFoundException;
		List<Booking> getByDate(LocalDate date) throws BookingNotFoundException;
		List<Booking> getByPaymentDone(boolean paymentDone) throws BookingNotFoundException;
}
