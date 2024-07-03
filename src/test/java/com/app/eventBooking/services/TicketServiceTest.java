package com.app.eventBooking.services;

import com.app.eventBooking.dtos.request.AttendeeRequest;
import com.app.eventBooking.dtos.request.EventRequest;
import com.app.eventBooking.dtos.request.TicketRequest;
import com.app.eventBooking.dtos.response.TicketResponse;
import com.app.eventBooking.services.layer.TicketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class TicketServiceTest {

    @Autowired
    private TicketService ticketService;

    @Test
    @Sql(scripts = {"/db/data.sql"})
    public void createTicket_ticketIsCreatedTest(){
        TicketRequest request = new TicketRequest();
        AttendeeRequest attendeeRequest = new AttendeeRequest();
        attendeeRequest.setId(100L);
        EventRequest eventRequest = new EventRequest();
        eventRequest.setId(200L);
        request.setEvent(eventRequest);
        request.setPaymentId(1234367673L);
        request.setAttendee(attendeeRequest);
        request.setTicketType("VIP");
        request.setPrice(BigDecimal.valueOf(20000));
        TicketResponse response = ticketService.createTicket(request);
        assertThat(response).isNotNull();
        assertThat(response.getTicketId()).isNotNull();
    }
}
