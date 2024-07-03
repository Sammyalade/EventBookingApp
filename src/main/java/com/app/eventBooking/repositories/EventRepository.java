package com.app.eventBooking.repositories;

import com.app.eventBooking.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
