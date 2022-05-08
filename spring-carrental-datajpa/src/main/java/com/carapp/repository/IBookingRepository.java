package com.carapp.repository;

import com.carapp.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface IBookingRepository extends JpaRepository<Booking,Integer> {

			// derived queries
			Booking findByBookingId(int bookingId);
			List<Booking> findByDate(Date date);
			List<Booking> findByPaymentDone(boolean paymentDone);

			// custom query
			@Query("from Booking b where b.totalCost < ?1")
			List<Booking> findByCostLessThan(double totalCost);
			// named query
			@Query(name = "getByCarNumberAndDays")
			List<Booking> findByCarNumberAndDays(int carNumber,int noOfDays);
}
