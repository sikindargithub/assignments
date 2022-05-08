package com.carapp.exceptions;

public class BookingNotFoundException extends RuntimeException {

	public BookingNotFoundException() {

	}

	public BookingNotFoundException(String message) {
		super(message);
	}

}
