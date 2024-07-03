package com.app.eventBooking.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

import static jakarta.persistence.EnumType.STRING;

@Setter
@Getter
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Event event;
    @OneToOne
    private Attendee attendee;
    private Long paymentId;
    @Enumerated(value = STRING)
    private TicketType ticketType;
    @Column(nullable = false)
    private BigDecimal price;
}
