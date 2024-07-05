package com.app.eventBooking.services.impl;

import com.app.eventBooking.exceptions.EventNotFoundException;
import com.app.eventBooking.models.Event;
import com.app.eventBooking.repositories.EventRepository;
import com.app.eventBooking.services.layer.AttendeeService;
import com.app.eventBooking.services.layer.EventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventBookingEventImpl implements EventService {

    private EventRepository eventRepository;

    @Override
    public Event findById(Long id) throws EventNotFoundException {
        return eventRepository.findById(id).orElseThrow(
                ()-> new EventNotFoundException("Event does not exist")
        );
    }
}
