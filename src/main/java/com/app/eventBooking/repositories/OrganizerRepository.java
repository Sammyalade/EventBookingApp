package com.app.eventBooking.repositories;

import com.app.eventBooking.models.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
}
