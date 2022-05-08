package com.carrentalapp.repository;

import com.carrentalapp.model.Booking;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class BookingMapper implements RowMapper<Booking> {
    @Override
    public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {

        Booking booking = new Booking();
        booking.setBookingId(rs.getInt("bookingId"));
        booking.setName(rs.getString("name"));
        booking.setGender(rs.getString("gender"));
        Date date1 = rs.getDate("date");
        LocalDate date = date1.toLocalDate();
        booking.setDate(date);
        booking.setTime(rs.getTime("time"));
        booking.setPhoneNo(rs.getLong("phoneNo"));
        booking.setPaymentDone(rs.getBoolean("paymentDone"));
        booking.setNoOfDays(rs.getInt("noOfDays"));
        booking.setTotalCost(rs.getDouble("totalCost"));
        booking.setCarNumber(rs.getInt("carNumber"));
        return booking;
    }
}
