package com.app.eventBooking.repositories;

import com.app.eventBooking.models.Attendee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AttendeeRepositoryTest {

    @Autowired
    private AttendeeRepository attendeeRepository;

    @Test
    void testAttendeeRepository() {
        Attendee attendee = new Attendee();
        attendeeRepository.save(attendee);
        assertThat(attendeeRepository.count()).isEqualTo(1L);
    }
}
