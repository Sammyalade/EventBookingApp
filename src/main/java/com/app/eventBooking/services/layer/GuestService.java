package com.app.eventBooking.services.layer;

import com.app.eventBooking.dtos.request.GuestRequest;
import com.app.eventBooking.dtos.response.GuestResponse;
import com.app.eventBooking.models.Guest;

public interface GuestService {

    GuestResponse createGuest(GuestRequest guestRequest);
    GuestResponse updateGuest(GuestRequest guestRequest);
    GuestResponse deleteGuest(GuestRequest guestRequest);

}
