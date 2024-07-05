package com.app.eventBooking.exceptions;

public class EventNotFoundException extends EventBookingException{
    public EventNotFoundException(String message) {
        super(message);
    }
}
