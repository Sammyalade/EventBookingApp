package com.app.eventBooking.repositories;

import com.app.eventBooking.models.Organizer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OrganizerRepositoryTest {

    @Autowired
    private OrganizerRepository organizerRepository;

    @Test
    void testOrganizerRepository() {
        Organizer organizer = new Organizer();
        organizerRepository.save(organizer);
        assertThat(organizerRepository.count()).isEqualTo(1L);
    }
}