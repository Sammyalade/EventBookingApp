package com.app.eventBooking.repositories;

import com.app.eventBooking.models.Event;
import com.app.eventBooking.models.Ticket;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TicketRepositoryTest {

    @Autowired
    private TicketRepository ticketRepository;

    @Test
    void testGuestRepository() {
        Ticket ticket = new Ticket();
        ticketRepository.save(ticket);
        assertThat(ticketRepository.count()).isEqualTo(1L);
    }
}
