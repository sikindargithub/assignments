package com.carapp.service;

import com.carapp.exceptions.BookingNotFoundException;
import com.carapp.model.Booking;
import com.carapp.repository.IBookingRepository;
import com.carapp.repository.ICarRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class BookingServiceImpl implements IBookingService {


	IBookingRepository bookingRepository;
	@Autowired
	public void setBookingRepository(IBookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}

	ICarRentalRepository iCarRentalRepository;
	@Autowired
	public void setiCarRentalRepository(ICarRentalRepository iCarRentalRepository) {
		this.iCarRentalRepository = iCarRentalRepository;
	}

	@Override
	public void rentCar(Booking bookingCar, int carNumber) {

		double totalCost = iCarRentalRepository.findByCarNumber(carNumber).getPricePerHour() * bookingCar.getNoOfDays();
		Booking booking = new Booking(bookingCar.getBookingId(),bookingCar.getName(),bookingCar.getGender(),bookingCar.getDate(),bookingCar.getTime(),
				bookingCar.getPhoneNo(),bookingCar.isPaymentDone(),bookingCar.getNoOfDays(),totalCost,carNumber);
		bookingRepository.save(booking);
	}

	@Override
	public Booking getById(int bookingId) throws BookingNotFoundException {
		return bookingRepository.findById(bookingId).orElseThrow(()->new BookingNotFoundException("Invalid booking id"));
	}

	@Override
	public List<Booking> getByDate(LocalDate date) throws BookingNotFoundException {
		Date date1 = Date.valueOf(date);
		List<Booking> bookingsByDate =  bookingRepository.findByDate(date1).stream().sorted(Comparator.comparing(Booking::getName)).collect(Collectors.toList());
		if(bookingsByDate.isEmpty())
			throw new BookingNotFoundException("bookings on "+date+" are not found");
		return bookingsByDate;
	}

	@Override
	public List<Booking> getByPaymentDone(boolean paymentDone) throws BookingNotFoundException {
		List<Booking> bookingsByPayment = bookingRepository.findByPaymentDone(paymentDone).stream().sorted(Comparator.comparing(Booking::getName)).collect(Collectors.toList());
		if(bookingsByPayment.isEmpty())
			throw new BookingNotFoundException("bookings of payment status "+paymentDone+" are not found");
		return bookingsByPayment;
	}

	@Override
	public List<Booking> getByCostLessThan(double totalCost) throws BookingNotFoundException {
		List<Booking> bookingsByCost = bookingRepository.findByCostLessThan(totalCost).stream().sorted(Comparator.comparing(Booking::getName)).collect(Collectors.toList());
		if(bookingsByCost.isEmpty())
			throw new BookingNotFoundException("bookings of cost less than "+totalCost+" are not found");
		return bookingsByCost;
	}

	@Override
	public List<Booking> getByCarNumberAndDays(int carNumber, int noOfDays) throws BookingNotFoundException {
		List<Booking> bookingsByCarNumberAndDays= bookingRepository.findByCarNumberAndDays(carNumber,noOfDays).stream().sorted(Comparator.comparing(Booking::getName)).collect(Collectors.toList());
		if(bookingsByCarNumberAndDays.isEmpty())
			throw new BookingNotFoundException("bookings of car number "+carNumber+" and no of days "+noOfDays+" are not found");
		return bookingsByCarNumberAndDays;
	}
}
