package com.app.eventBooking.dtos.request;

import com.app.eventBooking.models.Attendee;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class TicketRequest {

    private EventRequest event;
    private AttendeeRequest attendee;
    private Long paymentId;
    private String ticketType;
    private BigDecimal price;
}
