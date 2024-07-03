package com.app.eventBooking.dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class TicketResponse {
    private Long ticketId;
    private Long eventId;
    private String ticketType;
    private BigDecimal price;
}
