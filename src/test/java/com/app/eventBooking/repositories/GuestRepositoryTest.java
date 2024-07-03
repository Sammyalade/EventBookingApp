package com.app.eventBooking.repositories;

import com.app.eventBooking.models.Guest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class GuestRepositoryTest {

    @Autowired
    private GuestRepository guestRepository;

    @Test
    void testGuestRepository() {
        Guest guest = new Guest();
        guestRepository.save(guest);
        assertThat(guestRepository.count()).isEqualTo(1L);
    }
}
