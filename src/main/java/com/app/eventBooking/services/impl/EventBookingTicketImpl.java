package com.app.eventBooking.services.impl;

import com.app.eventBooking.dtos.request.TicketRequest;
import com.app.eventBooking.dtos.response.TicketResponse;
import com.app.eventBooking.models.Ticket;
import com.app.eventBooking.repositories.TicketRepository;
import com.app.eventBooking.services.layer.TicketService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventBookingTicketImpl implements TicketService {

    private ModelMapper mapper;
    private TicketRepository ticketRepository;

    @Override
    public TicketResponse createTicket(TicketRequest request) {
        Ticket ticket = mapper.map(request, Ticket.class);
        ticketRepository.save(ticket);
        return mapper.map(ticket, TicketResponse.class);
    }
}
