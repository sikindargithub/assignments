package com.carrentalapp.exceptions;

public class BookingNotFoundException extends RuntimeException{
    public BookingNotFoundException() {
        super();
    }

    public BookingNotFoundException(String message) {
        super(message);
    }
}
