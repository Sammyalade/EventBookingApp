package com.app.eventBooking.services.layer;

import com.app.eventBooking.dtos.request.GuestRequest;
import com.app.eventBooking.dtos.response.GuestDeleteResponse;
import com.app.eventBooking.dtos.response.GuestResponse;
import com.app.eventBooking.exceptions.*;
import com.app.eventBooking.models.Guest;

import java.io.IOException;

public interface GuestService {

    GuestResponse createGuest(GuestRequest guestRequest) throws AttendeeNotFoundException, OrganizerNotFoundException, EventNotFoundException, GuestInviteViolationException;
    GuestResponse updateGuest(GuestRequest guestRequest) throws GuestNotFoundException, IOException;
    GuestDeleteResponse deleteGuest(GuestRequest guestRequest) throws GuestNotFoundException, OrganizerNotFoundException, AttendeeNotFoundException;
    Guest findById(Long id) throws GuestNotFoundException;

}
