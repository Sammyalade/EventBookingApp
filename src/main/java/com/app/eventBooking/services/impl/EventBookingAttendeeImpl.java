package com.app.eventBooking.services.impl;

import com.app.eventBooking.exceptions.AttendeeNotFoundException;
import com.app.eventBooking.models.Attendee;
import com.app.eventBooking.repositories.AttendeeRepository;
import com.app.eventBooking.services.layer.AttendeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventBookingAttendeeImpl implements AttendeeService {

    private AttendeeRepository attendeeRepository;

    @Override
    public Attendee findById(Long id) throws AttendeeNotFoundException {
        return attendeeRepository.findById(id).orElseThrow(
                ()-> new AttendeeNotFoundException("Attendee not available")
        );
    }
}
