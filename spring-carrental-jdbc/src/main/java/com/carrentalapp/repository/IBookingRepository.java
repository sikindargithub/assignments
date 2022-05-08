package com.carrentalapp.repository;

import com.carrentalapp.model.Booking;

import java.sql.Date;
import java.util.List;

public interface IBookingRepository {
	
			//for knowing booking details of customers
			void rentCar(Booking bookingCar, int carNumber);
			Booking findById(int bookingId);
			List<Booking> findByDate(Date date);
			List<Booking> findByIsPaymentDone(boolean paymentDone);
			List<Booking> findByLesserPrice(double totalCost);
}
