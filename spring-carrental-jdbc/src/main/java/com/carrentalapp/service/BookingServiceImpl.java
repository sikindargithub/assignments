package com.carrentalapp.service;

import com.carrentalapp.model.Car;
import com.carrentalapp.repository.BookingRepositoryImpl;
import com.carrentalapp.repository.IBookingRepository;
import com.carrentalapp.exceptions.BookingNotFoundException;
import com.carrentalapp.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class BookingServiceImpl implements IBookingService {

	@Autowired
	IBookingRepository bookingRepository;
	@Override
	public void rentCar(Booking bookingCar, int carNumber) {
		bookingRepository.rentCar(bookingCar,carNumber);
	}

	@Override
	public Booking getById(int bookingId) throws BookingNotFoundException {
		Booking booking = bookingRepository.findById(bookingId);
		if(booking==null)
			throw new BookingNotFoundException("Invalid id ");
		return booking;

	}

	@Override
	public List<Booking> getByDate(LocalDate date) throws BookingNotFoundException {
		Date date1 = Date.valueOf(date);
		List<Booking> bookingsByDate = bookingRepository.findByDate(date1).stream().sorted(Comparator.comparing(Booking::getName)).collect(Collectors.toList());
		if(bookingsByDate.isEmpty())
			throw new BookingNotFoundException("bookings on date "+date+" are not found");
		return bookingsByDate;
	}

	@Override
	public List<Booking> getByPaymentDone(boolean paymentDone) throws BookingNotFoundException {
		List<Booking> bookingsByPayment =  bookingRepository.findByIsPaymentDone(paymentDone).stream().sorted(Comparator.comparing(Booking::getName)).collect(Collectors.toList());
		if(bookingsByPayment.isEmpty())
			throw new BookingNotFoundException("bookings of payment status "+paymentDone+" are not found");
		return bookingsByPayment;
	}
}
