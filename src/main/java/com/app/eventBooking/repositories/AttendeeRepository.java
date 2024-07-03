package com.app.eventBooking.repositories;

import com.app.eventBooking.models.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendeeRepository extends JpaRepository<Attendee, Long> {
}
