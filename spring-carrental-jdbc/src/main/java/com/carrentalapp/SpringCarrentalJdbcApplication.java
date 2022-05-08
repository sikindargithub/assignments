package com.carrentalapp;

import com.carrentalapp.model.Booking;
import com.carrentalapp.model.Car;
import com.carrentalapp.service.IBookingService;
import com.carrentalapp.service.ICarRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpringCarrentalJdbcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringCarrentalJdbcApplication.class, args);
	}
	@Autowired
	IBookingService iBookingService;
	@Autowired
	ICarRentalService iCarRentalService;

	@Override
	public void run(String... args) throws Exception {

		Car car1 = new Car(2764 ,"Suzuki " ,"SZ892", 80,8,450);
//		iCarRentalService.addCar( car1);
		Car car2 = new Car(3458 ,"Benz " ,"B1234", 76,4,369);
//		iCarRentalService.addCar( car2);
		Car car3 = new Car(3730 ,"Ferrari " ,"FR923", 100,6,450);
//		iCarRentalService.addCar( car3);
		Car car4 = new Car(3920 ,"Toyota" ,"Ty892", 75,4,300);
//		iCarRentalService.addCar( car4);
		Car car5 = new Car(6789 ,"Hyundai " ,"HD345", 70,6,250);
//		iCarRentalService.addCar( car5);
//
		// Car methods
//		iCarRentalService.deleteCar(6789);
//		iCarRentalService.updateCar(3920,350);
//		iCarRentalService.getAllCars().forEach(System.out::println);
//		iCarRentalService.getByBrandAndSeats("Ferrari",6).forEach(System.out::println);
//		iCarRentalService.getByMileage(76).forEach(System.out::println);
//		iCarRentalService.getByPricePerHour(450).forEach(System.out::println);

		Booking bookingCar1 = new Booking(89124232,"sikindar","male", LocalDate.of(2022,4,24), Time.valueOf("09:15:36"),790568963,true,4);
		Booking bookingCar2 = new Booking(87210822,"nagender","male", LocalDate.of(2021,5,16), Time.valueOf("06:10:30"),879056896,false,7);
		Booking bookingCar3 = new Booking(98721737,"lakshmi","female", LocalDate.of(2019,6,12), Time.valueOf("04:12:46"),951551597,true,5);
		Booking bookingCar4 = new Booking(91837273,"manikanta","male", LocalDate.of(2018,2,18), Time.valueOf("03:10:55"),951551237,false,6);
//		iBookingService.rentCar(bookingCar1,2764);
//		iBookingService.rentCar(bookingCar2,2764);
//		iBookingService.rentCar(bookingCar3,2764);
//		iBookingService.rentCar(bookingCar4,2764);

		// Booking methods
//		System.out.println(iBookingService.getById(91837273));
//		iBookingService.getByDate(LocalDate.parse("2019-06-12")).forEach(System.out::println);
//		iBookingService.getByPaymentDone(true).forEach(System.out::println);

	}
}
