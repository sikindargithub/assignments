package com.carapp;

import com.carapp.model.Booking;
import com.carapp.model.Car;
import com.carapp.service.IBookingService;
import com.carapp.service.ICarRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.sql.Time;

@SpringBootApplication
public class SpringCarDatajpaApplication implements CommandLineRunner {

	ICarRentalService iCarRentalService;
	@Autowired
	public void setiCarRentalService(ICarRentalService iCarRentalService) {
		this.iCarRentalService = iCarRentalService;
	}

	IBookingService iBookingService;
	@Autowired
	public void setiBookingService(IBookingService iBookingService) {
		this.iBookingService = iBookingService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCarDatajpaApplication.class, args);
	}


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

		Booking bookingCar1 = new Booking(89124232,"sikindar","male", Date.valueOf("2022-04-13"), Time.valueOf("09:15:36"),177911264,true,4);
//		iBookingService.rentCar(bookingCar1,2764);
		Booking bookingCar2 = new Booking(87210822,"nagender","male", Date.valueOf("2021-05-16"), Time.valueOf("06:10:30"),879056896,false,7);
		Booking bookingCar3 = new Booking(98721737,"lakshmi","female", Date.valueOf("2019-06-12"), Time.valueOf("04:12:46"),951551597,true,5);
		Booking bookingCar4 = new Booking(91837273,"manikanta","male", Date.valueOf("2018-02-18"), Time.valueOf("03:10:55"),951551237,false,6);
//		iBookingService.rentCar(bookingCar2,3458);
//		iBookingService.rentCar(bookingCar3,3730);
//		iBookingService.rentCar(bookingCar4,3920);
		// Car methods
//		iCarRentalService.getAllCars().forEach(System.out::println);
//		iCarRentalService.getByMileage(76).forEach(System.out::println);
//		iCarRentalService.getByPricePerHour(450).forEach(System.out::println);
//		iCarRentalService.getByBrandAndSeats("toyota",4).forEach(System.out::println);
//		iCarRentalService.getByBrandAndMileageAndPricePerHour("suzuki",80,450).forEach(System.out::println);
//		iCarRentalService.getByMileageAndBrandAndModel(75,"toyota","Ty892").forEach(System.out::println);
//		System.out.println(iCarRentalService.getByCarNumber(2764));
		// Booking methods
//		System.out.println(iBookingService.getById(89124232));
//		iBookingService.getByDate(Date.valueOf("2019-06-12").toLocalDate()).forEach(System.out::println);
//		iBookingService.getByCostLessThan(3000).forEach(System.out::println);
//		iBookingService.getByPaymentDone(true).forEach(System.out::println);
//		iBookingService.getByCarNumberAndDays(3730,5).forEach(System.out::println);


	}
}
