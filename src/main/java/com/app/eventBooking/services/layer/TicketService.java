package com.app.eventBooking.services.layer;

import com.app.eventBooking.dtos.request.TicketRequest;
import com.app.eventBooking.dtos.response.TicketResponse;
import com.app.eventBooking.models.Ticket;

public interface TicketService {

    TicketResponse createTicket(TicketRequest request);
}
