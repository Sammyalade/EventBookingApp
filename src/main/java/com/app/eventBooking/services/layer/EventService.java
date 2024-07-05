package com.app.eventBooking.services.layer;

import com.app.eventBooking.exceptions.EventNotFoundException;
import com.app.eventBooking.models.Event;

public interface EventService {


    Event findById(Long id) throws EventNotFoundException;
}
