package com.app.eventBooking.exceptions;

public class GuestNotFoundException extends EventBookingException{
    public GuestNotFoundException(String message) {
        super(message);
    }
}
