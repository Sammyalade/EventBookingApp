package com.app.eventBooking.services.layer;

import com.app.eventBooking.exceptions.AttendeeNotFoundException;
import com.app.eventBooking.models.Attendee;

public interface AttendeeService {

    Attendee findById(Long id) throws AttendeeNotFoundException;
}
