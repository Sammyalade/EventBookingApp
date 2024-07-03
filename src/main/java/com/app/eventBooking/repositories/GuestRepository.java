package com.app.eventBooking.repositories;

import com.app.eventBooking.models.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
