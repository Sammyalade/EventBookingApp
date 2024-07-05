package com.app.eventBooking.services.layer;

import com.app.eventBooking.exceptions.OrganizerNotFoundException;
import com.app.eventBooking.models.Organizer;

public interface OrganizerService {

    Organizer findById(Long id) throws OrganizerNotFoundException;
}
