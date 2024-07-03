package com.app.eventBooking.repositories;

import com.app.eventBooking.models.Discount;
import com.app.eventBooking.models.Event;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EventRepositoryTest {

    @Autowired
    private EventRepository eventRepository;

    @Test
    void testGuestRepository() {
        Event event = new Event();
        eventRepository.save(event);
        assertThat(eventRepository.count()).isEqualTo(1L);
    }
}
