package com.carrentalapp.exceptions;

public class CarNotFoundException extends RuntimeException{
    public CarNotFoundException() {
    }

    public CarNotFoundException(String message) {
        super(message);
    }
}
